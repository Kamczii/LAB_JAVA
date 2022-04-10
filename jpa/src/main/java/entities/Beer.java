package entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Beer {
    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brewery")
    @Getter
    @Setter
    private Brewery brewery;

    @Override
    public String toString() {
        return "Beer = {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brewery="+brewery.getName()+
                '}';
    }
}

