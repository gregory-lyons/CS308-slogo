package Backend;

public class Tree {
	
	Node myRoot;
	Tree myLeft;
	Tree myRight;
	
	public Tree (Node root) {
		myRoot = root;
	}
	
	public Node find(String stuff) {
		
		Node leftNode = this.myLeft.myRoot;
		Node rightNode = this.myRight.myRoot;
		Node current = myRoot;
		
		while (current.myStuff != stuff) {
			
			if (leftNode.myStuff != stuff) {
				current = leftNode;
			}
			if (rightNode.myStuff != stuff) {
				current = rightNode;
			}
			if (current == null) {
				return null;
			}	
		}
		return current;
		
	}
	
	
	
}
