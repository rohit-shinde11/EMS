package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername;
    JPasswordField tfpassword; // Use JPasswordField for password input
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JPasswordField(); // Use JPasswordField
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(Login.class.getResource("/icons/second.jpg")); // Correct resource loading
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(1170, 650);
        setLocation(200,50 ); // Center the frame on the screen
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'" ;
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new Home();
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
