package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Category;

public interface CategoryDao {

	void save(Category c);

	List<Category> findAll();

	Category findById(String categoryId);

}
