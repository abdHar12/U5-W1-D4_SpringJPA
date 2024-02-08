package harouane.U5W1D4_SpringJPA.Entities.Menu;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Topping extends MenuItem {
    @ManyToMany
    @JoinTable(name = "pizzas_toppings", joinColumns =  @JoinColumn(name = "topping_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    List<Pizza> pizzas;

    public Topping(String name, double calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return name + " -> " + "Prezzo: " + price + ", Calorie: " + calories;
    }
}
