package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stats.repositories.IRaceRepository;
import stats.dto.RaceDTO;
import stats.entities.Race;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

@Service
public class RaceService implements IBaseService<Race, RaceDTO> {

    @Autowired
    private IRaceRepository raceRepository;

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

        return dto;
    }
}
