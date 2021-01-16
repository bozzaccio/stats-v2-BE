package stats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stats.components.GetAllDriversComponent;
import stats.components.GetDriverComponent;
import stats.dto.DriverDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {

    @Autowired
    private GetDriverComponent getDriverComponent;

    @Autowired
    private GetAllDriversComponent getAllDriversComponent;

    @GetMapping("/drivers")
    public List<DriverDTO> getAll() {
        return getAllDriversComponent.getAllDrivers();
    }

    @GetMapping("/drivers/{id}")
    public ResponseEntity<DriverDTO> getById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        DriverDTO dto = null;
        try {
            dto = getDriverComponent.getDriver(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Driver not found for this id :: " + id);
        }
        return ResponseEntity.ok(dto);
    }
}
