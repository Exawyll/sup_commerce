package fr.imie.supcommerce.dao;

import java.util.ArrayList;
import java.util.List;

import fr.imie.supcommerce.entity.Category;

public class CategoryDao implements ICategoryDao {
	
	private static ArrayList<Category> categories = new ArrayList<>();

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
