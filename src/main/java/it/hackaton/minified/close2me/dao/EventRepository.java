package it.hackaton.minified.close2me.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.hackaton.minified.close2me.dto.EventDTO;

public interface EventRepository extends MongoRepository<EventDTO, String> {

	public List<EventDTO> findByTitle(String title);
	public List<EventDTO> findByCategoryId(String categoryId);
	public List<EventDTO> findByMetadata(String metadata);
}
