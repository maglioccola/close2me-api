package it.hackaton.minified.close2me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hackaton.minified.close2me.dao.CategoryRepository;
import it.hackaton.minified.close2me.dto.CategoryDTO;

@Service("ServiceCategory")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	@Override
	public List<CategoryDTO> getCategories() {
		return repository.findAll();
	}

	@Override
	public CategoryDTO getCategoryById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public CategoryDTO getCategoryByTitle(String title) {
		return repository.findByTitle(title);
	}

	@Override
	public void addCategory(CategoryDTO category) {
		repository.save(category);
	}
}
