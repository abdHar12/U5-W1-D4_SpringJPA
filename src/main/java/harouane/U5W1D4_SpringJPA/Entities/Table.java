package harouane.U5W1D4_SpringJPA.Entities;

import harouane.U5W1D4_SpringJPA.Entities.Enums.StateOfTable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Table {
    static List<Integer> listOfNumbers = new ArrayList<>();
    Integer numTable;
    int numberOfSeats;
    StateOfTable state;

    public Table(int numberOfSeats) {
        Random random = new Random();
        int num;
        do {
            num = random.nextInt(1, 100);
            if (!listOfNumbers.contains(num)) {
                this.numTable = num;
                listOfNumbers.add(num);
            }
        } while (!listOfNumbers.contains(num));
        this.numberOfSeats = numberOfSeats;
        this.state = StateOfTable.FREE;
    }

    @Override
    public String toString() {
        return "Table{" +
                "numTable=" + numTable +
                ", numberOfSeats=" + numberOfSeats +
                ", state=" + state +
                '}';
    }
}
