package pl.muller.diety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.muller.diety.general.model.DietaData;
import pl.muller.diety.service.MainService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/diety" })
public class MainController {

	@Autowired
	private MainService service;

//	ZAPIS
	@PostMapping("/save")
	public void saveDieta(@RequestBody DietaData data) {
		service.save(data);
	}
}
