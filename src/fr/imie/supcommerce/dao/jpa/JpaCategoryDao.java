/**
 * 
 */
package fr.imie.supcommerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.supcommerce.dao.CategoryDao;
import fr.imie.supcommerce.entity.Category;

/**
 * @author WYLLIAM
 *
 */
public class JpaCategoryDao extends JpaDao implements CategoryDao {

	public JpaCategoryDao(EntityManagerFactory emf) {
		super(emf);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		List<Category> categories;
		EntityManager em = getEntityManagerFactory().createEntityManager();

		Query query = em.createNamedQuery("category");

		categories = (List<Category>) query.getResultList();

		em.close();
		
		return categories;
	}

	@Override
	public Category findById(Long id) {
		Category category;
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		// Use an EntityManager to persist the object
		try {
			
			t.begin();

			Query query = em.createQuery("SELECT c FROM Category AS c WHERE c.id = " + id);
			
			category = (Category) query.getSingleResult();

			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findByName(String name) {
		List<Category> categories;
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		// Use an EntityManager to persist the object
		try {
			
			t.begin();

			Query query = em.createQuery("SELECT c FROM Category AS c WHERE c.id = " + name);
			
			categories = (List<Category>) query.getResultList();

			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
		return categories;
	}

	@Override
	public Long insertCategory(Category category) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		// Use an EntityManager to persist the object
		try {
			
			t.begin();

			em.persist(category);

			t.commit();
			
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
			
		}
		
		return category.getId();
	}

	@Override
	public boolean updateCategory(Category category) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		// Use an EntityManager to persist the object
		try {
			
			t.begin();

			em.merge(category);

			t.commit();
			
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
			
		}
		
		return true;
	}

	@Override
	public boolean deleteCategory(Category category) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		// Use an EntityManager to persist the object
		try {
			
			t.begin();

			em.remove(em.merge(category));

			t.commit();
			
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
			
		}
		
		return true;
	}

}
