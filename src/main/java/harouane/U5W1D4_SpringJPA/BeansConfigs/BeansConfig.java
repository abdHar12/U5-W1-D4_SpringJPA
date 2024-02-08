package harouane.U5W1D4_SpringJPA.BeansConfigs;

import harouane.U5W1D4_SpringJPA.Entities.DAOs.ItemService;
import harouane.U5W1D4_SpringJPA.Entities.Menu.Drink;
import harouane.U5W1D4_SpringJPA.Entities.Menu.Pizza;
import harouane.U5W1D4_SpringJPA.Entities.Menu.Topping;
import harouane.U5W1D4_SpringJPA.Entities.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {
    @Autowired
    ItemService itemService;
    @Bean
    Pizza pizzaMargherita() {
        return new Pizza("Pizza Margherita", 1104, 4.99, new ArrayList<>());
    }

    @Bean
    Pizza hawaiianPizza() {
        return new Pizza("Hawaiian Pizza", 1024, 6.49, new ArrayList<>(Arrays.asList(pineapple(), ham())));
    }

    @Bean
    Pizza salamiPizza() {
        return new Pizza("Salami Pizza", 1160, 5.99, new ArrayList<>(Arrays.asList(salami())));
    }

    @Bean(name = "personalizedPizza")
    Pizza personalizedPizza() {
        return pizzaMargherita();
        /*
        double calories = pizzaMargherita().getCalories() + toppings.stream().mapToDouble(MenuItem::getCalories).sum();
        double price = pizzaMargherita().getPrice() + toppings.stream().mapToDouble(MenuItem::getCalories).sum();
        return new Pizza("Pizza a scelta", calories, price, toppings);*/
    }

    @Bean
    Drink wine() {
        return new Drink("Wine", 607, 7.49, 0.75, 13);
    }

    @Bean
    Drink lemonade() {
        return new Drink("Lemonade", 128, 1.29, 0.33,0);
    }

    @Bean
    Drink water() {
        return new Drink("Water", 0, 1.29, 0.50,0);
    }

    @Bean
    Topping pineapple() {

        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean
    Topping ham() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean
    Topping onions() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean
    Topping extraCheese() {
        return new Topping("Extra Cheese", 92, 0.69);
    }

    @Bean
    Topping salami() {
        return new Topping("Salami", 86, 0.99);
    }

    @Bean
    Topping tomato() {
        return new Topping("Tomato", 0, 0);
    }

    @Bean
    Topping cheese() {
        return new Topping("Cheese", 0, 0);
    }

    @Bean
    double getPriceOfSeat(@Value("${restaurant.priceSeat}") String price) {
        return Double.parseDouble(price);
    }

    @Bean
    Table getTable1() {
        return new Table(3);
    }

    @Bean
    Table getTable2() {
        return new Table(5);
    }

    @Bean
    List<Pizza> getListOfPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(pizzaMargherita());
        pizzas.add(hawaiianPizza());
        pizzas.add(salamiPizza());
        return pizzas;
    }

    @Bean
    List<Topping> getListOfToppings() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(ham());
        toppings.add(extraCheese());
        toppings.add(salami());
        toppings.add(onions());
        toppings.add(pineapple());
        return toppings;
    }

    @Bean
    List<Drink> getListOfDrinks() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(water());
        drinks.add(lemonade());
        drinks.add(wine());
        return drinks;
    }

}
