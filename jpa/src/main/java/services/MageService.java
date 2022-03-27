package services;

import entities.Mage;
import entities.Tower;
import repositories.MageRepository;
import views.SIGN;

import java.util.List;

public class MageService {
    MageRepository magRepository;

    public MageService(MageRepository magRepository) {
        this.magRepository = magRepository;
    }

    public List<Mage> findAll() {
        return this.magRepository.findAll();
    }

    public void add(List<Mage> mageList) {
        for(Mage mage : mageList) {
            this.magRepository.add(mage);
        }
    }

    public List<Mage> findAllByLvl(int lvl, SIGN sign) {
        return this.magRepository.findAllByLvl(lvl, sign);
    }

    public List<Mage> findAllByLvl(Tower tower, int lvl, SIGN sign) {
        return this.magRepository.findMagesByTowerAndLvl(tower, lvl, sign);
    }

    public List<Mage> findAllByTowerAndLvl(Tower tower, int lvl, SIGN sign) {
        return this.magRepository.findMagesByTowerAndLvl(tower,lvl,sign);
    }
}
