package pl.muller.diety.obiad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.general.model.DietaData;

@Repository
public interface MainRepo extends CrudRepository<DietaData, Long> {


//	@Query("Insert INTO zapisane_diety (name, date, dane) " 
//	+ "VALUES(:name, :date, :dane)")
//	void saveDiety(String name, LocalDate date, String[] dane);
}

//INSERT INTO table_name
//VALUES (value1, value2, value3, ...);