/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;


import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.MySQL;


public class EmployeeRegistration extends javax.swing.JFrame {

    private int Row;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form EmployeeRegistration
     */
    public void loadUsers() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `employee` INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` INNER JOIN `city` ON `employee`.`city_id`=`city`.`id` INNER JOIN `department` ON `employee`.`department_id`= `department`.`id` INNER JOIN `employee_type` ON `employee`.`employee_type_id`= `employee_type`.`id`;");

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("gender.gender"));
                v.add(rs.getString("dob"));
                v.add(rs.getString("contact_no"));
                v.add(rs.getString("address"));
                v.add(rs.getString("city.city"));
                v.add(rs.getString("department.department"));
                v.add(rs.getString("employee_type.type"));
                v.add(rs.getString("salary"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadUsers(String text) {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `guest` INNER JOIN `gender` ON `guest`.`gender_id` = `gender`.`id` INNER JOIN `city` ON `guest`.`city_id`=`city`.`id` INNER JOIN `country` ON `guest`.`country_id`= `country`.`id` INNER JOIN `booking` ON `guest`.`booking_id`= `booking`.`id` WHERE `guest`.`first_name` LIKE '" + text + "%' ORDER BY `guest`.`id` ASC");

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("gender_id"));
                v.add(rs.getString("dob"));
                v.add(rs.getString("contact_no"));
                v.add(rs.getString("address"));
                v.add(rs.getString("city_id"));
                v.add(rs.getString("department_id"));
                v.add(rs.getString("employee_id"));
                v.add(rs.getString("salary"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadCities() {

        try {

            ResultSet rs = MySQL.search("SELECT * FROM `city`");

            Vector v = new Vector();
            v.add("select");

            while (rs.next()) {
                v.add(rs.getString("city"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox2.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadGender() {

        try {

            ResultSet rs = MySQL.search("SELECT * FROM `gender`");

            Vector v = new Vector();
            v.add("select");

            while (rs.next()) {
                v.add(rs.getString("gender"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadDepartment() {

        try {

            ResultSet rs = MySQL.search("SELECT * FROM `department`");

            Vector v = new Vector();
            v.add("select");

            while (rs.next()) {
                v.add(rs.getString("department"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox3.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadEmployeeType() {

        try {

            ResultSet rs = MySQL.search("SELECT * FROM `employee_type`");

            Vector v = new Vector();
            v.add("select");

            while (rs.next()) {
                v.add(rs.getString("type"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox4.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void resetFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        jTextField5.setText("");
        jTextField6.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jTextField7.setText("");

        jTextField1.grabFocus();
    }

    public void setStatusButtonListner() {

        ListSelectionListener lsl;
        lsl = (ListSelectionEvent e) -> {
            int selectedRow = jTable2.getSelectedRow();

            if (selectedRow != -1) {

                String id = jTable2.getValueAt(selectedRow, 0).toString();

                if (id.equals("1")) {
                    jButton2.setEnabled(false);
                } else {
                    jButton2.setEnabled(true);
                }

            }
        };

        jTable2.getSelectionModel().addListSelectionListener(lsl);

    }

    public EmployeeRegistration() {
        initComponents();

        loadUsers();
        loadCities();
        loadGender();
        loadDepartment();
        loadEmployeeType();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton3.setText("Register");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/admin Home.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Registration");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel6.setPreferredSize(new java.awt.Dimension(1370, 768));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setBackground(new java.awt.Color(153, 255, 153));
        jButton11.setFont(new java.awt.Font("Goudy Old Style", 1, 30)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 17, 17));
        jButton11.setText("Print Report");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 200, 40));

        jButton12.setBackground(new java.awt.Color(153, 255, 153));
        jButton12.setFont(new java.awt.Font("Goudy Old Style", 1, 30)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 17, 17));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logout.png"))); // NOI18N
        jButton12.setText("Log Out ");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 170, 40));

        jButton10.setBackground(new java.awt.Color(153, 255, 153));
        jButton10.setFont(new java.awt.Font("Goudy Old Style", 1, 30)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 17, 17));
        jButton10.setText("Dashboard ");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 42));

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 19, 590, 79));

        jLabel1.setFont(new java.awt.Font("Goudy Old Style", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Employee Registration ");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 37, 469, 86));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo7_17_18106.png"))); // NOI18N
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 27, -1, -1));

        jPanel7.setBackground(new java.awt.Color(153, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("First Name");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, 110, -1));

        jTextField1.setNextFocusableComponent(jTextField2);
        jPanel7.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 32, 317, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 204));
        jLabel16.setText("Last Name");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, 110, -1));
        jPanel7.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 60, 317, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 204));
        jLabel17.setText("NIC");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 110, -1));
        jPanel7.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 92, 317, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Date Of Birth");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 146, -1, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Contact Number");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 174, 110, -1));
        jPanel7.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 177, 317, -1));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("City");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, -1));

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 204));
        jLabel22.setText("Department");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 259, 110, -1));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 204));
        jLabel23.setText("Gender");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, 110, -1));

        jPanel7.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 232, 317, -1));

        jPanel7.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 261, 317, -1));

        jPanel7.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 119, 317, -1));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Add1.png"))); // NOI18N
        jButton1.setText("Register");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 317, -1));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/update icon.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 317, -1));

        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/erase-128.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 317, -1));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 204));
        jLabel24.setText("Category");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 292, 118, -1));

        jPanel7.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 294, 317, -1));

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 204));
        jLabel26.setText("Address");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 110, -1));
        jPanel7.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 205, 317, -1));

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 204));
        jLabel27.setText("Salary");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 110, 20));
        jPanel7.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 317, 20));
        jPanel7.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 310, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 154, 478, 586));

        jPanel8.setBackground(new java.awt.Color(153, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(879, 517));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Nane", "Last Name", "NIC", "Gender", "Date of Birth", "Contact No", "Address", "City", "Department", "Category", "Salary"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 840, 457));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel25.setText("Customer Search");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 18, 130, -1));

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField14KeyReleased(evt);
            }
        });
        jPanel8.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 23, 700, 20));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 164, 860, 532));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/admin Home.png"))); // NOI18N
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String firstname = jTextField1.getText();
        String lastname = jTextField2.getText();
        String nic = jTextField3.getText();
        String gender = jComboBox1.getSelectedItem().toString();
        Date dob1 = jDateChooser1.getDate();
        String contact_no = jTextField5.getText();
        String address = jTextField6.getText();
        String city = jComboBox2.getSelectedItem().toString();
        String department = jComboBox3.getSelectedItem().toString();
        String employee_type = jComboBox4.getSelectedItem().toString();
        String salary = jTextField7.getText();

        if (firstname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NIC Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select Gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (dob1 == null) {
            JOptionPane.showMessageDialog(this, "Please select Date of Birth", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("07[01245678][0-9]{7}").matcher(contact_no).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter Contach Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (city.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select city", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (department.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select Department", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (employee_type.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select Category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Salary", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySQL.search("SELECT `id` FROM `city` WHERE `city`='" + city + "'");
                rs1.next();

                String city_id = rs1.getString("id");

                ResultSet rs2 = MySQL.search("SELECT `id` FROM `gender` WHERE `gender`='" + gender + "'");
                rs2.next();

                String gender_id = rs2.getString("id");

                ResultSet rs3 = MySQL.search("SELECT `id` FROM `department` WHERE `department`='" + department + "'");
                rs3.next();

                String department_id = rs3.getString("id");

                ResultSet rs4 = MySQL.search("SELECT `id` FROM `employee_type` WHERE `type`='" + employee_type + "'");
                rs4.next();

                String employee_id = rs4.getString("id");

                String dob = sdf.format(jDateChooser1.getDate());

                MySQL.iud("INSERT INTO `employee`(`first_name`,`last_name`,`nic`,`gender_id`,`dob`,`contact_no`,`address`,`city_id`,`department_id`,`employee_type_id`,`salary`) VALUES('" + firstname + "','" + lastname + "','" + nic + "'," + Integer.parseInt(gender_id) + ",'" + dob + "','" + contact_no + "','" + address + "'," + Integer.parseInt(city_id) + "," + Integer.parseInt(department_id) + "," + Integer.parseInt(employee_id) + ",'" + salary + "')");

                resetFields();
                loadUsers();

                JOptionPane.showMessageDialog(this, "New Employee Register", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(this, "Please select single Row For Update");

        } else {
            if (jTable2.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {

                String id1 = jTable2.getValueAt(selectedRow, 0).toString();
                String firstname = jTextField1.getText();
                String lastname = jTextField2.getText();
                String nic = jTextField3.getText();
                String gender = jComboBox1.getSelectedItem().toString();
                String dob = jDateChooser1.getDateFormatString();
                String contact_no = jTextField5.getText();
                String address = jTextField6.getText();
                String city = jComboBox2.getSelectedItem().toString();
                String department = jComboBox3.getSelectedItem().toString();
                String employee_type = jComboBox4.getSelectedItem().toString();
                String salary = jTextField7.getText();

                try {

                    ResultSet rs1 = MySQL.search("SELECT `id` FROM `city` WHERE `city`='" + city + "'");
                    rs1.next();

                    String city_id = rs1.getString("id");

                    ResultSet rs2 = MySQL.search("SELECT `id` FROM `gender` WHERE `gender`='" + gender + "'");
                    rs2.next();

                    String gender_id = rs2.getString("id");

                    ResultSet rs3 = MySQL.search("SELECT `id` FROM `department` WHERE `department`='" + department + "'");
                    rs3.next();

                    String department_id = rs3.getString("id");

                    ResultSet rs4 = MySQL.search("SELECT `id` FROM `employee_type` WHERE `type`='" + employee_type + "'");
                    rs4.next();

                    String employee_id = rs4.getString("id");

                    MySQL.iud("UPDATE `employee` SET `first_name`='" + firstname + "',`last_name`='" + lastname + "',`nic`='" + nic + "',`gender_id`='" + Integer.parseInt(gender_id) + "',`dob`='" + dob + "',`contact_no`='" + contact_no + "',`address`='" + address + "',`city_id`='" + Integer.parseInt(city_id) + "',`department_id`='" + Integer.parseInt(department_id) + "',`employee_id`='" + Integer.parseInt(employee_id) + "',`salary`='" + salary + "' WHERE `employee`.`id`= '" + id1 + "' ");

                    resetFields();
                    loadUsers();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                JOptionPane.showMessageDialog(this, "Update Successfully");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tb1model = (DefaultTableModel) jTable2.getModel();

        if (JOptionPane.showConfirmDialog(this, "Do you want to remove the Employee Details?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String del = jTable2.getModel().getValueAt(Row, 0).toString();
            if (jTable2.getSelectedRowCount() == 1) {
                tb1model.removeRow(jTable2.getSelectedRow());

                try {

                    MySQL.iud("DELETE FROM `employee` WHERE id= " + del + ";");

                    resetFields();
                    loadUsers();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (jTable2.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table is Empty ");
                } else {
                    JOptionPane.showMessageDialog(this, "Please Select Single Row For Delete");
                }
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                String firstname = jTable2.getValueAt(selectedRow, 1).toString();
                String lastname = jTable2.getValueAt(selectedRow, 2).toString();
                String nic = jTable2.getValueAt(selectedRow, 3).toString();
                String gender = jTable2.getValueAt(selectedRow, 4).toString();
                String dob = jTable2.getValueAt(selectedRow, 5).toString();
                String contact_no = jTable2.getValueAt(selectedRow, 6).toString();
                String address = jTable2.getValueAt(selectedRow, 7).toString();
                String city = jTable2.getValueAt(selectedRow, 8).toString();
                String department = jTable2.getValueAt(selectedRow, 9).toString();
                String employee = jTable2.getValueAt(selectedRow, 10).toString();
                String salary = jTable2.getValueAt(selectedRow, 11).toString();

                jTextField1.setText(firstname);
                jTextField2.setText(lastname);
                jTextField3.setText(nic);
                jComboBox1.setSelectedItem(gender);
                jDateChooser1.setDateFormatString(dob);
                jTextField5.setText(contact_no);
                jTextField6.setText(address);
                jComboBox2.setSelectedItem(city);
                jComboBox3.setSelectedItem(department);
                jComboBox4.setSelectedItem(employee);
                jTextField7.setText(salary);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyReleased
        // TODO add your handling code here:
        String text = jTextField3.getText();
        loadUsers(text);
    }//GEN-LAST:event_jTextField14KeyReleased

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        //print
        double TOT = 0;

        String FULLTOTAL = String.valueOf(TOT);
        Date d1 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

//            parameters2.put("Parameter1", id);
//            parameters2.put("Parameter2", fn);
//            parameters2.put("Parameter3", ln);
//            parameters2.put("Parameter4", ni);
//            parameters2.put("Parameter5", ge);
//            parameters2.put("Parameter6", birth);
//            parameters2.put("Parameter7", cn);
//            parameters2.put("Parameter8", add);
//            parameters2.put("Parameter9", ci);
//            parameters2.put("Parameter10", dep);
//            parameters2.put("Parameter11", catego);
//            parameters2.put("Parameter12", sa);
        


    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        DashBoard j = new DashBoard();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
