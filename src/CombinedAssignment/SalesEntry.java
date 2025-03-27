package CombinedAssignment;
import java.util.Date;

public class SalesEntry {
    private String salesEntryID;
    private String itemName;
    private int quantity;
    private Date salesDate;

    public SalesEntry(String salesEntryID, String itemName, int quantity, Date salesDate) {
        this.salesEntryID = salesEntryID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.salesDate = salesDate;
    }
    
    public String getSalesEntryID() {
        return salesEntryID;
    }

    public String getItemName(){
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getSalesDate() {
        return salesDate;
    }
    
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }
}
