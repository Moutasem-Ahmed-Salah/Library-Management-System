/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

/**
 *
 * @author HP
 */
public class Scientific extends Book{

    public Scientific(int bookID, String booktitle, int racknumber, String author) {
        super(bookID, booktitle, racknumber, author);
    }

    
    @Override
    public void SetBookcateg(){
      this.categ="Scientific";
    }
    
}