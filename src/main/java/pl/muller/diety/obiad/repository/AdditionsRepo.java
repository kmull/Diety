package pl.muller.diety.obiad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.obiad.model.AdditionsData;

@Repository
public interface AdditionsRepo extends CrudRepository<AdditionsData, Long> {

}
