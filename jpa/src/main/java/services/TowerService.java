package services;

import entities.Tower;
import repositories.TowerRepository;
import views.SIGN;

import java.util.List;

public class TowerService {

    TowerRepository towerRepository;

    public TowerService(TowerRepository towerRepository) {
        this.towerRepository = towerRepository;
    }

    public void add(List<Tower> towerList) {
        for (Tower tower: towerList) {
            this.towerRepository.add(tower);
        }
    }

    public List<Tower> findAll() {
        return this.towerRepository.findAll();
    }

    public List<Tower> findAllByHeight(int height, SIGN sign) {
        return this.towerRepository.findAllByHeight(height,sign);
    }

    public Tower findById(String towerName) {
        return this.towerRepository.findById(towerName);
    }
}
