package pl.muller.diety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pl.muller.diety.general.model.DietaData;
import pl.muller.diety.service.MainService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
@RequestMapping({ "/diety" })
public class MainController {

	@Autowired
	private MainService service;

//	ZAPIS
	@PostMapping("/save")
	public void saveDieta(@RequestBody DietaData data) {
		service.saveDieta(data);
	}

//  Odczyt
	@GetMapping("/load")
	public DietaData loadDieta(@RequestParam Long id) {
		DietaData dieta = service.wczytajDiete(id);
		log.info("pobrano dietę o id: {}: {}", id, dieta);
		return dieta;
	}

	@GetMapping("/load-all")
	public List<DietaData> loadWszystkieDiety() {
		List<DietaData> diety = service.wczytajWszystkieDiety();
		log.info("pobrano diety: {}", diety);
		return diety;
	}

}
