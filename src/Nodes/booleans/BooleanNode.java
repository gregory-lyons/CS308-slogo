package Nodes.booleans;

import java.util.ArrayList;

import Nodes.Node;
import Nodes.turtlecommands.CommandNode;

public abstract class BooleanNode extends Node {
	
	public boolean myValue;
	private ArrayList<Object> myParams;
	
	public BooleanNode(String item1, String operator, String item2) {
		myParams.add(item1);
		myParams.add(operator);
		myParams.add(item2);
	}
	
	public boolean evaluate() { //not sure yet
		
	}
	
	

}
