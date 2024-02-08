package harouane.U5W1D4_SpringJPA.Entities.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Menu {
    @Autowired
    List<Pizza> pizzas;
    @Autowired
    List<Drink> drinks;
    @Autowired
    List<Topping> toppings;

    public void print() {
        System.out.println("-------------------------MENU-------------------------\n" +
                "---PIZZE-------------------------\n");
        this.pizzas.forEach(System.out::println);
        System.out.println("---Topping per pizze personalizzate-------------------------\n");
        this.toppings.forEach(System.out::println);
        System.out.println("---Bevande-------------------------\n");
        this.drinks.forEach(System.out::println);
    }
}
