/**
 * 
 */
package fr.imie.supcommerce.dao;

import java.util.List;

import fr.imie.supcommerce.entity.Category;

/**
 * @author WYLLIAM
 *
 */
public interface ICategoryDao {

	List<Category> findAll();
    List<Category> findById();
    List<Category> findByName();
    boolean insertCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(Category category);
}
