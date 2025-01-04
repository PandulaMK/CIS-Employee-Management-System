package data;

import business.Employee;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.sql.Date;
import javax.swing.JOptionPane;

public class EmployeeDB {
    private ArrayList<Employee> employeeList;
    private File fileObj;
    private ArrayList<String> designations;

    public EmployeeDB() {
        employeeList = new ArrayList<>();
        fileObj = new File("D:/HD67/employee.txt");
    }

    public boolean add(Employee emp) {
        try {
            FileWriter fw = new FileWriter(fileObj, true);
            String line = emp.getEmployeeID() + "\t" + emp.getName() + "\t" + emp.getDepartment() + "\t" + emp.getDesignation() + "\t" + emp.getEpfNumber() + "\t" + emp.getDateOfBirth() + "\t" + emp.getJoinDate() + "\t" + emp.getGender() + "\n"; 
            fw.write(line);
            fw.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int employeeID) {
        boolean flag = false;
        ArrayList<Employee> employeeList = getAll();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID() == employeeID) {
                employeeList.remove(emp);
                flag = true;
                break;
            }
        }
        try {
            FileWriter fw = new FileWriter(fileObj);
            fw.write("");
            fw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            flag = false;
        }
        for (Employee emp : employeeList) {
            add(emp);
        }

        return flag;
    }

    public Employee get(int employeeID) {
    ArrayList<Employee> employeeList = getAll();
    if (employeeList != null) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID() == employeeID) {
                return emp;
            }
        }
    }
    return null;
}

    public boolean update(Employee emp) {
        try {
            ArrayList<Employee> empList = getAll();
            FileWriter fw = new FileWriter(fileObj);
            fw.write("");
            fw.close();
            for (Employee e : empList) {
                if (e.getEmployeeID() == emp.getEmployeeID()) {
                    empList.remove(e);
                    empList.add(emp);
                    break;
                }
            }
            for (Employee e : empList) {
                add(e);
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<Employee> getAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(fileObj);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split("\t");
                int employeeID = Integer.valueOf(arr[0]);
                String name = arr[1];
                String department = arr[2];
                String designation = arr[3];
                String epfNumber = arr[4];
                Date dateOfBirth = Date.valueOf(arr[5]);
                Date joinDate = Date.valueOf(arr[6]);
                String gender = arr[7]; // New field for gender
                Employee emp = new Employee(employeeID, name, department, designation, epfNumber, dateOfBirth, joinDate, gender); // Modified to include gender
                employeeList.add(emp);
            }
            return employeeList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }
}
