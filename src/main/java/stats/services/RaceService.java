package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stats.dto.ConstructorDTO;
import stats.dto.DriverDTO;
import stats.entities.Constructor;
import stats.entities.Driver;
import stats.repositories.IConstructorRepository;
import stats.repositories.IDriverRepository;
import stats.repositories.IRaceRepository;
import stats.dto.RaceDTO;
import stats.entities.Race;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

@Service
public class RaceService implements IBaseService<Race, RaceDTO> {

    @Autowired
    private IRaceRepository raceRepository;

    @Autowired
    private IConstructorRepository constructorRepository;

    @Autowired
    private IDriverRepository driverRepository;

    @Autowired
    private IBaseService<Constructor, ConstructorDTO> constructorService;

    @Autowired
    private IBaseService<Driver, DriverDTO> driverService;

    @Override
    public void loadData() throws IOException {

        raceRepository.deleteAll();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/csv/races.csv"));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            Race race = new Race();

            race.setId(Integer.parseInt(data[0]));
            race.setName(data[2]);
            race.setDate(Date.valueOf(data[3]));
            race.setUrl(data[5]);
            race.setPoleDriverId(Integer.parseInt(data[6]));
            race.setWinDriverId(Integer.parseInt(data[7]));
            race.setWinConstructorId(Integer.parseInt(data[8]));

            raceRepository.save(race);
        }
    }

    @Override
    public RaceDTO transformEntity2DTO(Race entity) {

        RaceDTO dto = new RaceDTO();

        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setName(entity.getName());
        dto.setUrl(entity.getUrl());

        Optional<Constructor> constructor = constructorRepository.findById(entity.getWinConstructorId());

        if (constructor.isPresent()) {
            ConstructorDTO winConstructor = constructorService.transformEntity2DTO(constructor.get());
            dto.setWinConstructor(winConstructor);
        }

        Optional<Driver> driver = driverRepository.findById(entity.getWinDriverId());

        if (driver.isPresent()) {
            DriverDTO winDriver = driverService.transformEntity2DTO(driver.get());
            dto.setWinDriver(winDriver);
        }

        Optional<Driver> driverPole = driverRepository.findById(entity.getPoleDriverId());

        if (driverPole.isPresent()) {
            DriverDTO winDriver = driverService.transformEntity2DTO(driverPole.get());
            dto.setPoleDriver(winDriver);
        }

        return dto;
    }
}
