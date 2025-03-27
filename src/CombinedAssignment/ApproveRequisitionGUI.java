package CombinedAssignment;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ApproveRequisitionGUI extends javax.swing.JFrame {
    static String user;
    static int selectedIndex = -1;
    private DefaultTableModel modelPurchaseRequisitions = new DefaultTableModel();
    private String[] columnName = {"Requisition ID", "Created Date", "Item Name", "Quantity", "Status"};

    public ApproveRequisitionGUI(String user) {
        this.user = user;
        initComponents();
        
        modelPurchaseRequisitions.setColumnIdentifiers(columnName);
        loadTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReject = new javax.swing.JButton();
        btnApprove = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchaseRequisitions = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReject.setBackground(new java.awt.Color(255, 153, 255));
        btnReject.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        btnApprove.setBackground(new java.awt.Color(153, 255, 153));
        btnApprove.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 102, 102));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblPurchaseRequisitions.setModel(modelPurchaseRequisitions);
        tblPurchaseRequisitions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPurchaseRequisitionsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPurchaseRequisitions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new PurchaseManagerGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblPurchaseRequisitionsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPurchaseRequisitionsMouseReleased
        selectedIndex = tblPurchaseRequisitions.getSelectedRow();
    }//GEN-LAST:event_tblPurchaseRequisitionsMouseReleased

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a requisition to approve.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (modelPurchaseRequisitions.getValueAt(selectedIndex, 4).toString().equals("Approved")) {
            JOptionPane.showMessageDialog(this, "This requisition has already been approved!");
            return;
        }
        
        modelPurchaseRequisitions.setValueAt("Approved", selectedIndex, 4);
        
        String requisitionID = modelPurchaseRequisitions.getValueAt(selectedIndex, 0).toString();
        String createdDate = modelPurchaseRequisitions.getValueAt(selectedIndex, 1).toString();
        String itemName = modelPurchaseRequisitions.getValueAt(selectedIndex, 2).toString();
        String quantity = modelPurchaseRequisitions.getValueAt(selectedIndex, 3).toString();
        
        editPR(requisitionID, createdDate, itemName, quantity, "Approved");
        
        JOptionPane.showMessageDialog(this, "Requisition approved!");
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a requisition to reject.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (modelPurchaseRequisitions.getValueAt(selectedIndex, 4).toString().equals("Rejected")) {
            JOptionPane.showMessageDialog(this, "This requisition has already been rejected!");
            return;
        }
        
        modelPurchaseRequisitions.setValueAt("Rejected", selectedIndex, 4);
        
        String requisitionID = modelPurchaseRequisitions.getValueAt(selectedIndex, 0).toString();
        String createdDate = modelPurchaseRequisitions.getValueAt(selectedIndex, 1).toString();
        String itemName = modelPurchaseRequisitions.getValueAt(selectedIndex, 2).toString();
        String quantity = modelPurchaseRequisitions.getValueAt(selectedIndex, 3).toString();
        
        editPR(requisitionID, createdDate, itemName, quantity, "Rejected");
        
        JOptionPane.showMessageDialog(this, "Requisition rejected!");
    }//GEN-LAST:event_btnRejectActionPerformed

    private void loadTableData() {
        modelPurchaseRequisitions.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("purchase_requisition.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into columns using a comma as a delimiter
                String[] rowData = line.split(",");
                modelPurchaseRequisitions.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void editPR(String requisitionID, String dateCreated, String itemName, String quantity, String status) {
        try {
            // Read all lines from the file
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("purchase_requisition.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] rowData = line.split(",");
                    if (rowData[0].equals(requisitionID)) {
                        // Replace the old data with updated data
                        line = requisitionID + "," + dateCreated + "," + itemName + "," + quantity + "," + status;
                    }
                    lines.add(line);
                }
            }

            // Write the updated lines back to the file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("purchase_requisition.txt"))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating requisition: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApproveRequisitionGUI(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReject;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPurchaseRequisitions;
    // End of variables declaration//GEN-END:variables
}
