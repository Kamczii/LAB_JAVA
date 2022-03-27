package repositories;

import entities.Mage;
import entities.Tower;
import views.SIGN;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TowerRepository extends JpaRepository<Tower, String> {

    public TowerRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Tower.class);
    }

    public List<Tower> findAllByHeight(int height, SIGN sign) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        List<Tower> mages = entityManager
                .createQuery("Select t FROM Tower t WHERE t.height "+sign.getLabel()+ " :height", Tower.class)
                .setParameter("height",height)
                .getResultList();
        return mages;
    }
}
