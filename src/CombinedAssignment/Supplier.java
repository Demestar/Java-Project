package CombinedAssignment;

import java.io.Serializable;

public class Supplier implements Serializable{
    private String supplierID;
    private String supplierName;
    private String supplierContact;
    private String paymentStatus;
    
    public Supplier(String supplierID, String supplierName, String supplierContact, String paymentStatus){
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierContact = supplierContact;
        this.paymentStatus = paymentStatus;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

