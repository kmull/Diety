package pl.muller.diety.podwieczorek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.podwieczorek.model.AfternoonSnackData;

@Repository
public interface AfternoonSnackRepo extends CrudRepository<AfternoonSnackData, Long> {

}