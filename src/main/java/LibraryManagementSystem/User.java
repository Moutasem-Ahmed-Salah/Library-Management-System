/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author mo3ta
 */
public class User {
    int u_id;
    String Username_u;
    String Password_u;
    String FirstName;
    String LastName;
    
    DBconnect db = new DBconnect();
    Connection con = db.con();
    
    public boolean Login(String username,String password){
         
         try {
             
        String query= "select * from users where username=? and u_pwd=? and deleted=0";
             
                PreparedStatement ps = null;
                ResultSet rs =null;
            
               ps=con.prepareStatement(query);
               ps.setString(1, username);
               ps.setString(2, password);
               
               rs=ps.executeQuery();
               if(rs.next()){
                   
                 JOptionPane.showMessageDialog(null, "Logged In ");
                 
                     new UserMenu(username).setVisible(true);
                     return true;
                     
               }else{
               
                 JOptionPane.showMessageDialog(null, "Invalid username or password");
                return false;
               }
            

            
        } catch (SQLException ex) {
            
           JOptionPane.showMessageDialog(null, ex);
           return false;
        }
    }
    
     
    
}
