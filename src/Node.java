/**
 * The Node class represents a single entry in the Binary Search Tree. 
 * It contains a key (term), a sentence, a confidence score, and references 
 * to left and right child nodes.
 * 
 * Fields:
 * - key: The term associated with the knowledge entry.
 * - sentence: The statement linked to the term.
 * - confidenceScore: A numeric value (0.0 to 1.0) representing reliability.
 * - left, right: Pointers to left and right child nodes.
 * 
 * @author Maryam Abrahams
 * @version 1.0
 * @since 2025-03-05
 */

package src;  

public class Node {

    Node left, right;
    double confidenceScore; 
    String key, sentence; 

    //Constructor 
    public Node(String key, String sentence, double confidenceScore){
        this.key = key; 
        this.sentence = sentence; 
        this.confidenceScore = confidenceScore; 
        this.left = this.right = null; 
    }

    public Node getLeftChild(){
        return left; 
    }

    public void setLeftChild(Node newNode){
        this.left = newNode; 
    }

    public Node getRightChild(){
        return right; 
    }

    public void setRightChild(Node newNode){
        this.right = newNode; 
    }

}

