package pl.muller.diety.obiad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.obiad.model.SaladData;

@Repository
public interface SaladRepo extends CrudRepository<SaladData, Long> {

}
