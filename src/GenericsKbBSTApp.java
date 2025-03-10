package src;

import java.util.List;
import java.util.Scanner;

public class GenericsKbBSTApp{
    

    public GenericsKbBSTApp(){

    }


    public static void main(String[] args){
    
                // Collecting user input and showing output
    
                int choice = 0; 
                Scanner sc = new Scanner(System.in);
    
            while (choice != 5) {
                
                //updates if the confidence score is higher than an existing one 
                System.out.println("""
                        Choose an action from the menu:
                        1. Load a knowledge base from a file
                        2. Add a statement to the knowledge base
                        3. Update a staement in the knowledge base 
                        3. Search for a statement in the knowledge base by term
                        4. Search for a statement in the knowledge base by term and sentence
                        5. Quit
    
                        Enter your choice: 
                        """);
    
                        choice = sc.nextInt();
                        sc.nextLine(); //fixing future sc bugs by consuming trailing \n 
    
                    switch(choice){
                    case 1:
                        break;

                    case 2:
                        break; 

                    case 3:
                        break; 

                    case 4:
                        break;

                }}
                System.out.print("Thanks for Using GenericsKb :)");
                sc.close(); 
        }
}