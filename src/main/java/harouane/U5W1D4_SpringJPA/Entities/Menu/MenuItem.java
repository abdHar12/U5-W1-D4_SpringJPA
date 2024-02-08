package harouane.U5W1D4_SpringJPA.Entities.Menu;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    protected double calories;
    protected double price;
    protected String name;

    public MenuItem(String name, double calories, double price) {
        this.calories = calories;
        this.price = price;
        this.name = name;
    }


}


