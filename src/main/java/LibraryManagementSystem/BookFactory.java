/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

/**
 *
 * @author mo3ta
 */
public class BookFactory    {
  public Book getbook(String categ){
      if(categ==null){
          return null;
      }
       if(categ.equalsIgnoreCase("COOKING"))
           
       {return new Cooking(2,"ahmed",4,"2");}
      else if(categ.equalsIgnoreCase("SCIENTIFIC"))
      { return new Scientific(3,"mohamed",7,"2");}
        else if(categ.equalsIgnoreCase("FANTASY"))
      { return new Fantasy(3,"mohamed",7,"2");}
        else if(categ.equalsIgnoreCase("BIOGRAPHY"))
      { return new Biography(3,"mohamed",7,"2");}
      
       return null;
  }
}
