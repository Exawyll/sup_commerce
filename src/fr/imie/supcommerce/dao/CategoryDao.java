package fr.imie.supcommerce.dao;

import java.util.List;

import fr.imie.supcommerce.entity.Category;

public interface CategoryDao {
	
	List<Category> findAll();
    Category findById(Long id);
    List<Category> findByName(String name);
    Long insertCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(Category category);

}
