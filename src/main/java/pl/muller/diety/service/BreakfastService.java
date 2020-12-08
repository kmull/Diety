package pl.muller.diety.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.muller.diety.general.model.DrinkData;
import pl.muller.diety.general.model.ModelData;
import pl.muller.diety.obiad.repository.DrinkRepo;
import pl.muller.diety.sniadanie.model.BreadData;
import pl.muller.diety.sniadanie.model.BreakfastMainMealData;
import pl.muller.diety.sniadanie.model.DairyData;
import pl.muller.diety.sniadanie.model.SausageData;
import pl.muller.diety.sniadanie.model.VegetableData;
import pl.muller.diety.sniadanie.repository.BreadRepo;
import pl.muller.diety.sniadanie.repository.BreakfastMainMealRepo;
import pl.muller.diety.sniadanie.repository.DairyRepo;
import pl.muller.diety.sniadanie.repository.SausageRepo;
import pl.muller.diety.sniadanie.repository.VegetableRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class BreakfastService {

	@Autowired
	private final BreadRepo breadRepo;
	@Autowired
	private final BreakfastMainMealRepo breakfastMainMealRepo;
	@Autowired
	private final DairyRepo dairyRepo;
	@Autowired
	private final SausageRepo sausageRepo;
	@Autowired
	private final VegetableRepo vegetableRepo;
	@Autowired
	private final DrinkRepo drinkRepo;

	@SuppressWarnings("unchecked")
	public List<ModelData> getDinner(String type) {
		switch (type) {
		case "PIECZYWO":
			return (List<ModelData>) (List<?>) StreamSupport.stream(breadRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		case "DANIE_GLOWNE":
			return (List<ModelData>) (List<?>) StreamSupport
					.stream(breakfastMainMealRepo.findAll().spliterator(), false).collect(Collectors.toList());
		case "NABIAL":
			return (List<ModelData>) (List<?>) StreamSupport.stream(dairyRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		case "WEDLINA":
			return (List<ModelData>) (List<?>) StreamSupport.stream(sausageRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		case "WARZYWO":
			return (List<ModelData>) (List<?>) StreamSupport.stream(vegetableRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		case "NAPOJ":
			return (List<ModelData>) (List<?>) StreamSupport.stream(drinkRepo.findAll().spliterator(), false)
					.collect(Collectors.toList());
		}
		return null;
	}

	public void addDinner(ModelData data, String type) {
		data.setMealType("SNIADANIE");
		data.setType(type);
		log.info("dodanie dania: {}", data);
		switch (type) {
		case "PIECZYWO":
			breadRepo.save(new BreadData(data));
			break;
		case "DANIE_GLOWNE":
			breakfastMainMealRepo.save(new BreakfastMainMealData(data));
			break;
		case "NABIAL":
			dairyRepo.save(new DairyData(data));
			break;
		case "WEDLINA":
			sausageRepo.save(new SausageData(data));
			break;
		case "WARZYWO":
			vegetableRepo.save(new VegetableData(data));
			break;
		case "NAPOJ":
			drinkRepo.save(new DrinkData(data));
			break;
		}
	}

	public void removeDinner(ModelData data) {
		log.info("usunięcie dania: {}", data);
		if (data.getId() != null) {
			switch (data.getType()) {
			case "PIECZYWO":
				breadRepo.deleteById(data.getId());
				break;
			case "DANIE_GLOWNE":
				breakfastMainMealRepo.deleteById(data.getId());
				break;
			case "NABIAL":
				dairyRepo.deleteById(data.getId());
				break;
			case "WEDLINA":
				sausageRepo.deleteById(data.getId());
				break;
			case "WARZYWO":
				vegetableRepo.deleteById(data.getId());
				break;
			case "Napoj":
				drinkRepo.deleteById(data.getId());
				break;
			}
		}
	}

}
