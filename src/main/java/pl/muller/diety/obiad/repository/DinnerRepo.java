package pl.muller.diety.obiad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.muller.diety.obiad.model.DinnerData;

@Repository
public interface DinnerRepo extends CrudRepository<DinnerData, Long> {

//	@Query("select coalesce(min(t.id) + 1, 0)"
//			+ "from obiad_danie_glowne t left outer join"
//			+ "     obiad_danie_glowne t2"
//			+ "     on t.id = t2.id - 1"
//			+ "where t2.id is null")
//	public Long getId();
//	
}
