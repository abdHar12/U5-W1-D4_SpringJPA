package harouane.U5W1D4_SpringJPA.Entities.Menu;

import harouane.U5W1D4_SpringJPA.Entities.Menu.MenuItem;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
public class Drink extends MenuItem {
    double capacity;
    double grade;
    public Drink(String name, double calories, double price, double capacity, double grade) {
        super(name, calories, price);
        this.capacity = capacity;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + "-> Costo: " + price + ", Calorie: " + calories;
    }
}
