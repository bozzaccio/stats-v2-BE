package stats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stats.components.GetAllRacesComponent;
import stats.components.GetRaceComponent;
import stats.dto.ConstructorDTO;
import stats.dto.RaceDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RaceController {

    @Autowired
    private GetRaceComponent getRaceComponent;

    @Autowired
    private GetAllRacesComponent getAllRacesComponent;

    @GetMapping("/races")
    public List<RaceDTO> getAll() {
        return getAllRacesComponent.getAllRaces();
    }

    @GetMapping("/races/{id}")
    public ResponseEntity<RaceDTO> getById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        RaceDTO dto = null;
        try {
            dto = getRaceComponent.getRace(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Race not found for this id :: " + id);
        }
        return ResponseEntity.ok(dto);
    }
}
