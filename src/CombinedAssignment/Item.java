package CombinedAssignment;
import java.io.*;
public class Item implements Serializable{
    private String itemID;
    private String itemName;
    private String itemDesc;
    private int stockLevel;
    private int reorderLevel;
    private double itemPrice;
    private String SupplierID;
    private String status;
    private String paidDate;
    private String paidTime;

    public String getItemID() {
        return itemID;
    }
     public Item(String itemID, String itemName, String itemDesc, int stockLevel, int reorderLevel, double itemPrice, String SupplierID, String status, String paidDate, String paidTime) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.stockLevel = stockLevel;
        this.reorderLevel = reorderLevel;
        this.itemPrice = itemPrice;
        this.SupplierID = SupplierID;
        this.status = status;
        this.paidDate = paidDate;
        this.paidTime = paidTime;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public int getStockLevel() {
        return stockLevel;
    }
     

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPaidDate() {
        return paidDate;
    }
    
     public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }
    
    public String getPaidTime() {
        return paidTime;
    }
    
    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }
    
    
    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", stockLevel=" + stockLevel +
                ", reorderLevel=" + reorderLevel +
                ", itemPrice=" + itemPrice +
                ", status=" + status +
                ", paidDate=" + paidDate +
                ", paidTime=" + paidTime +
                '}';
    }
    
}