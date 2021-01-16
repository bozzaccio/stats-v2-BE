package stats.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stats.entities.Driver;

@Repository
public interface IDriverRepository extends CrudRepository<Driver, Integer> {
}
