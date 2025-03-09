import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class ParseFile {

    //instance variables 
    

    public ParseFile(){ 
        //contructor, setting initial values 


    }


    public static void main(String[] args){ 

        String path = ""; 
        String line = "";

        // collecting file name; 

        Scanner sc = new Scanner(System.in); 
        System.out.println("Please enter the name of the textfile you want to parse: "); 
        path = sc.nextLine(); 

        try{

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                List<String[]> database = new ArrayList<>(); 

                while((line = br.readLine()) != null){ 

                    String[] values = line.split("\t"); 
                    // 0: key, 1: sentence, 2: confidence score

                    if (values.length == 3){ 
                        database.add(values); 
                    } else {break;}

                }

                //__________________________
                // Checking with print 

                for (String[] x : database){ 
                    System.out.println(x[0]+ "" +x[1]+""+x[2]); 
                }
                //__________________________
            }

        } catch (FileNotFoundException e){ 
            e.printStackTrace();
        } catch (IOException e){ 
            e.printStackTrace();
        }

        sc.close(); 


    }

    }

// "C:\Users\Yello\OneDrive\Documents\test.txt"