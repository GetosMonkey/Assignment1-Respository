/**
 * The Parsefile class is responsible for reading knowledge base data from a file 
 * and storing it in a List of String arrays.
 * 
 * Features:
 * - Reads data from a tab-separated text file.
 * - Stores entries as an ArrayList of String arrays.
 * - Provides access to the knowledge base for further processing.
 * 
 * @author Maryam Abrahams
 * @version 1.0
 * @since 2025-03-05
 */

package src;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Parsefile {

    //instance variables 
    
    public List<String[]> database; 

    public Parsefile(String path){ 
        //contructor
        this.database = new ArrayList<>(); 

        parseFile(path); 

    }

    public Parsefile(){
        
        this.database = new ArrayList<>(); 
        String path = ""; 

        // collecting file name; 

        Scanner sc = new Scanner(System.in); 
        System.out.println("Please enter the name of the textfile you want to parse: "); 
        path = sc.nextLine();
        
        parseFile(path);

        sc.close();
    }

    // Method to parse the file and populate the database
    private void parseFile(String path){ 

        String line = "";

        try{

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                while((line = br.readLine()) != null){ 

                    String[] values = line.split("\t"); 
                    // 0: key, 1: sentence, 2: confidence score

                    if (values.length == 3){ 
                        this.database.add(values); 
                    } else {break;}

                }

            }

        } catch (FileNotFoundException e){ 
            e.printStackTrace();
        } catch (IOException e){ 
            e.printStackTrace();
        }

    }

    // Method to get and return database

    public List<String[]> getDatabase() {
        return database;
    }
    
    public static void main(String[] args){

    }
    }

// /home/abrmar043/Assignment 1 - Project/textfiles/Testfile.txt