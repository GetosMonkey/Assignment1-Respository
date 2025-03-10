// Maryam Abrahams
// ABRMAR043
// 10 March 2025 

// Resource: https://www.youtube.com/watch?v=zIX3zQP0khM&t=694s
// Credit : Geekific, Binary Search Trees

package src;

public class BinarySearchTree implements Tree{ 

        private Node root; 

        //Constructor
        public BinarySearchTree(){
            this.root = null; 
        }

        // If empty
        @Override 
        public boolean isEmpty(){ 
            return root == null; 
        }
        
        // Don't need to get max or min 

        // Traversal 

        public void traverse(){ 
            traverseInOrder(root); 
        }

        public void traverseInOrder(Node node){ 
            if (node != null){ 
                traverseInOrder(node.getLeftChild()); 
                //System.out.println("key: " + node.key + ", sentence: " + node.sentence + ", CS: " + node.confidenceScore); 
                traverseInOrder(node.getRightChild());
            }
        }

        // Recursive Search 

        public Node searchByKey(String key){
            return searchByKey(root, key); 
        }

        public Node searchByKey(Node node, String key){

            if (node == null || key.equals(node.key)) { return node; }

            if (key.compareTo(node.key) < 0) { return searchByKey(node.getLeftChild(), key); } 
            
            else {return searchByKey(node.getRightChild(), key); }
        }

        //Insertion

        public void insert(String key, String sentence, double CS){
            root = insert(root, key, sentence, CS); 
        }

        public Node insert(Node node, String key, String sentence, double confidenceScore){

            if (node == null){
                return new Node(key, sentence, confidenceScore); 
            }
            if (key.compareTo(node.key)>0){

                node.setLeftChild(insert(node.getLeftChild(), key, sentence, confidenceScore));
 
            } else if (key.compareTo(node.key) < 0){

                node.setRightChild(insert(node.getRightChild(), key, sentence, confidenceScore)); 
            
            } else {

                // If the Key already exists update is CS is higher than existing CS
                if (confidenceScore > node.confidenceScore){
                    node.sentence = sentence; 
                    node.confidenceScore = confidenceScore; 
                }
            }

            return node; 
        }


        // Don't need Deletion

        }