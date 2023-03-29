/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

/**
 *
 * @author mo3ta
 */
public abstract class  Book {
 
    int bookID;
    String booktitle;
    int racknumber;
  
    String categ;
    String author;
    boolean avaliability=true;
   

    public Book(int bookID, String booktitle, int racknumber,  String author) {
        this.bookID = bookID;
        this.booktitle = booktitle;
        this.racknumber = racknumber;
        this.author = author;
        
    }
    

    
  
    
    
    
     public abstract void SetBookcateg();
       
}
