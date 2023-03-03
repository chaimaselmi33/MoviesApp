package com.autry.spring.Interfaces;

import java.util.List;

import com.autry.spring.models.Category;

public interface CategoryInterface {

	List<Category> getCategories();
	
	Category saveCategory( Category c);
	
	void deleteCategory(long id);
	
}
