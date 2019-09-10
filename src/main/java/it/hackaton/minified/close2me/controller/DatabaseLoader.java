package it.hackaton.minified.close2me.controller;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.hackaton.minified.close2me.dao.CategoryRepository;
import it.hackaton.minified.close2me.dao.EventRepository;
import it.hackaton.minified.close2me.dto.CategoryDTO;
import it.hackaton.minified.close2me.dto.EventDTO;

@Component
public class DatabaseLoader implements CommandLineRunner {
	
	private final CategoryRepository repository;
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	public DatabaseLoader(CategoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of categories
		repository.save(new CategoryDTO(1, "Food and Drink", "fa fa-cutlery fa-3x", "LightGreen", "/events/id?id=1") );
		repository.save(new CategoryDTO(2, "Cultura", "fa fa-book fa-3x", "LightPink", "/search/places") );
		repository.save(new CategoryDTO(3, "Eventi", "fa fa-calendar fa-3x", "OrangeRed", "/search/events/eco") );
		repository.save(new CategoryDTO(4, "Sport", "fa fa-trophy fa-3x", "Yellow", "/search/places") );
		repository.save(new CategoryDTO(5, "Trasporti", "fa fa-car fa-3x", "LightBlue", "/events/id?id=2") );
		
		Calendar dateStart = Calendar.getInstance();
		dateStart.set(LocalDate.now().getYear(), 8, 6);
		Calendar dateEnd   = Calendar.getInstance();
		dateEnd.set(LocalDate.now().getYear(), 8, 8);
		eventRepository.save(new EventDTO("1", "1", "9.6", "45.7", dateStart.getTime(), dateEnd.getTime(), "07 - 09 Settembre 2019", "Download Innovation", "", "", "", "", "", "") );
		eventRepository.save(new EventDTO("2", "2", "9.6", "45.7", dateStart.getTime(), dateEnd.getTime(), "07 - 09 Settembre 2019", "Download Innovation", "", "", "", "", "", "") );
		eventRepository.save(new EventDTO("3", "3", "9.6", "45.7", dateStart.getTime(), dateEnd.getTime(), "07 - 09 Settembre 2019", "Download Innovation", "", "", "", "", "", "") );
		eventRepository.save(new EventDTO("4", "4", "9.6", "45.7", dateStart.getTime(), dateEnd.getTime(), "07 - 09 Settembre 2019", "Download Innovation", "", "", "", "", "", "") );
		eventRepository.save(new EventDTO("5", "5", "9.6", "45.7", dateStart.getTime(), dateEnd.getTime(), "07 - 09 Settembre 2019", "Download Innovation", "", "", "", "", "", "") );

		// fetch all categories
		System.out.println("Categories found with findAll():");
		System.out.println("-------------------------------");
		for (CategoryDTO category : repository.findAll()) {
			System.out.println(category);
		}
	}
}
