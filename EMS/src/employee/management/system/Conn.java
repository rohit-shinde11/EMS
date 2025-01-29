package employee.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;    
    Statement s;
        
    public Conn (){
        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to the MySQL database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "Vijay$1003");
            
            // Create a statement object
            s = c.createStatement();   
        } catch(Exception e) {
            // Handle exceptions gracefully
            e.printStackTrace();
        }
    }
}

