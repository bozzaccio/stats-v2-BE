package stats.components;

import org.springframework.stereotype.Component;
import stats.dto.DriverDTO;
import stats.entities.Driver;
import stats.repositories.IDriverRepository;
import stats.services.IBaseService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class GetDriverComponent {

    private final IDriverRepository driverRepository;
    private final IBaseService<Driver, DriverDTO> driverService;

    public GetDriverComponent(IDriverRepository driverRepository, IBaseService<Driver, DriverDTO> driverService) {
        this.driverRepository = driverRepository;
        this.driverService = driverService;
    }

    public DriverDTO getDriver(Long id) {

        Optional<Driver> entity = driverRepository.findById(id.intValue());

        if (!entity.isPresent()) {
            throw new EntityNotFoundException();
        }

        return driverService.transformEntity2DTO(entity.get());
    }
}
