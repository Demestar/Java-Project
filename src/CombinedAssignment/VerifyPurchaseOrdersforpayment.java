package CombinedAssignment;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;


public class VerifyPurchaseOrdersforpayment extends javax.swing.JFrame {
    static String user;
    private DefaultTableModel tableModel = new DefaultTableModel();
    String[] columnNames = {"Order ID", "Item Name", "Price", "Stock", "Status"};
    static int selectedRow = -1;
    /**
     * Creates new form VerifyPurchaseOrdersforpayment
     */
    public VerifyPurchaseOrdersforpayment(String user) { 
        this.user = user;
        tableModel.setColumnIdentifiers(columnNames);
        initComponents();

        loadTableDataFromFile();
        
    }
    
    /**
     * Method to load data into the table from a text file.
     */
    private void loadTableDataFromFile() {
        tableModel.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("purchase_order.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into columns using a comma as a delimiter
                String[] rowData = line.split(",");
                tableModel.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void editPO(String itemID, String itemName, String price, String stock, String status) {
        try {
            // Read all lines from the file
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("purchase_order.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] rowData = line.split(",");
                    if (rowData[0].equals(itemID)) {
                        // Replace the old data with updated data
                        line = itemID + "," + itemName + "," + price + "," + stock + "," + status;
                    }
                    lines.add(line);
                }
            }

            // Write the updated lines back to the file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("purchase_order.txt"))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating status: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        approvebtn = new javax.swing.JButton();
        rejectbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVerify = new javax.swing.JTable();
        Backbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        approvebtn.setBackground(new java.awt.Color(102, 255, 102));
        approvebtn.setText("Approve");
        approvebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvebtnActionPerformed(evt);
            }
        });

        rejectbtn.setBackground(new java.awt.Color(255, 51, 51));
        rejectbtn.setText("Reject");
        rejectbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectbtnActionPerformed(evt);
            }
        });

        jTableVerify.setModel(tableModel);
        jTableVerify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableVerifyMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableVerify);

        Backbtn.setBackground(new java.awt.Color(255, 102, 102));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(approvebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(rejectbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rejectbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(approvebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approvebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvebtnActionPerformed
         if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to Approve.");
            return;
        }
        else if (tableModel.getValueAt(selectedRow, 4).toString().equals("Approved")) {
            JOptionPane.showMessageDialog(this, "This order has already been approved!");
            return;
        }
        
        tableModel.setValueAt("Approved", selectedRow, 4);
        
        String itemID = tableModel.getValueAt(selectedRow, 0).toString();
        String itemName = tableModel.getValueAt(selectedRow, 1).toString();
        String price = tableModel.getValueAt(selectedRow, 2).toString();
        String stock = tableModel.getValueAt(selectedRow, 3).toString();
        
        editPO(itemID, itemName, price, stock, "Approved");
        
        JOptionPane.showMessageDialog(this, "Purchase Order Approved!");
    }//GEN-LAST:event_approvebtnActionPerformed

    private void rejectbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectbtnActionPerformed
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to Reject.");
            return;
        }
        else if (tableModel.getValueAt(selectedRow, 4).toString().equals("Rejected")) {
            JOptionPane.showMessageDialog(this, "This order has already been rejected!");
            return;
        }
        
        tableModel.setValueAt("Rejected", selectedRow, 4);
        
        String itemID = tableModel.getValueAt(selectedRow, 0).toString();
        String itemName = tableModel.getValueAt(selectedRow, 1).toString();
        String price = tableModel.getValueAt(selectedRow, 2).toString();
        String stock = tableModel.getValueAt(selectedRow, 3).toString();
        
        editPO(itemID, itemName, price, stock, "Rejected");
        
        JOptionPane.showMessageDialog(this, "Purchase Order Rejected!");
    }//GEN-LAST:event_rejectbtnActionPerformed

    private void jTableVerifyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVerifyMouseReleased
        selectedRow = jTableVerify.getSelectedRow();
    }//GEN-LAST:event_jTableVerifyMouseReleased

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        new Finance(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new VerifyPurchaseOrdersforpayment(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton approvebtn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVerify;
    private javax.swing.JButton rejectbtn;
    // End of variables declaration//GEN-END:variables

}
