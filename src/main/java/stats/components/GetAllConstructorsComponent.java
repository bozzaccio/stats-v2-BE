package stats.components;

import org.springframework.stereotype.Component;
import stats.dto.ConstructorDTO;
import stats.entities.Constructor;
import stats.repositories.IConstructorRepository;
import stats.services.IBaseService;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllConstructorsComponent {

    private final IConstructorRepository constructorRepository;
    private final IBaseService<Constructor, ConstructorDTO> constructorService;

    public GetAllConstructorsComponent(IConstructorRepository constructorRepository, IBaseService<Constructor, ConstructorDTO> constructorService) {
        this.constructorRepository = constructorRepository;
        this.constructorService = constructorService;
    }

    public List<ConstructorDTO> getAllConstructors() {

        Iterable<Constructor> constructors = constructorRepository.findAll();
        List<ConstructorDTO> response = new ArrayList<>();

        constructors.forEach(constructor -> {

            ConstructorDTO dto = new ConstructorDTO();
            dto = constructorService.transformEntity2DTO(constructor);
            response.add(dto);
        });

        return response;
    }

}
