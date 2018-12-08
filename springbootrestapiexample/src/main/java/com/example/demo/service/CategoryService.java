package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	/*to save category*/
	public Category save(Category cat) {
		return categoryRepository.save(cat);
	}

	/* search all categories*/
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}

	/*get category by id*/
	public Category findOne(Long catid) {
		return categoryRepository.findById(catid).orElse(null);
	}

	/*delete a category*/
	public void delete(Category cat) {
		categoryRepository.delete(cat);
	}

}
