/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;


/**
 *
 * @author mo3ta
 */
public class Libb {
   private static Libb instance;
   public  String username;
   public  String Password;
   
   private  Libb(){
   
   }

  
   public static Libb getInstance(){
      if(null==instance){
           instance=new Libb();
       }
       return instance;
   }
}
