// Maryam Abrahams
// ABRMAR043
// 5th March 2025
package src;
import java.util.List;
import java.util.Scanner;

public class GenericsKbArrayApp{
    
    public String[][] knowledgeBase; 

    public GenericsKbArrayApp(){

    }

    public String[][] getArray(){
        return knowledgeBase; 
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
        }
    // Action 2) Updating existing entries by adding different setences & associated confidence scores to an existing term

    public void updateBase(String sentence, String score, int position){

        if (knowledgeBase == null){ 
            System.out.println("Please first load a knowledge base. \n");
            return; 
        }

        knowledgeBase[position][1] = sentence; 
        knowledgeBase[position][2] = score; 
        System.out.println("Statement successfully updated :D !!!");
        return; 

    }

    // Action 3) Search through 2D array for a key term, return the index of the term if true and -1 if false

    public int linearSearchTerm(String target){

            if (knowledgeBase == null){
                return -1; 
            }

            for (int i = 0; i< knowledgeBase.length; i++){
        
                if (knowledgeBase[i][0].equals(target)){
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
            
            if (knowledgeBase[i][0].equals(key) && knowledgeBase[i][1].equals(sentence)){
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

                System.out.println("Welcome to GenericsKb :)");
    
            while (choice != 5) {
    
                System.out.println("""

                        Choose an action from the menu:
                        1. Load a knowledge base from a file
                        2. Update a statement in the knowledge base
                        3. Search for a statement in the knowledge base by term
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
                        
                        System.out.println("Please enter the term you want to update: ");
                        String t = sc.nextLine(); 
                        System.out.println("Please enter the new information you want associated with the term: "); 
                        String s = sc.nextLine(); 
                        System.out.println("Please enter the Confidence Score of your information on a scale from 0.0(impossible) to 1.0(certain): ");
                        String cs = sc.nextLine(); 

                        int i = GKBAA.linearSearchTerm(t);
                        if (i == -1){
                            System.out.println("The term was not found within the database"); 
                            return;
                        }else{
                            GKBAA.updateBase(s, cs, i);
                        }

                        break; 

                    case 3:
                        
                        System.out.println("Enter the term to search: ");
                        String term = sc.nextLine(); 
                        int pos = GKBAA.linearSearchTerm(term);
                        String[][] myArray = GKBAA.getArray(); 

                            if (myArray == null){
                                System.out.println("Please first load a knowledge base. \n");
                                break; 
                            }

                            if (pos != -1){
                                
                                System.out.println("Statement found: " + myArray[pos][1]);
                                System.out.println("Confidence Score: " + myArray[pos][2]);
                                
                            } else {
                                while (pos == -1){
                                    System.out.println("The term was not found within the database, please try again."); 
                                    System.out.println("Enter the term to search: ");
                                    term = sc.nextLine(); 
                                    pos = GKBAA.linearSearchTerm(term); 
                                }
                            }
                        break; 

                    case 4:

                        System.out.println("Enter the term to search: ");
                        String key = sc.nextLine(); 
                        System.out.println("Enter the statement to search for: "); 
                        String sentence = sc.nextLine(); 
                        int posie = GKBAA.keySentencePair(key, sentence);
                        String[][] myArray2 = GKBAA.getArray(); 

                        if (myArray2 == null){
                            System.out.println("Please first load a knowledge base. \n");
                            break; 
                        }

                        if (posie != -1){
        
                            System.out.println("Statement was found and has a Confidence Score of: " + myArray2[posie][2]);
                            
                        } else {
                            while (posie == -1){
                                System.out.println("The term was not found within the database, please try again."); 
                                System.out.println("Enter the term to search: ");
                                key = sc.nextLine(); 
                                System.out.println("Enter the statement to search for: "); 
                                sentence = sc.nextLine(); 
                                posie = GKBAA.keySentencePair(key, sentence);
                            }
                        }
                        break;

                }}
                System.out.print("Thanks for Using GenericsKb :)");
                sc.close(); 
        }
    }