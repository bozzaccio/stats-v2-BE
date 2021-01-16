package stats.components;

import org.springframework.stereotype.Component;
import stats.dto.RaceDTO;
import stats.entities.Race;
import stats.repositories.IRaceRepository;
import stats.services.IBaseService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllRacesComponent {

    private final IRaceRepository raceRepository;
    private final IBaseService<Race, RaceDTO> raceService;

    public GetAllRacesComponent(IRaceRepository raceRepository, IBaseService<Race, RaceDTO> raceService) {
        this.raceRepository = raceRepository;
        this.raceService = raceService;
    }

    public List<RaceDTO> getAllRaces() {

        List<Race> races = raceRepository.findAll();

        return races.stream().map(raceService::transformEntity2DTO).collect(Collectors.toList());
    }
}
