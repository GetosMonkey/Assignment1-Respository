package src;
// Maryam Abrahams
// ABRMAR043
// 5th March 2025

import java.util.List;
import java.util.Scanner;

public class GenericsKbArrayApp{
    
    public String[][] knowledgeBase; 

    public GenericsKbArrayApp(){

    }

    // Action 1) Method to convert my List of String arrays to a regular array for the project

    public void convertToArray(Parsefile path){
    
            List<String[]> list = path.getDatabase(); 
             int rows = list.size(); 
             int cols = 3; 
    
            knowledgeBase = new String[rows][cols]; 

                // populating the matrix
                for (int i = 0; i < rows; i++ ){
                    String[]row = list.get(i);
                    
                    for (int j = 0; j<cols; j++){
                        knowledgeBase[i][j]=row[j]; 
                    }
                }
            //check:
            /*for (String[] row : knowledgeBase) {
                for (String value : row) {
                    System.out.print(value + "\t");
                }
            }*/
        }
    
    

    // Action 3) Search through 2D array for a key term, return the index of the term if true and -1 if false

    public int linearSearchTerm(String target){

            if (knowledgeBase == null){
                return -1; 
            }

            for (int i = 0; i< knowledgeBase.length; i++){
        
                if (knowledgeBase[i][0]==target){
                        return i; 
                    }
            }
            return -1; 
        }

    // Action 4) Search through 2D array for a key term, return the index of the term if true and -1 if false

    public int keySentencePair(String key, String sentence){

        if (knowledgeBase == null){
            return -1; 
        }

        for (int i = 0; i< knowledgeBase.length; i++){
            
            if (knowledgeBase[i][0]== key && knowledgeBase[i][1] == sentence){
                    return i; 
                }  
        }
        return -1; 
    }
    
    public static void main(String[] args){
    
                // Collecting user input and showing output
    
                int choice = 0; 
                Scanner sc = new Scanner(System.in);
                GenericsKbArrayApp GKBAA = new GenericsKbArrayApp(); 
    
            while (choice != 5) {
    
                System.out.println("""
                        Choose an action from the menu:
                        1. Load a knowledge base from a file
                        2. Update a statement in the knowledge base
                        3. Search for a statement tin the knowledge base by term
                        4. Search for a statement in the knowledge base by term and sentence
                        5. Quit
    
                        Enter your choice: 
                        """);
    
                        choice = sc.nextInt();
                        sc.nextLine(); //fixing future sc bugs by consuming trailing \n 
    
                    switch(choice){
                    case 1: // Load knowledge base from a file
    
                        System.out.println("Enter file directory: "); // full file directory recquire (command: realpath filename.txt 
                        String filename = sc.nextLine(); 
                        Parsefile list = new Parsefile(filename); 
                        GKBAA.convertToArray(list); 

                        System.out.println("Knowledge base loaded successfully.\n");

                        break;
                    case 2:
                        
                        System.out.println("That's lowkey above my pay-grade icl...");
                        break; 
                    case 3:
                        break; 
                    case 4:
                        break;

                }}
                sc.close(); 
        }
    }