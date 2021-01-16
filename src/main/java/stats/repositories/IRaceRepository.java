package stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stats.entities.Race;

@Repository
public interface IRaceRepository extends JpaRepository<Race, Integer>, CrudRepository<Race, Integer> {

    @Query("SELECT count(*) FROM Race e WHERE e.winConstructorId = :constructorId")
    Long countRaceWinByConstructorId(@Param("constructorId") int id);
}
