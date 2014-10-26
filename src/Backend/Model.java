package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import Nodes.Node;
import Nodes.ToNode;
import javafx.geometry.Point2D;

public class Model {

	protected String myInput;
	private Parser myParser;
	private Turtle myTurtle;
	private AST tree;
//	public ArrayList<SavedData> userSaves;

	public Model() {
		tree = new AST();

	}

	public Model(String input) {
		myInput = input;
	}

	public Parser getParser() {
		return myParser;
	}

	public SceneUpdater parse(String instruction, List<Turtle> activeTurtles, String language) {
		List<Double> printValues = new ArrayList<Double>();
		for (Turtle turtle : activeTurtles) {
			myParser = new Parser(instruction, turtle);
			printValues.addAll(tree.populateTree(myParser.getQueueOfNodes()));
		}
		return new SceneUpdater(activeTurtles,printValues);
	}
	
//	public void addSavedData(String input) {
//		Parser newParser = new Parser(input, myTurtle);
//		if (newParser.checkSaveType() == "ToNode") {
//			String[] functionBody = newParser.getFunctionBody();
//			String[] functionParams = newParser.getFunctionParams();
//			String functionName = newParser.getFunctionName();
//			SavedFunction fcn = new SavedFunction(functionName, functionParams, functionBody);
//			userSaves.add(fcn);
//		}
//		else if (newParser.checkSaveType() == "MakeNode") {
//			String varName = newParser.getVariableName();
//			double varValue = newParser.getVariableValue();
//			SavedVariable var = new SavedVariable(varName, varValue);
//			userSaves.add(var);
//		}
//	}
	

	
//	public HashMap<String, ArrayList<String[]>> getSavedFunctions() {
//		return savedFunctions;
//	}
//	

}
