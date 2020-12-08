package pl.muller.diety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.muller.diety.general.model.ModelData;
import pl.muller.diety.service.DinnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/diety/obiad" })
public class DinnerController {

	@Autowired
	private DinnerService dinnerService;

//	POBIERANIE
	@GetMapping("/danie/{type}")
	public List<ModelData> getDinnerAll(@PathVariable String type) {
		return dinnerService.getDinner(type);
	}

//	DODAWANIE
	@PostMapping("/add/{type}")
	public void addDinner(@RequestBody ModelData data, @PathVariable String type) {
		dinnerService.addDinner(data, type);
	}

//	USUWANIE
	@PostMapping("/remove-meal")
	public void removeSoupDataById(@RequestBody ModelData data) {
		dinnerService.removeDinner(data);
	}

}
