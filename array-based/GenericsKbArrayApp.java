import java.util.Scanner;

public class GenericsKbArrayApp{
    
    public String[][] knowledgeBase; 

    public GenericsKbArrayApp(){

    }


    public static void main(String[] args){

            // Collecting user input and showing output

            int choice = 0; 
            Scanner sc = new Scanner(System.in); 

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