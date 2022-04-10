package repositories;

import entities.Beer;
import entities.Brewery;
import views.SIGN;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BeerRepository extends JpaRepository<Beer, String> {

    public BeerRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Beer.class);
    }

    public List<Beer> findAllByLvl(int price, SIGN sign) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        List<Beer> mages = entityManager
                .createQuery("Select m FROM Beer m WHERE m.price "+sign.getLabel()+ " :price", Beer.class)
                .setParameter("price",price)
                .getResultList();
        return mages;
    }

    public List<Beer> findMagesByTowerAndLvl(Brewery tower, int level, SIGN sign) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        List<Beer> mages = entityManager
                .createQuery("SELECT m FROM Beer m WHERE m.brewery = :brewery AND m.price "+sign.getLabel()+" :price", Beer.class)
                .setParameter("brewery",tower)
                .setParameter("price", level)
                .getResultList();
        return mages;
    }

    public void delete(Beer mage) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.merge(mage));
        transaction.commit();
        em.close();
    }
}
