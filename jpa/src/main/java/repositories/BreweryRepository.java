package repositories;

import entities.Brewery;
import views.SIGN;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BreweryRepository extends JpaRepository<Brewery, String> {

    public BreweryRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Brewery.class);
    }

    public List<Brewery> findAllByHeight(int value, SIGN sign) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        List<Brewery> mages = entityManager
                .createQuery("Select t FROM Brewery t WHERE t.value "+sign.getLabel()+ " :value", Brewery.class)
                .setParameter("value",value)
                .getResultList();
        return mages;
    }
}
