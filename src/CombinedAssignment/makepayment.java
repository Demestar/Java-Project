package CombinedAssignment;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;


public class makepayment extends javax.swing.JFrame {
    static String user;
    private DefaultTableModel PaymentModel = new DefaultTableModel();
    private String[] columnNames = {"ID","Name","Description","Stock Level","Reorder Level","Price","SupplierID","Status","Date Paid","Time Paid"};
    private final List<Item> itemsList = new ArrayList<>();

    static int selectedRow = -1;

    //File path saved in variable    
    String filePath = "Items"; // Define the file path

    //Rread Data from file Items.txt
        private void ImportStockData() {
        itemsList.clear();
        File file = new File(filePath);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Item item = (Item) ois.readObject(); // Read each Item object
                    itemsList.add(item); // Add the Item object to the list
                } catch (EOFException e){
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
        
    private void populateTable(List<Item> itemsList) {
        PaymentModel.setRowCount(0); // Clear existing data in the table
        for (Item item : itemsList) {
            // Extract attributes from each Item object
            Object[] row = {
                item.getItemID(),
                item.getItemName(),
                item.getItemDesc(),
                item.getStockLevel(),
                item.getReorderLevel(),
                item.getItemPrice(),
                item.getSupplierID(),
                item.getStatus(),
                item.getPaidDate(),
                item.getPaidTime()
            };
            PaymentModel.addRow(row); // Add the row to the table model
        }
    }
    
    public makepayment(String user) {
        this.user = user;
        PaymentModel.setColumnIdentifiers(columnNames);
        initComponents();
        
        ImportStockData(); // Read data from the file
        populateTable(itemsList);
    }
    
    private void updatePaymentDetails(String paymentMethod) {
        if (selectedRow != -1) {
            String currentStatus = (String) PaymentModel.getValueAt(selectedRow, 7); // Get current status
            if ("Paid".equalsIgnoreCase(currentStatus)) {
                JOptionPane.showMessageDialog(this, "This payment has already been made.");
            } else {
                // Get current date and time
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                
                // Correct reference to itemsList
                Item selectedItem = itemsList.get(selectedRow);

                selectedItem.setStatus("Paid");
                selectedItem.setPaidDate(now.format(dateFormatter));
                selectedItem.setPaidTime(now.format(timeFormatter));

                // Update the table
                populateTable(itemsList);

                // Write updated data to the file
                writeItemsToFile(filePath);

                JOptionPane.showMessageDialog(this, "Successful Transaction (" + paymentMethod + ")");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row (order) to complete payment.");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTablePayment = new javax.swing.JTable();
        PayCashBtn = new javax.swing.JButton();
        PayDcBtn = new javax.swing.JButton();
        PayEBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTablePayment.setModel(PaymentModel);
        JTablePayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTablePaymentMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(JTablePayment);

        PayCashBtn.setBackground(new java.awt.Color(0, 255, 204));
        PayCashBtn.setText("Pay by Cash");
        PayCashBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayCashBtnActionPerformed(evt);
            }
        });

        PayDcBtn.setBackground(new java.awt.Color(204, 102, 255));
        PayDcBtn.setText("Pay by Debit/credit");
        PayDcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayDcBtnActionPerformed(evt);
            }
        });

        PayEBtn.setBackground(new java.awt.Color(153, 153, 255));
        PayEBtn.setText("Pay by E-Wallet");
        PayEBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayEBtnActionPerformed(evt);
            }
        });

        BackBtn.setBackground(new java.awt.Color(255, 153, 153));
        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PayCashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(PayEBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(PayDcBtn)
                .addGap(50, 50, 50)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PayDcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PayCashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PayEBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PayCashBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayCashBtnActionPerformed
        updatePaymentDetails("Paid by Cash");
    }//GEN-LAST:event_PayCashBtnActionPerformed

    private void PayDcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayDcBtnActionPerformed
        updatePaymentDetails("Paid by Debit/Credit Card");
    }//GEN-LAST:event_PayDcBtnActionPerformed

    private void PayEBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayEBtnActionPerformed
        updatePaymentDetails("Paid by E-Wallet");
    }//GEN-LAST:event_PayEBtnActionPerformed

    private void JTablePaymentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePaymentMouseReleased
        selectedRow = JTablePayment.getSelectedRow();
    }//GEN-LAST:event_JTablePaymentMouseReleased

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        new Finance(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed
  
    private void writeItemsToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Item item : itemsList) {
            // Serialize each Item object
            oos.writeObject(item);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new makepayment(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTable JTablePayment;
    private javax.swing.JButton PayCashBtn;
    private javax.swing.JButton PayDcBtn;
    private javax.swing.JButton PayEBtn;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
