package pl.muller.diety.sniadanie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.sniadanie.model.SausageData;

@Repository
public interface SausageRepo extends CrudRepository<SausageData, Long> {

}
