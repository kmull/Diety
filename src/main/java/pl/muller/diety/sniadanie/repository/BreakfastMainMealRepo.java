package pl.muller.diety.sniadanie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.sniadanie.model.BreakfastMainMealData;

@Repository
public interface BreakfastMainMealRepo extends CrudRepository<BreakfastMainMealData, Long> {

}
