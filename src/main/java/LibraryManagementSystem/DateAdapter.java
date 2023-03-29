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
public class DateAdapter implements DateConverter {
//CONVERT FROM LOCAL DATE TO SQLDATE//
    @Override
    public Date convertToSqlDate(LocalDate currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);

        String inputDate = formattedDate;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String outputDate = date.format(outputFormatter);
        return java.sql.Date.valueOf(outputDate);
    }

    //CONVERT SQL DATE TO LOCAL DATE //
    @Override 
    public String convertToLocalDate(String inputdate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inputdate, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String outputDate = date.format(outputFormatter);
        return outputDate;
    }
    
    @Override
    public String Formatter(LocalDate date){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = date.format(formatter);
    return formattedDate;
    }
}
