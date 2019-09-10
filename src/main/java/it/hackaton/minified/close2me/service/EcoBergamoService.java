package it.hackaton.minified.close2me.service;

import java.util.List;

import it.hackaton.minified.close2me.dto.EventDTO;

public interface EcoBergamoService {
	public List<EventDTO> getEvents(String keywords);
}
