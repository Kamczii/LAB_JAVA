package services;

import entities.Beer;
import entities.Brewery;
import repositories.BeerRepository;
import views.SIGN;

import java.util.List;

public class BeerService {
    BeerRepository magRepository;

    public BeerService(BeerRepository magRepository) {
        this.magRepository = magRepository;
    }

    public List<Beer> findAll() {
        return this.magRepository.findAll();
    }

    public void add(List<Beer> mageList) {
        for(Beer mage : mageList) {
            this.magRepository.add(mage);
        }
    }

    public List<Beer> findAllByLvl(int lvl, SIGN sign) {
        return this.magRepository.findAllByLvl(lvl, sign);
    }

    public List<Beer> findAllByLvl(Brewery tower, int lvl, SIGN sign) {
        return this.magRepository.findMagesByTowerAndLvl(tower, lvl, sign);
    }

    public List<Beer> findAllByTowerAndLvl(Brewery tower, int lvl, SIGN sign) {
        return this.magRepository.findMagesByTowerAndLvl(tower,lvl,sign);
    }

    public void create(String name, int level, Brewery tower) {
        magRepository.add(new Beer(name, level, tower));
    };

    public void delete(Beer mage) {
        magRepository.delete(mage);
    }

    public Beer findById(String name) {
        return magRepository.findById(name);
    }
}
