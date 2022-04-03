package entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Brewery {

    public Brewery(String name, int value) {
        this.name = name;
        this.value = value;
        this.beers = new ArrayList<>();
    }

    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private int value;

    @OneToMany(mappedBy = "brewery", fetch = FetchType.EAGER)
    @Getter
    @Setter
    private List<Beer> beers;

    @Override
    public String toString() {
        return "\nBrewary = {" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", \nbeers=" + beers +
                "}\n";
    }
}