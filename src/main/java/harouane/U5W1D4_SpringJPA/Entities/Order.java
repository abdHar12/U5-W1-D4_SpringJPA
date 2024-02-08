package harouane.U5W1D4_SpringJPA.Entities;

import harouane.U5W1D4_SpringJPA.Entities.Enums.StateOfOrder;
import harouane.U5W1D4_SpringJPA.Entities.Enums.StateOfTable;
import harouane.U5W1D4_SpringJPA.Entities.Menu.MenuItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Order {
    static List<Integer> listOfNumbers = new ArrayList<>();
    int numOfOrder;
    double hourOfAcquisition;
    StateOfOrder state;
    Table table;
    double priceOrder;
    List<MenuItem> menuItemList;
    double priceOftable;

    public Order(double hourOfAcquisition, Table table, List<MenuItem> menuItemList, double priceOftable) {
        this.hourOfAcquisition = hourOfAcquisition;
        this.state = StateOfOrder.PENDING;
        this.table = table;
        this.table.state = StateOfTable.OCCUPIED;
        this.menuItemList = menuItemList;
        this.priceOftable = priceOftable;
        this.priceOrder = menuItemList.stream().mapToDouble(MenuItem::getPrice).sum() + (priceOftable * table.numberOfSeats);
        Random random = new Random();
        int num;
        do {
            num = random.nextInt(1, 100);
            if (!listOfNumbers.contains(num)) {
                this.numOfOrder = num;
                listOfNumbers.add(num);
            }
        } while (!listOfNumbers.contains(num));
    }

    @Override
    public String toString() {
        return "Order{\n" +
                "numOfOrder=" + numOfOrder +
                ",\nhourOfAcquisition=" + hourOfAcquisition +
                ",\nstate=" + state +
                ",\ntable=" + table +
                ",\npriceOrder=" + priceOrder +
                ",\nMenuItemList=" + menuItemList +
                '}';
    }
}
