package services;

import entities.Beer;
import entities.Brewery;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class InitService {
    BeerService beerService;
    BreweryService breweryService;

    public void init() {


        Brewery tower1 = new Brewery("Browar1", 381);
        Brewery tower2 = new Brewery("Browar2", 756);
        Brewery tower3 = new Brewery("Browar3", 465);
        Brewery tower4 = new Brewery("Browar4", 221);
        breweryService.add(Arrays.asList(tower1, tower2, tower3, tower4));

        Beer mage1 = new Beer("Piwo1",213,tower1);
        Beer mage2 = new Beer("Piwo2",123,tower2);
        Beer mage3 = new Beer("Piwo3",85,tower3);
        Beer mage4 = new Beer("Piwo4",46,tower4);
        Beer mage5 = new Beer("Piwo5",86,tower1);
        Beer mage6 = new Beer("Piwo6",46,tower1);
        Beer mage7 = new Beer("Piwo7",98,tower1);
        Beer mage8 = new Beer("Piwo8",15,tower3);
        Beer mage9 = new Beer("Piwo9",56,tower2);

        beerService.add(Arrays.asList(mage1,mage2,mage3,mage4,mage5,mage6,mage7,mage8,mage9));
    }
}
