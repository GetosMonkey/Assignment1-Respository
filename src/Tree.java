package src; 

public interface Tree{ 

    void insert(String key, String sentence, double confidenceScore);
    void traverse(); 
    boolean isEmpty(); 

}
