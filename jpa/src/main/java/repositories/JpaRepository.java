package repositories;

import entities.Tower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class JpaRepository<E,K> {
    private EntityManagerFactory entityManagerFactory;

    private Class<E> clazz;

    public JpaRepository(EntityManagerFactory entityManagerFactory, Class<E> clazz) {
        this.entityManagerFactory = entityManagerFactory;
        this.clazz = clazz;
    }

    public List<E> findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<E> result = entityManager.createQuery("SELECT e FROM "+clazz.getSimpleName()+" e",clazz).getResultList();
        entityManager.close();
        return result;
    }

    public void add(E e) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(e);
        transaction.commit();
        entityManager.close();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public E findById(K id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        E entity = entityManager.find(clazz,id);
        entityManager.close();
        return entity;
    }
}
