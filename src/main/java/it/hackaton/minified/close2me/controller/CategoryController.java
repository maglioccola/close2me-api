package it.hackaton.minified.close2me.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.hackaton.minified.close2me.dto.CategoryDTO;
import it.hackaton.minified.close2me.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("ServiceCategory")
	private CategoryService categoryService;
	
	@GetMapping(value = "/")
	@CrossOrigin
	public List<CategoryDTO> getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping(value = "/id")
	@CrossOrigin
	public CategoryDTO getCategoryById(@RequestParam(name = "id", required = true) Integer id) {
		logger.debug(String.format("id: %d", id) );
		return categoryService.getCategoryById(id);
	}
	
	@GetMapping(value = "/title")
	@CrossOrigin
	public CategoryDTO getCategoryByTitle(@RequestParam(name = "title", required = true) String title) {
		logger.debug(String.format("title: %s", title) );
		return categoryService.getCategoryByTitle(title);
	}
	
	@PostMapping(value = "/category")
	@CrossOrigin
	public ResponseEntity<?> addCategory(@RequestBody CategoryDTO category) { 
		logger.debug(String.format("category: %s", category) );
		ResponseEntity<String> response;
		if (StringUtils.isNotBlank(category.getTitle() ) ) {
			categoryService.addCategory(category);
			HttpHeaders headers = new HttpHeaders();
			response = new ResponseEntity<>("OK", headers, HttpStatus.OK);
		} else { 
			response = new ResponseEntity<>("KO", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
