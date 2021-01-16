package stats.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stats.entities.Constructor;

@Repository
public interface IConstructorRepository extends CrudRepository<Constructor, Integer> {
}
