package stats.components;

import org.springframework.stereotype.Component;
import stats.dto.DriverDTO;
import stats.entities.Driver;
import stats.repositories.IDriverRepository;
import stats.services.IBaseService;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllDriversComponent {

    private final IDriverRepository driverRepository;
    private final IBaseService<Driver, DriverDTO> driverService;

    public GetAllDriversComponent(IDriverRepository driverRepository, IBaseService<Driver, DriverDTO> driverService) {
        this.driverRepository = driverRepository;
        this.driverService = driverService;
    }

    public List<DriverDTO> getAllDrivers() {

        Iterable<Driver> drivers = driverRepository.findAll();
        List<DriverDTO> response = new ArrayList<>();

        drivers.forEach(driver -> {

            DriverDTO dto = new DriverDTO();
            dto = driverService.transformEntity2DTO(driver);
            response.add(dto);
        });

        return response;
    }
}
