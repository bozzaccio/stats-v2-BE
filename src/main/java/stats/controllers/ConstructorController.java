package stats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stats.components.GetAllConstructorsComponent;
import stats.components.GetConstructorComponent;
import stats.dto.ConstructorDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ConstructorController {

    @Autowired
    private GetConstructorComponent getConstructorComponent;

    @Autowired
    private GetAllConstructorsComponent getAllConstructorsComponent;

    @GetMapping("/constructors")
    public List<ConstructorDTO> getAll() {
        return getAllConstructorsComponent.getAllConstructors();
    }

    @GetMapping("/constructors/{id}")
    public ResponseEntity<ConstructorDTO> getById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        ConstructorDTO dto = null;
        try {
            dto = getConstructorComponent.getConstructor(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Constructor not found for this id :: " + id);
        }
        return ResponseEntity.ok(dto);
    }
}
