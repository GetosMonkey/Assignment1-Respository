// Maryam Abrahams
// ABRMAR043
// 10 March 2025 

// Resource: https://www.youtube.com/watch?v=zIX3zQP0khM&t=694s
// Credit : Geekific, Binary Search Trees

package src;

public class BinarySearchTree implements Tree{ 

        public Node root; 

        //Constructor
        public BinarySearchTree(){
            this.root = null; 
        }

        // If empty
        //@Override 
        public boolean isEmpty(){
            return root == null; 
        }

        // Traversal 

        public void traverse(){ 
            traverseInOrder(root); 
        }

        public void traverseInOrder(Node node){ 
            if (node != null){ 
                traverseInOrder(node.getLeftChild()); 
                traverseInOrder(node.getRightChild());
            }
        }

        // Recursive Search 

        public Node searchByKey(String key){
            return searchByKey(root, key); 
        }

        public Node searchByKey(Node node, String key){

            if (node == null || key.equals(node.key)) {
                return node; }

            if (key.compareTo(node.key) < 0) { return searchByKey(node.getLeftChild(), key); } 
            
            else {return searchByKey(node.getRightChild(), key); }
        }

            // key & sentence 

        public Node searchSentence(String key, String sentence){
            return searchSentence(root, key, sentence);
        }

        public Node searchSentence(Node node, String key, String sentence){
            
            if (node == null || (key.equals(node.key) && node.sentence.contains(sentence))) {return node;}
    
            if (key.compareTo(node.key) < 0) {return searchSentence(node.getLeftChild(), key, sentence); } 
            
            else {return searchSentence(node.getRightChild(), key, sentence);}
        } 
        
        //Insertion

        public void insert(String key, String sentence, double CS){
            root = insert(root, key, sentence, CS); 
        }

        public Node insert(Node node, String key, String sentence, double confidenceScore){

            if (node == null){
                return new Node(key, sentence, confidenceScore); 
            }
            if (key.compareTo(node.key) < 0){

                node.setLeftChild(insert(node.getLeftChild(), key, sentence, confidenceScore));
 
            } else if (key.compareTo(node.key) > 0){

                node.setRightChild(insert(node.getRightChild(), key, sentence, confidenceScore)); 
            
            } else {

                // If the Key already exists update is CS is higher than existing CS
                if (confidenceScore > node.confidenceScore){
                    node.sentence = sentence; 
                    node.confidenceScore = confidenceScore;
                    System.out.println("Statement successfully added :D !!!"); 
                    //prevents duplicates
                }
            }

            return node; 
        }
        
        // Recursive PrintTree method to test if my Tree is correctly updating:

        public void printTree() {
            System.out.println("Tree Contents (In-order traversal):");
            printTree(root);
            System.out.println();
        }
        
        private void printTree(Node node) {
            if (node != null) {
                // left subtree
                printTree(node.getLeftChild());
        
                // Print the current
                System.out.println("Key: " + node.key + ", Sentence: " + node.sentence + ", Confidence Score: " + node.confidenceScore);
        
                // right subtree
                printTree(node.getRightChild());
            }
        }

        }