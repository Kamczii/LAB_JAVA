package entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mage {
    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private int level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tower")
    @Getter
    @Setter
    private Tower tower;

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}

