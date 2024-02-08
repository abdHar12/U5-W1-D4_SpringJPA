package harouane.U5W1D4_SpringJPA.Entities.Menu;

import harouane.U5W1D4_SpringJPA.U5W1D4SpringJpaApplication;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@NoArgsConstructor
public class Pizza extends MenuItem {

    List<Topping> basicToppings;

    @ManyToMany
    @JoinTable(name = "pizzas_toppings", joinColumns =  @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "topping_id"))
    List<Topping> toppings;

    public Pizza(String name, double calories, double price, List<Topping> toppings) {
        super(name, calories, price);
        this.setBasicToppings();
        this.toppings = toppings;
    }

    void addToppings(List<Topping> toppings) {
        toppings.forEach(t -> this.toppings.add(t));
    }

    public void setBasicToppings() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D4SpringJpaApplication.class);
        this.basicToppings.add((Topping) ctx.getBean("tomato"));
        this.basicToppings.add((Topping) ctx.getBean("cheese"));
    }

    @Override
    public String toString() {
        return "\n" + name + ": " + toppings + "\n-> Costo: " + price + ", Calorie: " + calories;
    }


}
