package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stats.dto.DriverDTO;
import stats.entities.Driver;
import stats.repositories.IDriverRepository;
import stats.repositories.IRaceRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class DriverService implements IBaseService<Driver, DriverDTO> {

    @Autowired
    private IDriverRepository driverRepository;

    @Autowired
    private IRaceRepository raceRepository;

    @Override
    public void loadData() throws IOException {

        driverRepository.deleteAll();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/csv/drivers.csv"));
        String line;

        while ((line = bufferedReader.readLine()) != null){
            String[] data = line.split(",");
            Driver driver = new Driver();

            driver.setId(Integer.parseInt(data[0]));
            driver.setNumber(Integer.parseInt(data[2]));
            driver.setCode(data[3]);
            driver.setName(data[4]);
            driver.setSurname(data[5]);
            driver.setNationality(data[7]);
            driver.setUrl(data[8]);

            driverRepository.save(driver);
        }
    }

    @Override
    public DriverDTO transformEntity2DTO(Driver entity) {

        DriverDTO dto = new DriverDTO();

        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setNationality(entity.getNationality());
        dto.setNumber(entity.getNumber());
        dto.setSurname(entity.getSurname());
        dto.setUrl(entity.getUrl());

        dto.setRaceSeasonWin(raceRepository.countRaceWinByDriverId(entity.getId()).intValue());

        dto.setPoleSeason(raceRepository.countPolePositionByDriverId(entity.getId()).intValue());

        return dto;
    }
}
