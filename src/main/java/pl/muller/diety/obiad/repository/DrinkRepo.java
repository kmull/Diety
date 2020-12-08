package pl.muller.diety.obiad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.general.model.DrinkData;

@Repository
public interface DrinkRepo extends CrudRepository<DrinkData, Long> {

}
