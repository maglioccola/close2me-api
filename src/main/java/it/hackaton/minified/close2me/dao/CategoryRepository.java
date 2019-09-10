package it.hackaton.minified.close2me.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.hackaton.minified.close2me.dto.CategoryDTO;

public interface CategoryRepository extends MongoRepository<CategoryDTO, String> {

	public Optional<CategoryDTO> findById(Integer id);
	public CategoryDTO findByTitle(String title);
}
