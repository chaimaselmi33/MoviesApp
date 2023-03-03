package com.autry.spring.InterfacesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autry.spring.Interfaces.CategoryInterface;
import com.autry.spring.dao.categoryRepo;
import com.autry.spring.models.Category;

@Service
public class CategoryInterfaceImp implements CategoryInterface{
	
	@Autowired
	categoryRepo cat_repo;

	@Override
	public List<Category> getCategories() {
		return cat_repo.findAll();
	}

	@Override
	public Category saveCategory(Category c) {
		return cat_repo.save(c);
	}

	@Override
	public void deleteCategory(long id) {
		cat_repo.deleteById(id);
	}

}
