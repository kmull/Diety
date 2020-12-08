package pl.muller.diety.sniadanie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.sniadanie.model.BreadData;

@Repository
public interface BreadRepo extends CrudRepository<BreadData, Long> {

}
