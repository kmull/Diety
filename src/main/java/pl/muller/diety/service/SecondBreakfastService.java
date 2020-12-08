package pl.muller.diety.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.muller.diety.general.model.ModelData;
import pl.muller.diety.podwieczorek.model.SecondBreakfastData;
import pl.muller.diety.podwieczorek.repository.SecondBreakfastRepo;


@Service
@RequiredArgsConstructor
@Slf4j
public class SecondBreakfastService {

	@Autowired
	private final SecondBreakfastRepo secondBreakfastRepo;

	@SuppressWarnings("unchecked")
	public List<ModelData> getDinner(String type) {
		return (List<ModelData>) (List<?>) StreamSupport.stream(secondBreakfastRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	public void addDinner(ModelData data, String type) {
		data.setMealType("DRUGIE_SNIADANIE");
		data.setType(type);
		log.info("dodanie dania: {}", data);
		secondBreakfastRepo.save(new SecondBreakfastData(data));
	}

	public void removeDinner(ModelData data) {
		log.info("usunięcie dania: {}", data);
		if (data.getId() != null) {
			secondBreakfastRepo.deleteById(data.getId());
		}
	}

}
