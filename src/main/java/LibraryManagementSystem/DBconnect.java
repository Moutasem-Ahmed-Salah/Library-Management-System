/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
     private final String userName = "root";
    private final String password = "AhmedMoutasem_1";
    private final String dbName = "lbms";
    private Connection con;

    public DBconnect() {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
            
        }
      
    }
    public Connection con(){
        return con;
    }
}
