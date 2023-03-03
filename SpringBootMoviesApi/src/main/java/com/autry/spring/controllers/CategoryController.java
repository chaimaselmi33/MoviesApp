package com.autry.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autry.spring.Interfaces.CategoryInterface;
import com.autry.spring.dao.categoryRepo;
import com.autry.spring.models.Category;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryInterface cat_interf;
	
	@Autowired
	categoryRepo cat_repository;
	
	@PostMapping("add-cat")
	Category saveCategory(@RequestBody Category c)
	{
		return cat_interf.saveCategory(c);
	}
	
	@GetMapping("/get-cat")
	List<Category> getCategories(){
		//return cat_repository.findAll();
		return cat_interf.getCategories();
	}
	
	@DeleteMapping("/delete-cat/{id}")
	void deleteCategory(@PathVariable long id) {
		cat_interf.deleteCategory(id);
	}
	
}
