// Maryam Abrahams
// ABRMAR043
// 5th March 2025
package src;
import java.util.List;
import java.util.Scanner;

public class GenericsKbBSTApp{

    BinarySearchTree tree = new BinarySearchTree(); 

    public GenericsKbBSTApp(){

    }

    // 1) Load knowledge base from file

    public void convertToTree(Parsefile path){ 
        List<String[]> list = path.getDatabase(); 

        //inserting into my tree 
        for (String[] i : list){
            String key = i[0]; 
            String sentence = i[1]; 
            double CS = Double.parseDouble(i[2]); 

            tree.insert(key, sentence, CS); 
        }
    }


    // 2) Update a Statement in the knowledge base 

    public void updateTerm(String key, String sentence, String cs){

        double CS = Double.parseDouble(cs); 

        if (tree == null){
            System.out.println("Please first load a knowledge base. \n");
            return;
        }
        
        Node tuple = tree.searchByKey(key); 

        if ( tuple == null){
            System.out.println("The term was not found within the database. "); 
                //Combining add and update: 
                System.out.println("Would you like to add the new information to the knowledge base? [y or \\n]: ");
                    Scanner scan = new Scanner(System.in); 
                    if (scan.nextLine().equals("y")){
                        tree.insert(key, sentence, CS);
                    } else if (scan.nextLine().equals("n")){
                        scan.close(); 
                        return; 
                    } else { System.out.print("Please enter either 'y' or 'n': ");}
                    scan.close();
            return;
        }else{ 
            System.out.println("The term was found within the database. ");
            tree.insert(key, sentence, CS);
        }
        
    }


    // 3) Search for a statement by term 

    public void searchByTerm(String term){

        

    }


    // 4) Search for a statement by term and sentence
    
    public void termAndSentence(String term, String sentence){

    }

    public static void main(String[] args){
    
                // Collecting user input and showing output
    
                int choice = 0; 
                Scanner sc = new Scanner(System.in);
                GenericsKbBSTApp gkbbst = new GenericsKbBSTApp(); 
    
            while (choice != 5) {
                
                //updates if the confidence score is higher than an existing one 
                System.out.println("""
                        Choose an action from the menu:
                        1. Load a knowledge base from a file
                        2. Add or update a statement to\\in the knowledge base
                        3. Search for a statement in the knowledge base by term
                        4. Search for a statement in the knowledge base by term and sentence
                        5. Quit
    
                        Enter your choice: 
                        """);
    
                        choice = sc.nextInt();
                        sc.nextLine(); //fixing future sc bugs by consuming trailing \n 
    
                    switch(choice){
                    case 1:

                        System.out.println("Enter file directory: "); // full file directory recquire (command: realpath filename.txt 
                        String filename = sc.nextLine(); 
                        Parsefile path = new Parsefile(filename);
                        gkbbst.convertToTree(path);
                        
                        System.out.println("Knowledge base loaded successfully.\n");

                        break;

                    case 2: 

                        System.out.println("Please enter the term you want to add to the knowledge base: ");
                        String key = sc.nextLine(); 
                        System.out.println("Please enter the new information you want associated with the term: "); 
                        String sentence = sc.nextLine(); 
                        System.out.println("Please enter the Confidence Score of your information on a scale from 0.0(impossible) to 1.0(certain): ");
                        String confidenceScore = sc.nextLine();
                        
                        gkbbst.updateTerm(key, sentence, confidenceScore); 

                        break; 

                    case 3:
                        
                        System.out.println("Enter the term to search: ");
                        String term = sc.nextLine();

                        gkbbst.searchByTerm(term); 

                        break; 

                    case 4:
                        break;
                    
                    case 5: 
                        break; 

                }}
                System.out.print("Thanks for Using GenericsKb :)");
                sc.close(); 
        }
}