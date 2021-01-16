package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stats.entities.Driver;
import stats.repositories.IConstructorRepository;
import stats.dto.ConstructorDTO;
import stats.entities.Constructor;
import stats.repositories.IDriverRepository;
import stats.repositories.IRaceRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Service
public class ConstructorService implements IBaseService<Constructor, ConstructorDTO> {

    @Autowired
    private IConstructorRepository constructorRepository;

    @Autowired
    private IRaceRepository raceRepository;

    @Autowired
    private IDriverRepository driverRepository;

    @Autowired
    private DriverService driverService;

    @Override
    public void loadData() throws IOException {

        constructorRepository.deleteAll();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/csv/constructors.csv"));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            Constructor constructor = new Constructor();

            constructor.setId(Integer.parseInt(data[0]));
            constructor.setName(data[2]);
            constructor.setNationality(data[3]);
            constructor.setUrl(data[4]);
            constructor.setFirstDriverId(Integer.parseInt(data[5]));
            constructor.setSecondDriverId(Integer.parseInt(data[6]));

            constructorRepository.save(constructor);
        }
    }

    @Override
    public ConstructorDTO transformEntity2DTO(Constructor entity) {

        ConstructorDTO dto = new ConstructorDTO();

        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        dto.setName(entity.getName());
        dto.setNationality(entity.getNationality());

        Optional<Driver> firstDriver = driverRepository.findById(entity.getFirstDriverId());

        firstDriver.ifPresent(driver -> dto.setFirstDriver(driverService.transformEntity2DTO(driver)));

        Optional<Driver> secondDriver = driverRepository.findById(entity.getSecondDriverId());
        secondDriver.ifPresent(driver -> dto.setSecondDriver(driverService.transformEntity2DTO(driver)));

        dto.setRaceSeasonWin(raceRepository.countRaceWinByConstructorId(entity.getId()));

        return dto;
    }
}
