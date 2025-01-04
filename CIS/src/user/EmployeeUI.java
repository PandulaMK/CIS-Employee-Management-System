/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.*;
import business.Employee;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import data.EmployeeDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;




/**
 *
 * @author kariy
 */
public class EmployeeUI extends javax.swing.JFrame {
    private Employee emp;
    private DefaultTableModel tblModel;
    private ArrayList<Employee> employeeList;
    private EmployeeDB empDB;
    private ArrayList<String> departments;
    private ArrayList<String> designations;
    private HashSet<Integer> existingEmployeeIDs;

    /**
     * Creates new form EmployeeUI
     */
    public EmployeeUI() {
        initComponents();
        setLocationRelativeTo(this);
        tblModel=new DefaultTableModel();
        tblEmployee.setModel(tblModel);
        tblModel.addColumn("Employee ID");
        tblModel.addColumn("Name");
        tblModel.addColumn("Department");
        tblModel.addColumn("Designation");
        tblModel.addColumn("EPF Number");
        tblModel.addColumn("Date of Birth");
        tblModel.addColumn("Join Date");
        tblModel.addColumn("Gender");
        
        // Load departments and designations from files
        loadDepartmentsFromFile();
        loadDesignationsFromFile();
        
        // Add loaded departments and designations to combo boxes
        for (String department : departments) {
            cmbDepartment.addItem(department);
        }
        for (String designation : designations) {
            cmbDesignation.addItem(designation);
        }

        employeeList=new ArrayList<>();
        empDB=new EmployeeDB();
        
        existingEmployeeIDs = new HashSet<>();
        
        for (Employee emp : empDB.getAll()) {
            existingEmployeeIDs.add(emp.getEmployeeID());
        }
        
        btnAddDesignation = new javax.swing.JButton();
        btnAddDesignation.setText("Add Designation");
        
        btnAddDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDesignationActionPerformed(evt);
            }
        });
        
    
        
        btnAddDepartment = new javax.swing.JButton();
        btnAddDepartment.setText("Add Department");
        
        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });
       
        
       

    
   }
    private void loadDepartmentsFromFile() {
        departments = new ArrayList<>();
        File departmentFile = new File("D:/HD67/departments.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(departmentFile));
            String line;
            while ((line = reader.readLine()) != null) {
                departments.add(line);
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading departments from file: " + e.getMessage());
        }
    }

    private void loadDesignationsFromFile() {
        designations = new ArrayList<>();
        File designationFile = new File("D:/HD67/designations.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(designationFile));
            String line;
            while ((line = reader.readLine()) != null) {
                designations.add(line);
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading designations from file: " + e.getMessage());
        }
    }
    
    private void writeDepartmentsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/HD67/departments.txt"));
            for (String department : departments) {
                writer.write(department);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing departments to file: " + e.getMessage());
        }
    }

    private void writeDesignationsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/HD67/designations.txt"));
            for (String designation : designations) {
                writer.write(designation);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing designations to file: " + e.getMessage());
        }
    }

    
    private boolean checkVal(){
        if(txtEmployeeId.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Employee ID cannot be blank");
            return false;
        }
        
        if(txtName.getText().equals("")){
             JOptionPane.showMessageDialog(this, "Name cannot be blank");
             return false;
        }
        
        
        if(txtDateOfBirth.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Date of Birth cannot be blank");
             return false;
        }

        if(txtJoinDate.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Join Date cannot be blank");
             return false;
        }
        
        return true;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEmployee = new javax.swing.JPanel();
        lblEmployeeID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblDesignation = new javax.swing.JLabel();
        lblEPFNumber = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        lblJoinDate = new javax.swing.JLabel();
        txtEmployeeId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEPFNumber = new javax.swing.JTextField();
        txtJoinDate = new javax.swing.JTextField();
        txtDateOfBirth = new javax.swing.JTextField();
        cmbDepartment = new javax.swing.JComboBox();
        cmbDesignation = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblGender = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        btnAddDesignation = new javax.swing.JButton();
        btnAddDepartment = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSearchByEmployeeID = new javax.swing.JButton();
        btnSearchByDesignation = new javax.swing.JButton();
        btnSearchByDepartment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelEmployee.setBackground(java.awt.Color.lightGray);

        lblEmployeeID.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblEmployeeID.setForeground(java.awt.Color.darkGray);
        lblEmployeeID.setText("Employee ID");

        lblName.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblName.setForeground(java.awt.Color.darkGray);
        lblName.setText("Name");

        lblDepartment.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblDepartment.setForeground(java.awt.Color.darkGray);
        lblDepartment.setText("Department");

        lblDesignation.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblDesignation.setForeground(java.awt.Color.darkGray);
        lblDesignation.setText("Designation");

        lblEPFNumber.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblEPFNumber.setForeground(java.awt.Color.darkGray);
        lblEPFNumber.setText("EPF Number");

        lblDateOfBirth.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblDateOfBirth.setForeground(java.awt.Color.darkGray);
        lblDateOfBirth.setText("Date Of Birth");

        lblJoinDate.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblJoinDate.setForeground(java.awt.Color.darkGray);
        lblJoinDate.setText("Joined Date");

        txtEmployeeId.setBackground(new java.awt.Color(184, 198, 208));
        txtEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeIdActionPerformed(evt);
            }
        });

        txtName.setBackground(new java.awt.Color(184, 198, 208));

        txtEPFNumber.setBackground(new java.awt.Color(184, 198, 208));
        txtEPFNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEPFNumberActionPerformed(evt);
            }
        });

        txtJoinDate.setBackground(new java.awt.Color(184, 198, 208));
        txtJoinDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJoinDateActionPerformed(evt);
            }
        });

        txtDateOfBirth.setBackground(new java.awt.Color(184, 198, 208));

        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Academic", "Administrative", "Library", "IT", "Student Support" }));

        cmbDesignation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "President", "Dean", "Manager", "Coordinator", "Professor", "Assistant Professor", "Lecturer", "Visiting Lecturer", "Security", "Service Staff" }));

        btnAdd.setBackground(new java.awt.Color(0, 0, 102));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 0, 102));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnDisplay.setBackground(new java.awt.Color(0, 0, 102));
        btnDisplay.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDisplay.setForeground(new java.awt.Color(255, 255, 255));
        btnDisplay.setText("Display");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        btnFind.setBackground(new java.awt.Color(0, 0, 102));
        btnFind.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(0, 0, 102));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblGender.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 15)); // NOI18N
        lblGender.setForeground(java.awt.Color.darkGray);
        lblGender.setText("Gender");

        rdoMale.setBackground(java.awt.Color.lightGray);
        rdoMale.setText("Male");
        rdoMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaleActionPerformed(evt);
            }
        });

        rdoFemale.setBackground(java.awt.Color.lightGray);
        rdoFemale.setText("Female");
        rdoFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleActionPerformed(evt);
            }
        });

        btnAddDesignation.setBackground(new java.awt.Color(102, 0, 102));
        btnAddDesignation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAddDesignation.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDesignation.setText("Add Designation");
        btnAddDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDesignationActionPerformed(evt);
            }
        });

        btnAddDepartment.setBackground(new java.awt.Color(102, 0, 102));
        btnAddDepartment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAddDepartment.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDepartment.setText("Add Department");
        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Employee Details");

        javax.swing.GroupLayout panelEmployeeLayout = new javax.swing.GroupLayout(panelEmployee);
        panelEmployee.setLayout(panelEmployeeLayout);
        panelEmployeeLayout.setHorizontalGroup(
            panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panelEmployeeLayout.createSequentialGroup()
                        .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDepartment)
                            .addComponent(lblName)
                            .addComponent(lblEmployeeID)
                            .addComponent(lblDesignation)
                            .addComponent(lblEPFNumber)
                            .addComponent(lblDateOfBirth)
                            .addComponent(lblJoinDate))
                        .addGap(86, 86, 86)
                        .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEPFNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rdoFemale)
                                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmployeeId)
                                    .addComponent(txtName)
                                    .addComponent(cmbDesignation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDateOfBirth)
                                    .addComponent(txtJoinDate)))))
                    .addGroup(panelEmployeeLayout.createSequentialGroup()
                        .addComponent(lblGender)
                        .addGap(118, 118, 118)
                        .addComponent(rdoMale))
                    .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelEmployeeLayout.createSequentialGroup()
                            .addComponent(btnAddDesignation)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddDepartment))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEmployeeLayout.createSequentialGroup()
                            .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd)
                                .addComponent(btnFind))
                            .addGap(47, 47, 47)
                            .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnUpdate)
                                .addComponent(btnDelete))
                            .addGap(44, 44, 44)
                            .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDisplay)
                                .addComponent(btnClose)))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        panelEmployeeLayout.setVerticalGroup(
            panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeID)
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartment)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesignation)
                    .addComponent(cmbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEPFNumber)
                    .addComponent(txtEPFNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateOfBirth))
                .addGap(34, 34, 34)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJoinDate)
                    .addComponent(txtJoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addGap(18, 18, 18)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnDisplay))
                .addGap(30, 30, 30)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFind)
                    .addComponent(btnUpdate)
                    .addComponent(btnClose))
                .addGap(18, 18, 18)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDesignation)
                    .addComponent(btnAddDepartment))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnSearchByEmployeeID.setBackground(new java.awt.Color(153, 0, 0));
        btnSearchByEmployeeID.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearchByEmployeeID.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchByEmployeeID.setText("Search By EmployeeID");
        btnSearchByEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByEmployeeIDActionPerformed(evt);
            }
        });

        btnSearchByDesignation.setBackground(new java.awt.Color(153, 0, 0));
        btnSearchByDesignation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearchByDesignation.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchByDesignation.setText("Search By Designation");
        btnSearchByDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByDesignationActionPerformed(evt);
            }
        });

        btnSearchByDepartment.setBackground(new java.awt.Color(153, 0, 0));
        btnSearchByDepartment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearchByDepartment.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchByDepartment.setText("Search By Department");
        btnSearchByDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByDepartmentActionPerformed(evt);
            }
        });

        tblEmployee.setBackground(new java.awt.Color(204, 204, 255));
        tblEmployee.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Department", "Designation", "EPF Number", "Date of Birth", "Join Date", "Gender"
            }
        ));
        jScrollPane1.setViewportView(tblEmployee);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(btnSearchByEmployeeID)
                .addGap(100, 100, 100)
                .addComponent(btnSearchByDesignation)
                .addGap(99, 99, 99)
                .addComponent(btnSearchByDepartment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchByDepartment)
                    .addComponent(btnSearchByDesignation)
                    .addComponent(btnSearchByEmployeeID))
                .addContainerGap(385, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJoinDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJoinDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJoinDateActionPerformed

    private void txtEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeIdActionPerformed

    private void txtEPFNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEPFNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEPFNumberActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed
    
    
    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        int employeeID=Integer.valueOf(JOptionPane.showInputDialog("Enter Employee ID"));
        Employee emp=empDB.get(employeeID);
        if(emp!=null){            
            txtEmployeeId.setText(String.valueOf(emp.getEmployeeID()));
            txtName.setText(emp.getName());
            cmbDepartment.setSelectedItem(emp.getDepartment());
            cmbDesignation.setSelectedItem(emp.getDesignation());
            txtEPFNumber.setText(emp.getEpfNumber());
            txtDateOfBirth.setText(String.valueOf(emp.getDateOfBirth()));
            txtJoinDate.setText(String.valueOf(emp.getJoinDate()));
            if(emp.getGender().equals("Male")){
                    rdoMale.setSelected(true);
                }else if((emp.getGender().equals("Female"))){
                    rdoFemale.setSelected(true);
                    rdoMale.setSelected(false);
                }else{
                    rdoMale.setSelected(false);
                    rdoFemale.setSelected(false);
                }
    }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        // TODO add your handling code here:
         tblModel.setRowCount(0);
    employeeList = empDB.getAll();
    if (employeeList != null) { // Check if employeeList is not null
        for (Employee emp : employeeList) {
            int employeeID = emp.getEmployeeID();
            String name = emp.getName();
            String department = emp.getDepartment();
            String designation = emp.getDesignation();
            String epfNumber = emp.getEpfNumber();
            Date dateOfBirth = emp.getDateOfBirth();
            Date joinDate = emp.getJoinDate();
            String gender = emp.getGender();
            tblModel.addRow(new Object[]{employeeID, name, department, designation, epfNumber, dateOfBirth, joinDate, gender});
        }
    } else {
        JOptionPane.showMessageDialog(this, "No records found!");
    }

    }//GEN-LAST:event_btnDisplayActionPerformed
    
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (checkVal()) {
            int employeeId = Integer.valueOf(txtEmployeeId.getText());
            if (existingEmployeeIDs.contains(employeeId)) {
                JOptionPane.showMessageDialog(this, "Employee ID already exists! Please enter a unique Employee ID.");
                return;
            }
            
            // If EmployeeID is unique, proceed with adding the employee
            String name = txtName.getText();
            String department = cmbDepartment.getSelectedItem().toString();
            String designation = cmbDesignation.getSelectedItem().toString();
            String epfNumber = txtEPFNumber.getText();
            Date dateOfBirth = null;
            Date joinDate = null;
            try {
                dateOfBirth = Date.valueOf(txtDateOfBirth.getText()); // Parse date string to Date object
                joinDate = Date.valueOf(txtJoinDate.getText()); // Parse date string to Date object
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(panelEmployee, "Invalid date format! Please enter date in yyyy-MM-dd format.");
                return;
            }
            String gender = "";
            if (rdoMale.isSelected()) {
                gender = "Male";
            } else if (rdoFemale.isSelected()) {
                gender = "Female";
            } else {
                gender = "Other";
            }
            emp = new Employee(employeeId, name, department, designation, epfNumber, dateOfBirth, joinDate, gender);
            if (empDB.add(emp)) {
                existingEmployeeIDs.add(employeeId); // Add the new EmployeeID to the set of existing IDs
                JOptionPane.showMessageDialog(panelEmployee, "The record is added");
            } else {
                JOptionPane.showMessageDialog(panelEmployee, "The record is not added");
            }
        }
     

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int employeeID=Integer.valueOf(JOptionPane.showInputDialog("Enter Employee ID"));
        empDB.delete(employeeID);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(checkVal()){
            int employeeId=Integer.valueOf(txtEmployeeId.getText());
            String name=txtName.getText();
            String department=cmbDepartment.getSelectedItem().toString();
            String designation=cmbDesignation.getSelectedItem().toString();
            String epfNumber=txtEPFNumber.getText();
            Date dateOfBirth=Date.valueOf(txtDateOfBirth.getText());
            Date joinDate=Date.valueOf(txtJoinDate.getText());
            String gender="";
            if(rdoMale.isSelected()){
                gender="Male";
            }else if(rdoFemale.isSelected()){
                gender="Female";
            }else{
                gender="other";
            }
            emp=new Employee(employeeId, name, department, designation, epfNumber, dateOfBirth, joinDate, gender);
            if(empDB.update(emp)){
                JOptionPane.showMessageDialog(panelEmployee, "Employee is updated");
            }else{
                JOptionPane.showMessageDialog(panelEmployee, "Employee is not updated");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void rdoMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaleActionPerformed
        // TODO add your handling code here:
        if (rdoMale.isSelected()) {
        rdoFemale.setSelected(false);
    }
    }//GEN-LAST:event_rdoMaleActionPerformed

    private void rdoFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleActionPerformed
        // TODO add your handling code here:
        if (rdoFemale.isSelected()) {
        rdoMale.setSelected(false);
    }
    }//GEN-LAST:event_rdoFemaleActionPerformed
    
    private void btnAddDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDesignationActionPerformed
        // TODO add your handling code here:
        String newDesignation = JOptionPane.showInputDialog("Enter the new designation:");
        if (newDesignation != null && !newDesignation.isEmpty()) {
            designations.add(newDesignation);
            writeDesignationsToFile(); // Write updated designations to file
            cmbDesignation.addItem(newDesignation);
            JOptionPane.showMessageDialog(this, "New designation added successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid designation. Please try again.");
        }
    
    }//GEN-LAST:event_btnAddDesignationActionPerformed

    private void btnAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepartmentActionPerformed
        // TODO add your handling code here:
        String newDepartment = JOptionPane.showInputDialog("Enter the new department:");
        if (newDepartment != null && !newDepartment.isEmpty()) {
            departments.add(newDepartment);
            writeDepartmentsToFile(); // Write updated departments to file
            cmbDepartment.addItem(newDepartment);
            JOptionPane.showMessageDialog(this, "New department added successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid department. Please try again.");
        }
    
    }//GEN-LAST:event_btnAddDepartmentActionPerformed

    private void btnSearchByEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByEmployeeIDActionPerformed
        // TODO add your handling code here:
        int employeeID = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID"));
        Employee emp = empDB.get(employeeID);
        if (emp != null) {
            tblModel.setRowCount(0);
            int empID = emp.getEmployeeID();
            String name = emp.getName();
            String department = emp.getDepartment();
            String designation = emp.getDesignation();
            String epfNumber = emp.getEpfNumber();
            Date dateOfBirth = emp.getDateOfBirth();
            Date joinDate = emp.getJoinDate();
            String gender = emp.getGender();
            tblModel.addRow(new Object[]{empID, name, department, designation, dateOfBirth, joinDate, gender});
        } else {
            JOptionPane.showMessageDialog(this, "Employee with ID " + employeeID + " not found!");
        }
    }//GEN-LAST:event_btnSearchByEmployeeIDActionPerformed

    private void btnSearchByDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByDesignationActionPerformed
        // TODO add your handling code here:
        String designation = JOptionPane.showInputDialog("Enter Designation");
    tblModel.setRowCount(0);
    employeeList = empDB.getAll();
    boolean found = false;
    if (employeeList != null) {
        for (Employee emp : employeeList) {
            if (emp.getDesignation().equals(designation)) {
                found = true;
                int employeeID = emp.getEmployeeID();
                String name = emp.getName();
                String department = emp.getDepartment();
                String empDesignation = emp.getDesignation();
                String epfNumber = emp.getEpfNumber();
                Date dateOfBirth = emp.getDateOfBirth();
                Date joinDate = emp.getJoinDate();
                String gender = emp.getGender();
                tblModel.addRow(new Object[]{employeeID, name, department, empDesignation, dateOfBirth, joinDate, gender});
            }
        }
    }
    if (!found) {
        JOptionPane.showMessageDialog(this, "No records found!");
    }
    }//GEN-LAST:event_btnSearchByDesignationActionPerformed

    private void btnSearchByDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByDepartmentActionPerformed
        // TODO add your handling code here:
        String department = JOptionPane.showInputDialog("Enter Department");
    tblModel.setRowCount(0);
    employeeList = empDB.getAll();
    boolean found = false;
    if (employeeList != null) {
        for (Employee emp : employeeList) {
            if (emp.getDepartment().equals(department)) {
                found = true;
                int employeeID = emp.getEmployeeID();
                String name = emp.getName();
                String empDepartment = emp.getDepartment();
                String designation = emp.getDesignation();
                String epfNumber = emp.getEpfNumber();
                Date dateOfBirth = emp.getDateOfBirth();
                Date joinDate = emp.getJoinDate();
                String gender = emp.getGender();
                tblModel.addRow(new Object[]{employeeID, name, empDepartment, designation, dateOfBirth, joinDate, gender});
            }
        }
    }
    if (!found) {
        JOptionPane.showMessageDialog(this, "No records found!");
    }
    }//GEN-LAST:event_btnSearchByDepartmentActionPerformed
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddDepartment;
    private javax.swing.JButton btnAddDesignation;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSearchByDepartment;
    private javax.swing.JButton btnSearchByDesignation;
    private javax.swing.JButton btnSearchByEmployeeID;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbDepartment;
    private javax.swing.JComboBox cmbDesignation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblDesignation;
    private javax.swing.JLabel lblEPFNumber;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblJoinDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel panelEmployee;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtEPFNumber;
    private javax.swing.JTextField txtEmployeeId;
    private javax.swing.JTextField txtJoinDate;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
