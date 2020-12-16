package pl.muller.diety.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.muller.diety.general.model.DietaData;
import pl.muller.diety.obiad.repository.MainRepo;

@Service
@RequiredArgsConstructor
public class MainService {

	@Autowired
	private MainRepo mainRepository;

	public void saveDieta(DietaData data) {
		mainRepository.save(data);
	}

	public DietaData wczytajDiete(Long id) {
		return mainRepository.findById(id).orElse(null);
	}

	public List<DietaData> wczytajWszystkieDiety() {
		return (List<DietaData>) StreamSupport.stream(mainRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public void deleteById(Long id) {
		mainRepository.deleteById(id);
	}
}
