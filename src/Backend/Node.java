package Backend;

import java.util.ArrayList;

public class Node { 
	
    String myStuff; 
    Node myLeft; 
    Node myRight;
    ArrayList<Node> myChildren;

    public Node () { 
    	
    } 

    public Node (String stuff, Node left, Node right) { 
        myStuff = stuff; 
        myLeft = left;
        myRight = right;
    } 

    public String toString () { 
        return myStuff + ""; 
    } 
    
    public void addLeftChild(Node node, Node newNode) {
		node.myLeft = newNode;
	}
    
    public void addRightChild(Node node, Node newNode) {
    	node.myLeft = newNode;
    }
    
}