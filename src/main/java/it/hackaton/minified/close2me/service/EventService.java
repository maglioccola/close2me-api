package it.hackaton.minified.close2me.service;

import java.util.List;

import it.hackaton.minified.close2me.dto.EventDTO;

public interface EventService {
	public List<EventDTO> getEvents();
	public List<EventDTO> getEventsByDate(String date);
	public List<EventDTO> getEventsByCategoryId(String categoryId);
	public List<EventDTO> getEventsByDateAndLocation(String date, String location);
	
}
