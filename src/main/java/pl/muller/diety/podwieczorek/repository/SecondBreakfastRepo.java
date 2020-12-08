package pl.muller.diety.podwieczorek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.podwieczorek.model.SecondBreakfastData;

@Repository
public interface SecondBreakfastRepo extends CrudRepository<SecondBreakfastData, Long> {

}