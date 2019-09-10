package it.hackaton.minified.close2me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hackaton.minified.close2me.dao.EventRepository;
import it.hackaton.minified.close2me.dto.EventDTO;

@Service("ServiceEvent")
public class EventServiceImpl implements EventService {
	@Autowired
	private EventRepository repository;
	
	@Override
	public List<EventDTO> getEvents() {
		return repository.findAll();
	}

	@Override
	public List<EventDTO> getEventsByDate(String date) {
		//return repository.findBy
		return null;
	}

	@Override
	public List<EventDTO> getEventsByCategoryId(String categoryId) {
		return repository.findByCategoryId(categoryId);
	}

	@Override
	public List<EventDTO> getEventsByDateAndLocation(String date, String location) {
		// TODO Auto-generated method stub
		return null;
	}

}
