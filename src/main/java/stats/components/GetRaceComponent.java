package stats.components;

import org.springframework.stereotype.Component;
import stats.dto.RaceDTO;
import stats.entities.Race;
import stats.repositories.IRaceRepository;
import stats.services.IBaseService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class GetRaceComponent {

    private final IRaceRepository raceRepository;
    private final IBaseService<Race, RaceDTO> raceService;

    public GetRaceComponent(IRaceRepository raceRepository, IBaseService<Race, RaceDTO> raceService) {
        this.raceRepository = raceRepository;
        this.raceService = raceService;
    }

    public RaceDTO getRace(Long id) {

        Optional<Race> entity = raceRepository.findById(id.intValue());

        if (!entity.isPresent()) {
            throw new EntityNotFoundException();
        }

        return raceService.transformEntity2DTO(entity.get());
    }
}
