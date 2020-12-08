package pl.muller.diety.sniadanie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.sniadanie.model.VegetableData;

@Repository
public interface VegetableRepo extends CrudRepository<VegetableData, Long> {

}
