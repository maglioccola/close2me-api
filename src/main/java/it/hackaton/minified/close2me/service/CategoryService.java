package it.hackaton.minified.close2me.service;

import java.util.List;

import it.hackaton.minified.close2me.dto.CategoryDTO;

public interface CategoryService {
	public List<CategoryDTO> getCategories();
	public CategoryDTO getCategoryById(Integer id);
	public CategoryDTO getCategoryByTitle(String title);
	public void addCategory(CategoryDTO category);
}
