// Maryam Abrahams
// ABRMAR043
// 5th March 2025

import java.util.List;
import java.util.Scanner;

import src.Parsefile;

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
            for (String[] row : knowledgeBase) {
                for (String value : row) {
                    System.out.print(value + "\t");
                }
            System.out.println();}

    
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
                        2. Add a new statement to the knowledge base
                        3. Search for a statement tin the knowledge base by term
                        4. Search for a statement in the knowledge base by term and sentence
                        5. Quit
    
                        Enter your choice: 
                        """);
    
                        choice = sc.nextInt(); 
    
                    switch(choice){
                        case 1: // Load knowledge base from a file
    
                            System.out.println("Enter file directory: "); // full file directory recquire (command: realpath filename.txt 
                            String filename = sc.nextLine(); 
                            Parsefile list = new Parsefile(filename); 
                            GKBAA.convertToArray(list); 

                        System.out.println("Knowledge base loaded successfully.");

                        break;
                    case 2:
                        break; 
                    case 3:
                        break; 
                    case 4:
                        break;

                }}
                sc.close(); 
        }
    }