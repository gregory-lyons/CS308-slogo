package Nodes;

import Commands.Command;

public abstract class Node {
	
	private Node left;
	private Node right;
	
	public Node(Node first, Node second){
		left = first;
		right = second;
	}
	
}
