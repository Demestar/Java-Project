package CombinedAssignment;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

public class UserManagementUI extends javax.swing.JFrame {
    static String user;
    static boolean usersFileFound = true;
    static String username, password, role, gender, email;
    private ButtonGroup genderGroup = new ButtonGroup();
    private int selectedRow = -1;
    private DefaultTableModel UsersTable = new DefaultTableModel();
    private String[] columnName = { "Username", "Password", "Role", "Gender", "Email" };
    
    // Attempts to load users, passwords and roles from the file
    Map<String, User> users = loadUsers("users.txt");

    public UserManagementUI(String user) {
        this.user = user;
        UsersTable.setColumnIdentifiers(columnName);
        
        initComponents();
        
        if (usersFileFound == false) {
            JOptionPane.showMessageDialog(this, "File not found, terminating program...");
            System.exit(0);
        }
        
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        
        clearFields();
        
        //List the users in the table from the txt file
        listUsers(users);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBoxPassword = new javax.swing.JTextField();
        txtBoxUsername = new javax.swing.JTextField();
        txtBoxEmail = new javax.swing.JTextField();
        rbFemale = new javax.swing.JRadioButton();
        rbMale = new javax.swing.JRadioButton();
        cbRole = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Management");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Password:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Role:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Gender:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Email:");

        txtBoxPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBoxPassword.setToolTipText("");

        txtBoxUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBoxUsername.setToolTipText("");

        txtBoxEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBoxEmail.setToolTipText("");

