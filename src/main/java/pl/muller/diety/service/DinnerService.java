package pl.muller.diety.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.muller.diety.general.model.ModelData;
import pl.muller.diety.obiad.model.AdditionsData;
import pl.muller.diety.obiad.model.DinnerData;
import pl.muller.diety.obiad.model.SaladData;
import pl.muller.diety.obiad.model.SoupData;
import pl.muller.diety.obiad.repository.AdditionsRepo;
import pl.muller.diety.obiad.repository.DinnerRepo;
import pl.muller.diety.obiad.repository.SaladRepo;
import pl.muller.diety.obiad.repository.SoupRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class DinnerService {

	@Autowired
	private final SoupRepo zupaRepo;
	@Autowired
	private final DinnerRepo dinnerRepo;
	@Autowired
	private final SaladRepo saladRepo;
	@Autowired
	private final AdditionsRepo additionsRepo;

	@SuppressWarnings("unchecked")
	public List<ModelData> getDinner(String type) {
		switch (type) {
		case "ZUPA":
			return (List<ModelData>) (List<?>) StreamSupport.stream(zupaRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		case "DANIE_GLOWNE":
			return (List<ModelData>) (List<?>) StreamSupport.stream(dinnerRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		case "SUROWKA":
			return (List<ModelData>) (List<?>) StreamSupport.stream(saladRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		case "DODATKI":
			return (List<ModelData>) (List<?>) StreamSupport.stream(additionsRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		}
		return null;
	}

	public void addDinner(ModelData data, String type) {
		data.setMealType("OBIAD");
		data.setType(type);
		log.info("dodanie dania: {}", data);
		switch (type) {
		case "ZUPA":
			zupaRepo.save(new SoupData(data));
			break;
		case "DANIE_GLOWNE":
//			data.setId(aaaaaaa.findId());
			dinnerRepo.save(new DinnerData(data));
			break;
		case "SUROWKA":
			saladRepo.save(new SaladData(data));
			break;
		case "DODATKI":
			additionsRepo.save(new AdditionsData(data));
			break;
		}
	}

	public void removeDinner(ModelData data) {
		log.info("usunięcie dania: {}", data);
		if (data.getId() != null) {
			switch (data.getType()) {
			case "ZUPA":
				zupaRepo.deleteById(data.getId());
				break;
			case "DANIE_GLOWNE":
				dinnerRepo.deleteById(data.getId());
				break;
			case "SUROWKA":
				saladRepo.deleteById(data.getId());
				break;
			case "DODATKI":
				additionsRepo.deleteById(data.getId());
				break;
			}
		}
	}

}
