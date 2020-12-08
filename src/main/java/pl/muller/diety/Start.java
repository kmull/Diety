package pl.muller.diety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import pl.muller.diety.obiad.model.SoupData;
import pl.muller.diety.obiad.repository.SoupRepo;
import pl.muller.diety.service.DinnerService;

@Component
public class Start {

	@Autowired
	private SoupRepo zupaRepo;
	@Autowired
	private DinnerService dietySrvice;

	@EventListener(ApplicationReadyEvent.class)
	public void runExample() {
		Iterable<SoupData> all = zupaRepo.findAll();
		
		all.forEach(System.out::println);
	}

}
