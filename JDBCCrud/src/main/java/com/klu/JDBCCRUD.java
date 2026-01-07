package com.klu;

import java.sql.*;

public class JDBCCRUD {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "Vidya@2807";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("MySQL Server Connected");

            Statement st = con.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS fsads3");
            System.out.println("Database created / already exists");
            st.execute("USE fsads3");
            String createDept =
                    "CREATE TABLE IF NOT EXISTS dept (" +
                    "dept_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "dept_name VARCHAR(20)" +
                    ")";
            st.execute(createDept);
            System.out.println("Department table created");

            // Create Employee Table
            String createEmp =
                    "CREATE TABLE IF NOT EXISTS emp (" +
                    "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "emp_name VARCHAR(50), " +
                    "sal DOUBLE, " +
                    "dept_id INT, " +
                    "FOREIGN KEY (dept_id) REFERENCES dept(dept_id)" +
                    ")";
            st.execute(createEmp);
            System.out.println("Employee table created");
            st.executeUpdate("INSERT INTO dept (dept_name) VALUES ('CSE')");
            System.out.println("Inserted into dept");

            st.executeUpdate(
                    "INSERT INTO emp (emp_name, sal, dept_id) VALUES ('Deepa', 25000, 1)"
            );
            System.out.println("Inserted into emp");

           

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
