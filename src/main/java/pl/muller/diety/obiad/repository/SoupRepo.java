package pl.muller.diety.obiad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.obiad.model.SoupData;

@Repository
public interface SoupRepo extends CrudRepository<SoupData, Long> {

//	select max(id) from table
//	@Query("select max(z.id) from zupa z")
//	public Long getSoupById();

//	@Query("SELECT z FROM zupa z WERE z.id=:id")
//	public Optional<SoupData> getSoup(Long id);
}
