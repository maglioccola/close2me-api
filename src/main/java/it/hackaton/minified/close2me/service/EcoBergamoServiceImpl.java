package it.hackaton.minified.close2me.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import it.hackaton.minified.close2me.dto.EventDTO;
import it.hackaton.minified.close2me.properties.AppProperties;
import it.hackaton.minified.close2me.util.MonthUtils;

@Service("ServiceEcoBergamo")
public class EcoBergamoServiceImpl implements EcoBergamoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AppProperties appProperties;
	
	@Override
	public List<EventDTO> getEvents(String keywords) {
		List<EventDTO> events = new ArrayList<>();
		List<EventDTO> filteredEvents;
		try {
			Document doc = Jsoup.connect(appProperties.getEcoBergamoUrl()).get();
			StringBuffer sb = new StringBuffer();
			sb.append(doc.title());
	
			Elements days = doc.select(".card-day > div");
			for (Element day : days) {
				EventDTO evento = new EventDTO();
				evento.setCategoryId("3");
				events.add(evento);
			}
	
			Elements months = doc.select(".card-date>div:last-child");
			Elements titles = doc.select(".card-title");
			Elements links  = doc.select(".card-title > a");
			
			for (int i = 0; i < events.size(); i++) {
				EventDTO evento = events.get(i);
				String date = String.format("%s/%s/%s 00:00:00", 
					StringUtils.leftPad(days.get(i).text(), 2, '0'), 
					MonthUtils.getMonthOfYear(months.get(i).text()), 
					String.valueOf(LocalDate.now().getYear() ) );
				Calendar dateStart = Calendar.getInstance();
				dateStart.set(LocalDate.now().getYear(), 
						Integer.valueOf(MonthUtils.getMonthOfYear(months.get(i).text() ) ) - 1,
						Integer.valueOf(days.get(i).text() ) );
				evento.setStart(dateStart.getTime());
				evento.setEnd(dateStart.getTime());
				evento.setFormattedDate(String.format("%s %s %s", 
					StringUtils.leftPad(days.get(i).text(), 2, '0'), 
					months.get(i).text(), 
					String.valueOf(LocalDate.now().getYear() ) ) );
				evento.setTitle(titles.get(i).text());
				evento.setLink("https://www.ecodibergamo.it" + links.get(i).attr("href"));
			}
			
			if (!CollectionUtils.isEmpty(events) && StringUtils.isNotBlank(keywords) ) {
				filteredEvents = events.stream()
					.filter(event -> event.getTitle().contains(keywords.toUpperCase()) )
					.collect(Collectors.toList());
				events = filteredEvents;
			}
		} catch (IOException ioe) {
			logger.error(ioe.getMessage());
		}
		return events;
	}
}
