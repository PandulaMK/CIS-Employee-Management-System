package data;

import business.Login;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LoginDB {

    private ArrayList<Login> logList;
    private File fileObj;

    public LoginDB() {
        logList = new ArrayList<>();
        fileObj = new File("D:/HD67/loginemp.txt");
    }

    public boolean add(Login em) {
        try {
            FileWriter fw = new FileWriter(fileObj, true);
            String line = "\n" + em.getUserID() + "\t" + em.getPassword() + "\n";
            fw.write(line);
            fw.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(String userID) {
    boolean flag = false;
    ArrayList<Login> logList = getAll();
    if (logList != null) {
        for (Login emp : logList) {
            if (emp.getUserID().equals(userID)) {
                logList.remove(emp);
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
        for (Login emp : logList) {
            add(emp);
        }
    } else {
        System.out.println("logList is null"); // Add this debug statement
    }
    return flag;
}



   public ArrayList<Login> getAll() {
        ArrayList<Login> logList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(fileObj);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split("\t");
                String userID = arr[0];
                String password = arr[1];

                Login em = new Login(userID, password);
                logList.add(em);
            }
            return logList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }




    public Login get(String userID) {
    ArrayList<Login> logList = getAll();
    if (logList != null) {
        for (Login emp : logList) {
            if (emp.getUserID().equals(userID)) {
                return emp;
            }
        }
    }
    return null;
}

    public boolean update(Login em) {
        try {
            ArrayList<Login> empList = getAll();
            FileWriter fw = new FileWriter(fileObj);
            fw.write("");
            fw.close();
            for (Login e : empList) {
                if (e.getUserID().equals(em.getUserID())) {
                    empList.remove(e);
                    empList.add(em);
                    break;
                }
            }
            for (Login e : empList) {
                add(e);
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
