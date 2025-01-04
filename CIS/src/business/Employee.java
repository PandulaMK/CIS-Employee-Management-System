package business;

import java.sql.Date;

public class Employee {
    private int employeeID;
    private String name;
    private String department;
    private String designation;
    private String epfNumber;
    private Date dateOfBirth;
    private Date joinDate;
    private String gender; // New field

    // Constructor
    public Employee(int employeeID, String name, String department, String designation, String epfNumber, Date dateOfBirth, Date joinDate, String gender) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.epfNumber = epfNumber;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
        this.gender = gender;
    }

    // Getters and setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEpfNumber() {
        return epfNumber;
    }

    public void setEpfNumber(String epfNumber) {
        this.epfNumber = epfNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
