package fr.imie.supcommerce.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table (name="category")
@NamedQuery(name="category", query="SELECT c FROM Category AS c")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="category")
	private Collection<Product> products;
	
	/**
	 * @return the products
	 */
	public Collection<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Category() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
