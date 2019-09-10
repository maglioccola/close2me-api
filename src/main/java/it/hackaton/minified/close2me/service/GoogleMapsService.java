package it.hackaton.minified.close2me.service;

import java.util.List;

import it.hackaton.minified.close2me.dto.EventDTO;

public interface GoogleMapsService {
	public List<EventDTO> getPlaces(String keywords, String longitude, String latitude);
	public String getMap();
}
