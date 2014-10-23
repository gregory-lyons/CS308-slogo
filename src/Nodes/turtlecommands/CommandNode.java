package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public abstract class CommandNode extends Node{

	protected Turtle myTurtle;
	protected Node left;
	protected Node right;
	
	@Override
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		left = newNode;
	}
	
	public Node update(){
		return new ConstantNode(printValue);
	}
	
	public boolean noMoreChildren(){
		return true;
	}
	
	public void addTurtle(Turtle newTurtle){
		myTurtle = newTurtle;
	}
	
}
