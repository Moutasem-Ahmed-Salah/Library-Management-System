/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author mo3ta
 */
public class RentService {

    DateConverter dateAdapter = new DateAdapter();
    DBconnect db = new DBconnect();
    Connection con = db.con();
    LocalDate currentDate = LocalDate.now();
    LocalDate skippedDate = currentDate.plusDays(10);

    public boolean RentBook(String title, String username) {
        try {

            PreparedStatement ps3 = con.prepareStatement("select count(*) from rentals where username=? and returndate is null");
            ps3.setString(1,username);
            ResultSet rs1 = ps3.executeQuery();
            rs1.next();
            int noOfBooks = rs1.getInt(1);
            if (noOfBooks == 5) {
                return false;

            } else {
                PreparedStatement ps1 = con.prepareStatement("insert into rentals(bookrented,username,rentdate,expectedReturndate)values(?,?,?,?)");
                PreparedStatement ps2 = con.prepareStatement("Update books set Availability=? where title=?");
                ps1.setString(1, title);
                ps1.setString(2, username);
                ps1.setDate(3, dateAdapter.convertToSqlDate(LocalDate.now()));
                ps1.setDate(4,dateAdapter.convertToSqlDate(skippedDate));
                ps2.setString(1, "false");
                ps2.setString(2, title);
                ps1.executeUpdate();

                ps2.executeUpdate();
            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(RentBooks.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
