/**
 * 
 */
package fr.imie.supcommerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.supcommerce.dao.ProductDao;
import fr.imie.supcommerce.entity.Product;

/**
 * @author WYLLIAM
 *
 */
public class JpaProductDao extends JpaDao implements ProductDao {

	public JpaProductDao(EntityManagerFactory emf) {
		super(emf);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		List<Product> products;
		EntityManager em = getEntityManagerFactory().createEntityManager();

		Query query = em.createNamedQuery("product");

		products = (List<Product>) query.getResultList();

		em.close();

		return products;
	}

	@Override
	public Product findById(Long id) {
		Product product;
		EntityManager em = getEntityManagerFactory().createEntityManager();

		product = em.find(Product.class, id);

		em.close();

		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByName(String name) {
		List<Product> products;
		EntityManager em = getEntityManagerFactory().createEntityManager();

		Query query = em.createQuery("SELECT p FROM Product AS p WHERE p.name = " + name);

		products = (List<Product>) query.getResultList();

		em.close();

		return products;
	}
	
	// Retrieve all the products with price < 100
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findCheapProduct() {
		
		List<Product> products;
		EntityManager em = getEntityManagerFactory().createEntityManager();

		Query query = em.createQuery("SELECT p FROM Product AS p WHERE p.price < 100");

		products = (List<Product>) query.getResultList();

		em.close();

		return products;
	}

	@Override
	public Long insertProduct(Product product) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();

		// Use an EntityManager to persist the object
		try {

			t.begin();

			em.persist(product);
			em.flush();
			
			t.commit();

		} finally {
			if (t.isActive())
				t.rollback();
			em.close();

		}

		return product.getId();
	}

	@Override
	public boolean updateProduct(Product product) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();

		// Use an EntityManager to persist the object
		try {

			t.begin();

			em.merge(product);

			t.commit();

		} finally {
			if (t.isActive())
				t.rollback();
			em.close();

		}

		return true;
	}

	@Override
	public boolean deleteProduct(Product product) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();

		// Use an EntityManager to persist the object
		try {

			t.begin();
			
			em.remove(em.merge(product));

			t.commit();

		} finally {
			if (t.isActive())
				t.rollback();
			em.close();
		}

		return true;
	}

}
