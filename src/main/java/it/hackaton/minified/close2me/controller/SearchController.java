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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.hackaton.minified.close2me.dto.EventDTO;
import it.hackaton.minified.close2me.dto.EventsDTO;
import it.hackaton.minified.close2me.service.EcoBergamoService;
import it.hackaton.minified.close2me.service.GoogleMapsService;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("ServiceGoogleMaps")
	private GoogleMapsService googleMapsService;
	
	@Autowired
	@Qualifier("ServiceEcoBergamo")
	private EcoBergamoService ecoBergamoService;
	
	@GetMapping(value = "/places")
	@CrossOrigin
	public @ResponseBody List<EventDTO> getPlaces(@RequestParam(name = "keywords", required = true) String keywords, 
							@RequestParam(name = "latitude", required = true) String latitude,
							@RequestParam(name = "longitude", required = true) String longitude) {
		logger.debug("keywords:" + keywords);
		return googleMapsService.getPlaces(keywords, latitude, longitude);
	}
	
	@GetMapping(value = "/places/extra")
	@CrossOrigin
	public @ResponseBody EventsDTO getPlacesWithMap(@RequestParam(name = "keywords", required = true) String keywords, 
							@RequestParam(name = "latitude", required = true) String latitude,
							@RequestParam(name = "longitude", required = true) String longitude) {
		logger.debug("keywords:" + keywords);
		EventsDTO response = new EventsDTO();
		List<EventDTO> events = googleMapsService.getPlaces(keywords, latitude, longitude);
		String map = googleMapsService.getMap();
		response.setEvents(events);
		response.setHtml(map);
		return response;
	}
	
	@GetMapping(value = "/events/eco")
	@CrossOrigin
	public @ResponseBody List<EventDTO> getEvents(@RequestParam(name = "keywords", required = true) String keywords) {
		return ecoBergamoService.getEvents(keywords);
	}
}
