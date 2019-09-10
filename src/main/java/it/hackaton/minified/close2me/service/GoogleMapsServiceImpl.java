package it.hackaton.minified.close2me.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.hackaton.minified.close2me.dto.EventDTO;
import it.hackaton.minified.close2me.pojo.Places;
import it.hackaton.minified.close2me.properties.AppProperties;
import it.hackaton.minified.close2me.properties.MapsProperties;
import it.hackaton.minified.close2me.util.ParameterStringBuilder;

@Service("ServiceGoogleMaps")
public class GoogleMapsServiceImpl implements GoogleMapsService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AppProperties appProperties;
	@Autowired
	MapsProperties mapsProperties;
	
	@Override
	public List<EventDTO> getPlaces(String keywords, String longitude, String latitude) {
		List<EventDTO> events = new ArrayList<>();
		try {
			Map<String, String> parameters = new HashMap<>();
			parameters.put("location", String.format("%s,%s", longitude, latitude) );
			parameters.put("radius",   mapsProperties.getRadius() );
			parameters.put("key",      mapsProperties.getKey() );
			parameters.put("keyword",  keywords);
			
			String search = String.format("%s%s", mapsProperties.getUrl(), ParameterStringBuilder.getParamsString(parameters, appProperties.getCharset() ) );
			logger.debug("search : " + search);
			URL url = new URL(search);
			Reader reader = new InputStreamReader(url.openStream(), appProperties.getCharset() );
			ObjectMapper objectMapper = new ObjectMapper();
			Places places = objectMapper.readValue(reader, Places.class);
			places.getResults().forEach(place -> {
				EventDTO event = new EventDTO();
				event.setId(place.getId());
				event.setTitle(place.getName() );
				event.setStart(null);
				event.setEnd(null);
				event.setLatitude(place.getGeometry().getLocation().getLat());
				event.setLongitude(place.getGeometry().getLocation().getLng());
				event.setRating(place.getRating() );
				event.setAddress(place.getVicinity());
				event.setNote("");
				events.add(event);
			});
			//Convert POJO to JSON
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(places);
			Files.write(Paths.get(mapsProperties.getFileJson()), json.getBytes() );
			String cmd = String.format("python %s", mapsProperties.getPythonMapConverter() );
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			logger.error(e.getMessage() );
		}
		return events;
	}
	
	public String getMap() {
		StringBuilder result = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(mapsProperties.getFileHtml()) ) ) {
			stream.forEach(line -> result.append(line) );
		} catch (IOException e) {
			logger.error(e.getMessage() );
		}
		return result.toString();
	}
}
