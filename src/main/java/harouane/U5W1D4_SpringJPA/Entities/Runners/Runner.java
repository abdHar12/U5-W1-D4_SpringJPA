package harouane.U5W1D4_SpringJPA.Entities.Runners;

import harouane.U5W1D4_SpringJPA.Entities.DAOs.ItemService;
import harouane.U5W1D4_SpringJPA.Entities.Menu.*;
import harouane.U5W1D4_SpringJPA.Entities.Order;
import harouane.U5W1D4_SpringJPA.Entities.Table;
import harouane.U5W1D4_SpringJPA.U5W1D4SpringJpaApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    Menu menu;
    @Autowired
    ItemService itemService;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D4SpringJpaApplication.class);
        menu.print();
        Table table = (Table) ctx.getBean("getTable1");

        Drink drink1 = (Drink) ctx.getBean("wine");
        Drink drink2 = (Drink) ctx.getBean("water");
        Drink drink3 = (Drink) ctx.getBean("lemonade");
        double priceOfTable = (double) ctx.getBean("getPriceOfSeat");
        Topping topping1= (Topping) ctx.getBean("ham");
        Topping topping2= (Topping) ctx.getBean("extraCheese");
        Topping topping3= (Topping) ctx.getBean("onions");
        Topping topping4= (Topping) ctx.getBean("pineapple");
        Topping topping5= (Topping) ctx.getBean("salami");
        itemService.save(topping1);
        itemService.save(topping2);
        itemService.save(topping3);
        itemService.save(topping4);
        itemService.save(topping5);
        itemService.save(drink1);
        itemService.save(drink2);
        itemService.save(drink3);
        Pizza pizza1 = (Pizza) ctx.getBean("hawaiianPizza");
        pizza1.setToppings(new ArrayList<>(Arrays.asList((Topping) itemService.findById(4), (Topping) itemService.findById(1))));
        Pizza pizza2 = (Pizza) ctx.getBean("pizzaMargherita");
        pizza2.setToppings(new ArrayList<>());
        Pizza pizza3 = (Pizza) ctx.getBean("salamiPizza");
        pizza3.setToppings(new ArrayList<>(List.of((Topping) itemService.findById(5))));
        itemService.save(pizza1);
        itemService.save(pizza2);
        itemService.save(pizza3);

        /*List<MenuItem> menuItemList = new ArrayList<>(Arrays.asList(pizza1, pizza2, pizza3, drink3, drink2, drink1));
        Order order = new Order(21.00, table, menuItemList, priceOfTable);
        System.out.println(order);*/
    }
}
