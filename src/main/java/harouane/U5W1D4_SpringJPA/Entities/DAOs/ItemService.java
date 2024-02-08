package harouane.U5W1D4_SpringJPA.Entities.DAOs;

import harouane.U5W1D4_SpringJPA.Entities.Menu.MenuItem;
import harouane.U5W1D4_SpringJPA.Entities.Menu.Pizza;
import harouane.U5W1D4_SpringJPA.Entities.Menu.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemDAO itemDAO;

    public void save(MenuItem item){
        itemDAO.save(item);
    }
    public MenuItem findById(long id){
        return itemDAO.findById(id);
    }
/*    public setToppingsForPizza(Pizza pizza){
        pizza.setToppings();
    }*/
/*    public void setPizzasTopping(Pizza pizza, List<Topping> toppings){
        Optional<MenuItem> pizza1=itemDAO.findById(pizza.getId());
if (pizza1.isPresent())
    pizza1.set

    }*/
}