        rbFemale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbFemale.setText("Female");
        rbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemaleActionPerformed(evt);
            }
        });

        rbMale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbMale.setText("Male");

        cbRole.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Role", "Administrator", "Finance Manager", "Inventory Manager", "Sales Manager", "Purchase Manager" }));

        btnEdit.setBackground(new java.awt.Color(255, 204, 102));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 102, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(153, 255, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 153, 153));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblUsers.setModel(UsersTable);
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblUsersMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Username cannot be changed once added");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Spaces in username, password and email will be removed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel2))
                                                .addGap(5, 5, 5)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(txtBoxUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtBoxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtBoxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel6))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBack)
                                    .addComponent(btnDelete)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnAdd)
                                        .addComponent(btnEdit)))
                                .addGap(87, 87, 87))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBoxUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBoxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtBoxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFemaleActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to edit.");
        }
        else if (txtBoxPassword.getText().isEmpty()) {
            //If password is empty
            JOptionPane.showMessageDialog(this, "Password is empty!");
        }
        else if (cbRole.getSelectedIndex() == 0) {
            //If no role is selected
            JOptionPane.showMessageDialog(this, "Please select a role for that user!");
        }
        else if (rbMale.isSelected() == false && rbFemale.isSelected() == false) {
            //If no gender is selected
            JOptionPane.showMessageDialog(this, "Please select a gender!");
        }
        else if (txtBoxEmail.getText().isEmpty()) {
            //If email is empty
            JOptionPane.showMessageDialog(this, "Email is empty!");
        }
        else {
            //Sets the respective new user information variables
            password = txtBoxPassword.getText().replace(" ", "");
            switch (cbRole.getSelectedIndex()) {
                case 1:
                    role = "Administrator";
                    break;
                case 2:
                    role = "FinanceManager";
                    break;
                case 3:
                    role = "InventoryManager";
                    break;
                case 4:
                    role = "SalesManager";
                    break;
                case 5:
                    role = "PurchaseManager";
                    break;
                default:
                    break;
            }
            if (rbMale.isSelected()) {
                gender = "Male";
            }
            else {
                gender = "Female";
            }
            email = txtBoxEmail.getText().replace(" ", "");
          
            //Edits the user to the txt file
            editUser("users.txt", username, password, role, gender, email);
            JOptionPane.showMessageDialog(this, "User " + username + " edited successfully!");
            
            users = loadUsers("users.txt");
            //List the users in the table from the txt file
            listUsers(users);
            clearFields();
            selectedRow = -1;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new AdminUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtBoxUsername.getText().isEmpty()) {
            //If username is empty
            JOptionPane.showMessageDialog(this, "Username is empty!");
        }
        else if (users.containsKey(txtBoxUsername.getText())) {
            //If there's already an existing user with that username
            JOptionPane.showMessageDialog(this, "That username already exists! Please choose a different username!");
        }
        else if (txtBoxPassword.getText().isEmpty()) {
            //If password is empty
            JOptionPane.showMessageDialog(this, "Password is empty!");
        }
        else if (cbRole.getSelectedIndex() == 0) {
            //If no role is selected
            JOptionPane.showMessageDialog(this, "Please select a role for that user!");
        }
        else if (rbMale.isSelected() == false && rbFemale.isSelected() == false) {
            //If no gender is selected
            JOptionPane.showMessageDialog(this, "Please select a gender!");
        }
        else if (txtBoxEmail.getText().isEmpty()) {
            //If email is empty
            JOptionPane.showMessageDialog(this, "Email is empty!");
        }
        else {
            //Sets the respective new user information variables
            username = txtBoxUsername.getText().replace(" ", "");
            password = txtBoxPassword.getText().replace(" ", "");
            switch (cbRole.getSelectedIndex()) {
                case 1:
                    role = "Administrator";
                    break;
                case 2:
                    role = "FinanceManager";
                    break;
                case 3:
                    role = "InventoryManager";
                    break;
                case 4:
                    role = "SalesManager";
                    break;
                case 5:
                    role = "PurchaseManager";
                    break;
                default:
                    break;
            }
            if (rbMale.isSelected()) {
                gender = "Male";
            }
            else {
                gender = "Female";
            }
            email = txtBoxEmail.getText().replace(" ", "");
          
            //Adds the user to the txt file
            addUser("users.txt", username, password, role, gender, email);
            JOptionPane.showMessageDialog(this, "New user added successfully!");
            
            users = loadUsers("users.txt");
            //List the users in the table from the txt file
            listUsers(users);
            clearFields();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedRow == -1)
        {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
        }
        else if (username.equals(user)) {
            JOptionPane.showMessageDialog(this, "You cannot delete yourself, are you crazy??");
        }
        else {
            deleteUser("users.txt", username);
            JOptionPane.showMessageDialog(this, "User " + username + " deleted successfully!");
            
            users = loadUsers("users.txt");
            //List the users in the table from the txt file
            listUsers(users);
            clearFields();
            selectedRow = -1;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblUsersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseReleased
        selectedRow = tblUsers.getSelectedRow();
        setTextFields(selectedRow);
    }//GEN-LAST:event_tblUsersMouseReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManagementUI(user).setVisible(true);
            }
        });
    }
    
    //Function that attempts to load usernames, passwords and roles
    private Map<String, User> loadUsers(String fileName) {
        Map<String, User> users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 5) {
                    String username = parts[0];
                    String password = parts[1];
                    String role = parts[2];
                    String gender = parts[3];
                    String email = parts[4];
                    users.put(username, new User(username, password, role, gender, email));
                    usersFileFound = true;
                }
            }
        } catch (IOException e) {
            usersFileFound = false;
        }
        return users;
    }
    
    //Function to reset the fields
    public void clearFields() {
        txtBoxUsername.setText("");
        txtBoxPassword.setText("");
        cbRole.setSelectedIndex(0);
        genderGroup.clearSelection();
        txtBoxEmail.setText("");
    }
    
    //Sets the text fields based on the selected row
    public void setTextFields(int rowNumber) {
        txtBoxUsername.setText((String)UsersTable.getValueAt(rowNumber, 0));
        username = (String)UsersTable.getValueAt(rowNumber, 0);
        
        txtBoxPassword.setText((String)UsersTable.getValueAt(rowNumber, 1));
        
        switch ((String)UsersTable.getValueAt(rowNumber, 2)) {
            case "Administrator":
                cbRole.setSelectedIndex(1);
                break;
            case "FinanceManager":
                cbRole.setSelectedIndex(2);
                break;
            case "InventoryManager":
                cbRole.setSelectedIndex(3);
                break;
            case "SalesManager":
                cbRole.setSelectedIndex(4);
                break;
            case "PurchaseManager":
                cbRole.setSelectedIndex(5);
                break;
            default:
                cbRole.setSelectedIndex(0);
        }
        
        switch ((String)UsersTable.getValueAt(rowNumber, 3)) {
            case "Male":
                rbMale.setSelected(true);
                rbFemale.setSelected(false);
                break;
            case "Female":
                rbMale.setSelected(false);
                rbFemale.setSelected(true);
                break;
            default:
                rbMale.setSelected(false);
                rbFemale.setSelected(false);
        }
        
        txtBoxEmail.setText((String)UsersTable.getValueAt(rowNumber, 4));
    }
    
    //Function to list all the users
    //Uses for loop to scroll through every user information in the txt file
    private void listUsers(Map<String, User> users) {
        //Resets the table
        UsersTable.setRowCount(0);
        
        for (User user : users.values()) {
            String userData[] = { user.getUsername(), user.getPassword(), user.getRole(), user.getGender(), user.getEmail() };
            UsersTable.addRow(userData);
        }
    }
    
    //Function to add the new user to the file
    private static void addUser(String fileName, String username, String password, String role, String gender, String email) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(username + " " + password + " " + role + " " + gender + " " + email);
            bw.newLine();
        }
        catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage() + "\nTerminating program...");
        }
    }
    
    //Function to delete the user
    //The function will run through the current txt file to check for existing usernames
    //If the username does not match the username to be deleted, it will store it in an array
    //So, the user's information that's going to be deleted will not be stored in the array
    //The array containing users' information is then rewrittten into the txt file
    private static void deleteUser(String fileName, String usernameToDelete) {
        File inputFile = new File(fileName);
        List<String> linesToKeep = new ArrayList<>();

        // Read the file and collect the lines to keep
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 5 && !parts[0].equals(usernameToDelete)) {
                    linesToKeep.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write the lines to keep back to the original file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            for (String line : linesToKeep) {
                writer.write(line);
                writer.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    //Function to edit the user information
    private static void editUser(String fileName, String username, String newPassword, String newRole, String newGender, String newEmail) {
        File inputFile = new File(fileName);
        List<String> linesToKeep = new ArrayList<>();

        // Read the file and update the user information
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 5) {
                    if (parts[0].equals(username)) {
                        // Update the user's information
                        linesToKeep.add(username + " " + newPassword + " " + newRole + " " + newGender + " " + newEmail);
                    } else {
                        linesToKeep.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write the updated information back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            for (String line : linesToKeep) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtBoxEmail;
    private javax.swing.JTextField txtBoxPassword;
    private javax.swing.JTextField txtBoxUsername;
    // End of variables declaration//GEN-END:variables
}
