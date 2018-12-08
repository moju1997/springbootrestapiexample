package com.example.demo.restcontroller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	/* to save category*/
	@PostMapping
	public Category createCategory(@Valid @RequestBody Category cat) {
		return categoryService.save(cat);
	}
	
	/*get all category*/
	@GetMapping
	public List<Category> getAllCategory(){
		return categoryService.findAll();
	}
	
	/*get category by catid*/
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoriesById(@PathVariable(value="id") Long catid){
		
		Category cat=categoryService.findOne(catid);
		
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cat);
		
	}
		
	/*update an category by catid*/
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategories(@PathVariable(value="id") Long catid,@Valid @RequestBody Category catDetails){
		
		Category cat=categoryService.findOne(catid);
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}
		
		cat.setName(catDetails.getName());
		cat.setProducts(catDetails.getProducts());
		
		
		Category updateCategories=categoryService.save(cat);
		return ResponseEntity.ok().body(updateCategories);
				
	}
	
	/*Delete an categories*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteEmployee(@PathVariable(value="id") Long catid){
		
		Category emp=categoryService.findOne(catid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		categoryService.delete(emp);
		
		return ResponseEntity.ok().build();	
	}

//	@GetMapping("/{id}/products")
//	public ResponseEntity<?> getAllProducts(@PathVariable("id") Long categoryId) {
//		return null;
//	}
	
}
