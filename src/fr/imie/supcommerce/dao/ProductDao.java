package fr.imie.supcommerce.dao;

import java.util.List;

import fr.imie.supcommerce.entity.Product;

public interface ProductDao {

	List<Product> findAll();
	List<Product> findCheapProduct();
    Product findById(Long id);
    List<Product> findByName(String name);
    Long insertProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(Product product);
	
}
