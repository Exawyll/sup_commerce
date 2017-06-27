/**
 * 
 */
package fr.imie.supcommerce.dao.jpa;

import javax.persistence.EntityManagerFactory;

/**
 * @author WYLLIAM
 *
 */
public abstract class JpaDao {
	private EntityManagerFactory emf;

    protected JpaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

	public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void close() {
        emf.close();
    }
}
