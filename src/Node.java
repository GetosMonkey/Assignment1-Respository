// Maryam Abrahams
// ABRMAR043
// 10 March 2025 

// Resource: https://www.youtube.com/watch?v=zIX3zQP0khM&t=694s
// Credit : Geekific, Binary Search Trees

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

