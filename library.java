/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Ard Al Jood
 */
import java.util.Scanner;
public class library {
    public static void main(String [] args){
Scanner input = new Scanner(System.in);
        int ans;
        int i;
        int size;
        int ID;
        String borrow ;
        String returnbook ;
        String add;
        String search;
        String flag;

        System.out.println("Welcome to our library");
        System.out.println("Enter library capacity of books(only numbers accepted)");
        size = input.nextInt();
        String[] name = new String[size] ;
        String[] notes = new String[size] ;
        String[] bookIssued = new String[size] ;
       
       for (i = 0 ; i < size ; i++ ) {
                bookIssued[i] = "This book is currently unavailable" ;
            }
        flag="yes";
        while("yes".equals(flag)){
            System.out.println("Please choose one of our services(only numbers accepted)");
            System.out.println("1-Add book");
            System.out.println("2-Search for a book by ID");
            System.out.println("3-Issue a book by ID");
            System.out.println("4-Return a book by ID");
            System.out.println("5-Delete a book");
            System.out.println("6-View all books");
            System.out.println("7-Edit book details");
            System.out.println("8-Exit the app");
            ans = input.nextInt();
            
            

            if(ans==1) {
                add = "yes";
                for(i = 0; i < size;){
                    while(add.equalsIgnoreCase("yes")){

                        input.nextLine();  
                        System.out.println("Enter the The book number " +(i + 1) + " name");
                        name[i] = input.nextLine();
                        System.out.println("Enter the The book number " + (i + 1) + " description");
                        notes[i] = input.nextLine();
                        System.out.println("The ID of the book is  " + (i + 1) );
                        
                        System.out.println("The book has been added");
                        bookIssued[i] = "This book is currently available";
                        i++;
                        if ( i == size ) {
                                System.out.println("The library is now full ");
                                break ; 
                            }
                        System.out.println("Do you want to add another book ???");
                        add = input.next();  

                    } 
                    if (add.equalsIgnoreCase("no")) {
                        System.out.println("You can't add more books now");
                        break ; 
                        
                    }
                }
                

                

            } else if(ans==2){
                search = "yes";
                while(search.equalsIgnoreCase("yes")){
                    System.out.println("Enter the ID of the book");
                    ID = input.nextInt();
                    input.nextLine();
                    for(i = 0; i < name.length ; i++){
                        
                        if (ID > size) {
                            System.out.println("Invalid ID");
                            break ;
                        } 
                        else if (ID < 0 ) {
                            System.out.println("Invalid ID");
                            break ;
                        } 
                        else if (name[ID - 1] == null && notes[ID - 1] == null) {
                            System.out.println("There is no book with this id");
                            break ; 
                        }
                        else {
                            System.out.println("The book name is " + name[ID - 1]);
                            System.out.println("The book description is " + notes[ID - 1]);
                            System.out.println("The book status is : " + bookIssued[ID - 1]);
                            break ; 
                        }
                            
                    }
                    System.out.println("Do you want to search for another book ?? ");
                    search = input.next();
                }
                
                
            } else if (ans==3) {   
                borrow = "yes" ; 
                while (borrow.equalsIgnoreCase("yes")) {
                    System.out.println("To borrow a book enter the book ID : ");
                    ID = input.nextInt() ;
                    for ( i = 0 ; i < size ; i++) {
                        if (ID > size) {
                            System.out.println("Invalid ID");
                            break ;
                        } 
                        else if (ID <= 0 ) {
                            System.out.println("Invalid ID");
                            break ;
                        }
                        else {
                            
                            if(bookIssued[ID - 1].equals("This book is currently unavailable")){
                                System.out.println("This book is currently unavailable sorry");
                                break;
                            }
                            else{
                                if(name[ID-1]==null){
                                    System.out.println("You havn't add a book here yet");
                                    break;
                                }
                                else{
                                    System.out.println(name[ID - 1]);
                                    System.out.println(notes[ID - 1]);
                                    System.out.println("You borrowed the book successfully");
                                    bookIssued[ID - 1] = "This book is currently unavailable" ;  // Marking the book as unavailable 
                                    break ;  
                                }
                            }
                        }
                    }
                    System.out.println("Do you want to borrow another book ??? ");
                    borrow = input.next() ; 
                }
            }
            else if (ans==4) {
                returnbook = "yes" ;
                while (returnbook.equalsIgnoreCase("yes")) {
                    System.out.println("To return a book enter its ID : ");
                    ID = input.nextInt() ;
                    for (i = 0 ; i < size ; i++) {
                         if (ID > size) {
                            System.out.println("Invalid ID");
                            break ;
                        } 
                        else if (ID <= 0 ) {
                            System.out.println("Invalid ID");
                            break ;
                        }
                        else {
                            if("This book is currently available".equals(bookIssued[ID - 1])){
                                System.out.println("The book is already here");
                                break;
                            }else if(name[ID-1] !=null){
                                System.out.println(name[ID - 1]);
                            System.out.println(notes[ID - 1]);
                            System.out.println("You returned the book successfully");
                            bookIssued[ID - 1] = "This book is currently available" ;      
                            break;
                                
                            }else if(name[ID-1]==null){
                                System.out.println("there is no book here");
                                break;
                            
                        }
                        }
                    }
                    System.out.println("Do you want to return another book ?? ");
                    returnbook = input.next() ;
                }
            }
            
            else if (ans==5){
               String delete = "yes";
                while ("yes".equalsIgnoreCase(delete)) {
                    System.out.println("Enter the ID of the book to delete: ");
                    ID = input.nextInt();
                    if (ID <= 0 || ID > size) {
                        System.out.println("Invalid ID");
                    } else {
                        if("This book is currently unavailable".equals(bookIssued[ID-1])){
                            System.out.println("there is no book here");
                        }else{
                        for ( i = 0; i < size; i++) {
                           if((ID-1)==0){
                               name[ID-1] =null;
                               notes[ID-1]=null;
                               bookIssued[ID-1]="This book is currently unavailable";
                               break;
                           }
                        }
                        System.out.println("Book deleted successfully");
                    }
                    
                    input.nextLine();
                    System.out.println("Do you want to delete another book? ");
                    delete = input.next();
                    } 
                }
                }
            else if (ans==7) {
                 String edit = "yes";
                 while ("yes".equalsIgnoreCase(edit)) {
                System.out.println("Enter the ID of the book to edit: ");
                ID = input.nextInt();
                input.nextLine();
                if (ID <= 0 || ID > size) {
                    System.out.println("Invalid ID");
                } else {
                    if("This book is currently unavailable".equals(bookIssued[ID-1])){
                            System.out.println("Sorry , this book is currnetly unavailable , so you can not edit it right now");
                    }
                    
                    else{
                        System.out.println("Do you want to edit the book name or description? (name/description)");
                        String Choice = input.nextLine();
                        
                        if ("name".equalsIgnoreCase(Choice)) {
                            System.out.println("Enter the new name: ");
                            name[ID - 1] = input.nextLine();
                            System.out.println("Book name updated successfully");
                        } 
                        else if ("description".equalsIgnoreCase(Choice)) {
                            System.out.println("Enter the new description: ");
                            notes[ID - 1] = input.nextLine();
                            System.out.println("Book description updated successfully");
                        } 
                        else {
                            System.out.println("Invalid choice");
                        }
                        
                    }
                    System.out.println("Do you want to edit another book ?");
                        edit = input.nextLine();
                }
            }
                         
        } else if (ans==6){
                for ( i = 0; i < size; i++) {
                    if(name[i] !=null){
                        System.out.println("ID: " + (i + 1));
                        System.out.println("Name: " + name[i]);
                        System.out.println("Description: " + notes[i]);
                        System.out.println("Status: " + bookIssued[i]);
                    
                    }else{
                        System.out.println("there is no books");
                        break;
                              
                    }
                    
            }
           
        }
            else if (ans == 8){
                System.out.println("Thanks for using our app");
                System.out.println("have a nice day ");
                break;
            } 
            else {
                System.out.println("Invalid choice");
            }
            
        System.out.println("Do you want another service ?? ");
             flag=input.next(); 
             if (flag.equalsIgnoreCase("no")){
                    System.out.println("Thanks for using our app");
                    System.out.println ("have a nice day ");
             }
    
        }
    }
}
