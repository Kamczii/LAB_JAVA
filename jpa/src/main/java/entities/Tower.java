package entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tower {

    public Tower(String name, int height) {
        this.name = name;
        this.height = height;
        this.mages = new ArrayList<>();
    }

    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private int height;

    @OneToMany(mappedBy = "tower", fetch = FetchType.EAGER)
    @Getter
    @Setter
    private List<Mage> mages;

    @Override
    public String toString() {
        return "\nTower{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", \nmages=" + mages +
                "}\n";
    }
}