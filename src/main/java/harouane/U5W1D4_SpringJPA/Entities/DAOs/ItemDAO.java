package harouane.U5W1D4_SpringJPA.Entities.DAOs;

import harouane.U5W1D4_SpringJPA.Entities.Menu.MenuItem;
import harouane.U5W1D4_SpringJPA.Entities.Menu.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByName(String name);
    MenuItem findById(long Id);
}
