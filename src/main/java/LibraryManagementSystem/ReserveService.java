/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author grgis
 */
public class ReserveService {
        DateAdapter dateAdapter = new DateAdapter();
    DBconnect db = new DBconnect();
    Connection con = db.con();
        RentService rentService = new RentService();

    
    
    
    
   public void rentBookWhenAvailable(String title, String username) {
    boolean availability = false;
      try {
    while (!availability) {
        // Use a SELECT statement to retrieve the availability status of the book
        PreparedStatement ps = con.prepareStatement("select Availability from books where title=?");
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        rs.next();
        availability = rs.getBoolean("Availability");

        // If the book is available, rent it
        if (availability) {
            rentService.RentBook(title, username);
            JOptionPane.showMessageDialog(null, "Book is reserved your book will be rented automatically once it is available");

        }
    
    }
}
       catch (SQLException ex) {
            Logger.getLogger(RentBooks.class.getName()).log(Level.SEVERE, null, ex);
            
        }
   }
}
