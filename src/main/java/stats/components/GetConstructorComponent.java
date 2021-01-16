package stats.components;

import org.springframework.stereotype.Component;
import stats.dto.ConstructorDTO;
import stats.entities.Constructor;
import stats.repositories.IConstructorRepository;
import stats.services.IBaseService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class GetConstructorComponent {

    private final IConstructorRepository constructorRepository;
    private final IBaseService<Constructor, ConstructorDTO> constructorService;

    public GetConstructorComponent(IConstructorRepository constructorRepository, IBaseService<Constructor, ConstructorDTO> constructorService) {
        this.constructorRepository = constructorRepository;
        this.constructorService = constructorService;
    }

    public ConstructorDTO getConstructor(Long id) {

        Optional<Constructor> entity = constructorRepository.findById(id.intValue());

        if (!entity.isPresent()) {
            throw new EntityNotFoundException();
        }

        return constructorService.transformEntity2DTO(entity.get());
    }
}
