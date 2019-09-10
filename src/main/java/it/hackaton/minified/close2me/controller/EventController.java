package it.hackaton.minified.close2me.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.hackaton.minified.close2me.dto.EventDTO;
import it.hackaton.minified.close2me.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("ServiceEvent")
	private EventService eventService;
	
	@GetMapping(value = "/")
	@CrossOrigin
	public List<EventDTO> getEvents() {
		return eventService.getEvents();
	}
	
	@GetMapping(value = "/id")
	@CrossOrigin
	public List<EventDTO> getEventsByCategoryId(@RequestParam(name = "id", required = true) String categoryId) {
		logger.debug(String.format("id: %s", categoryId) );
		return eventService.getEventsByCategoryId(categoryId);
	}
	
	@GetMapping(value = "/date")
	@CrossOrigin
	public List<EventDTO> getEventsByDate(@RequestParam(name = "date", required = true) String date) {
		logger.debug(String.format("date: %s", date) );
		return eventService.getEventsByDate(date);
	}
}
