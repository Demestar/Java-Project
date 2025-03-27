package CombinedAssignment;
import java.io.Serializable;
import java.util.*;

public class InventoryManager extends User implements Serializable{
    private final List<Item> items;
    private final List<Supplier> suppliers;
    
    public InventoryManager(String username, String password, String role, String gender, String email) {
        super(username, password, role, gender, email);
        this.items = new ArrayList<>();
        this.suppliers = new ArrayList<>();
    } 
}
