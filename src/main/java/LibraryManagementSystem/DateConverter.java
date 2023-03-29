/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author mo3ta
 */

public interface DateConverter {
     public java.sql.Date convertToSqlDate(LocalDate currentDate);
    public String convertToLocalDate(String inputDate);
    public String Formatter(LocalDate date);
    
    
}

