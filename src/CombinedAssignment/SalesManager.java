package CombinedAssignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesManager extends User {
    private List<SalesEntry> salesEntries = new ArrayList<>();
    
    public SalesManager(String username, String password, String role, String gender, String email){
        super(username, password, role, gender, email);
        this.salesEntries = new ArrayList<>();
    }
    
    public SalesManager() {
        super("defaultUsername", "defaultPassword", "SalesManager", "defaultGender", "defaultEmail");
    }
    
    public void createPurchaseRequisition(String itemName, int quantity) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("purchase_requisition.txt", true))) {
            // Generate a unique requisition ID
            String requisitionID = "REQ" + System.currentTimeMillis();
            String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String status = "Pending"; // Default status

            // Write the purchase requisition details to the file
            String line = requisitionID + "," + createdDate + "," + itemName + "," + quantity + "," + status;
            bw.write(line);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

}
