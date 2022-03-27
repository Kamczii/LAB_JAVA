package services;

import entities.Mage;
import entities.Tower;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collections;

@AllArgsConstructor
public class InitService {
    MageService mageService;
    TowerService towerService;

    public void init() {


        Tower tower1 = new Tower("Tower1", 381);
        Tower tower2 = new Tower("Tower2", 756);
        Tower tower3 = new Tower("Tower3", 465);
        Tower tower4 = new Tower("Tower4", 221);
        towerService.add(Arrays.asList(tower1, tower2, tower3, tower4));

        Mage mage1 = new Mage("Mage1",213,tower1);
        Mage mage2 = new Mage("Mage2",123,tower2);
        Mage mage3 = new Mage("Mage3",85,tower3);
        Mage mage4 = new Mage("Mage4",46,tower4);
        Mage mage5 = new Mage("Mage5",86,tower1);
        Mage mage6 = new Mage("Mage6",46,tower1);
        Mage mage7 = new Mage("Mage7",98,tower1);
        Mage mage8 = new Mage("Mage8",15,tower3);
        Mage mage9 = new Mage("Mage9",56,tower2);

        mageService.add(Arrays.asList(mage1,mage2,mage3,mage4,mage5,mage6,mage7,mage8,mage9));
    }
}
