package pl.muller.diety.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.muller.diety.general.model.ModelData;
import pl.muller.diety.podwieczorek.model.AfternoonSnackData;
import pl.muller.diety.podwieczorek.repository.AfternoonSnackRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class AfternoonSnaskService {

	@Autowired
	private final AfternoonSnackRepo afternoonSnackRepo;

	@SuppressWarnings("unchecked")
	public List<ModelData> getDinner(String type) {
		return (List<ModelData>) (List<?>) StreamSupport.stream(afternoonSnackRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	public void addDinner(ModelData data, String type) {
		data.setMealType("PODWIECZOREK");
		data.setType(type);
		log.info("dodanie dania: {}", data);
		afternoonSnackRepo.save(new AfternoonSnackData(data));
	}

	public void removeDinner(ModelData data) {
		log.info("usunięcie dania: {}", data);
		if (data.getId() != null) {
			afternoonSnackRepo.deleteById(data.getId());
		}
	}

}
