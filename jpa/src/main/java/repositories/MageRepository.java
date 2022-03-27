package repositories;

import entities.Mage;
import entities.Tower;
import views.SIGN;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MageRepository extends JpaRepository<Mage, String> {

    public MageRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Mage.class);
    }

    public List<Mage> findAllByLvl(int lvl, SIGN sign) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        List<Mage> mages = entityManager
                .createQuery("Select m FROM Mage m WHERE m.level "+sign.getLabel()+ " :lvl", Mage.class)
                .setParameter("lvl",lvl)
                .getResultList();
        return mages;
    }

    public List<Mage> findMagesByTowerAndLvl(Tower tower, int level, SIGN sign) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        List<Mage> mages = entityManager
                .createQuery("SELECT m FROM Mage m WHERE m.tower = :tower AND m.level "+sign.getLabel()+" :lvl", Mage.class)
                .setParameter("tower",tower)
                .setParameter("lvl", level)
                .getResultList();
        return mages;
    }
}
