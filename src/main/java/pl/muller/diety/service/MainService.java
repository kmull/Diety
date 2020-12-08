package pl.muller.diety.service;

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

	public void save(DietaData data) {
//		mainRepository.save(new DietaData(data.getName(), data.getDate(), data.getDane()));
		mainRepository.save(data);
	}
}
