package CombinedAssignment;

import java.util.Date;

public class PurchaseRequisition {
    // Attributes
    private String requisitionID;
    private Date createdDate;
    private String itemName;
    private int quantity;
    private String status;

    // Constructor
    public PurchaseRequisition(String requisitionID, Date createdDate, String itemName, int quantity, String status) {
        this.requisitionID = requisitionID;
        this.createdDate = createdDate;
        this.itemName = itemName;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters
    public String getRequisitionID() {
        return requisitionID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setRequisitionID(String requisitionID) {
        this.requisitionID = requisitionID;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
