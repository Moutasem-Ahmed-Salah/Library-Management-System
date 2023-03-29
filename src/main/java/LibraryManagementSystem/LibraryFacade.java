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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mo3ta
 */
public class LibraryFacade {

    private Connection con;
    private String user;
    private String BR;
    private int fine;
    private DateConverter dateadapter=new DateAdapter();

    public LibraryFacade(Connection con, String user, String BR, int fine, DateConverter dateadapter) {
        this.con = con;
        this.user = user;
        this.BR = BR;
        this.fine = fine;
        this.dateadapter = dateadapter;
    }

    public void returnBook() {
        try {
            PreparedStatement ps = con.prepareStatement("Update rentals set returndate=?,returned=1 where username=? and bookrented=? and returndate is null");
            

            PreparedStatement ps1 = con.prepareStatement("Select expectedReturndate from rentals where username=? and bookrented=?  and returndate is null",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps1.setString(1, user);
            ps1.setString(2, BR);
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            String date2now = rs1.getString("expectedReturndate");
            LocalDate dateNow = LocalDate.now();
            String date1 = dateadapter.Formatter(dateNow);

            String date2 = dateadapter.convertToLocalDate(date2now);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);

            if (d1.compareTo(d2) > 0) {
                PreparedStatement ps2 = con.prepareStatement("Update users set fines=fines + ? where username=?");
                ps2.setInt(1, fine);
                ps2.setString(2, user);
                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Book is returned late! you will be fined 50$");
            } else if (d2.compareTo(d1) > 0) {
                JOptionPane.showMessageDialog(null, "Book is returned on time");
            }

            ps.setDate(1, dateadapter.convertToSqlDate(LocalDate.now()));
            ps.setString(2, user);
            ps.setString(3, BR);
            ps.executeUpdate();
          

        } catch (ParseException e) {
            // handle the exception here
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
