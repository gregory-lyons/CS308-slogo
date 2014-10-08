package Backend;

import java.util.ArrayList;

public class Tree {
	
	public Tree myLeft;
	public Tree myRight;
	public ArrayList<Tree> myChildren;
	
	
	public Tree (Tree left, Tree right, ArrayList<Tree> children) {
		
		myLeft = left;
		myRight = right;
		myChildren = children;
		
	}

}
