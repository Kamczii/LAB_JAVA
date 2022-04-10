package services;

import entities.Brewery;
import repositories.BreweryRepository;
import views.SIGN;

import java.util.List;

public class BreweryService {

    BreweryRepository breweryRepository;

    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    public void add(List<Brewery> towerList) {
        for (Brewery tower: towerList) {
            this.breweryRepository.add(tower);
        }
    }

    public List<Brewery> findAll() {
        return this.breweryRepository.findAll();
    }

    public List<Brewery> findAllByValue(int value, SIGN sign) {
        return this.breweryRepository.findAllByHeight(value,sign);
    }

    public Brewery findById(String towerName) {
        return this.breweryRepository.findById(towerName);
    }

    public void delete(Brewery brewery) {
        this.breweryRepository.delete(brewery);
    }

    public void create(String breweryName, int value) {
        breweryRepository.add(new Brewery(breweryName, value, null));
    }
}
