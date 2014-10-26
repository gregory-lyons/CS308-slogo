package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.ToNode;
import javafx.geometry.Point2D;

public class Model {

	protected String myInput;
	private Parser myParser;
	private Turtle myTurtle;
	private AST tree;
	List<Double> printValues;
	private Map<String, ConstantNode> userSaves;

	public Model() {
		tree = new AST();
		printValues = new ArrayList<Double>();
		myParser = new Parser();
	}

	public Model(String input) {
		myInput = input;
	}

	public Parser getParser() {
		return myParser;
	}

	public SceneUpdater parse(String instruction, List<Turtle> activeTurtles, String language) {
		boolean noError = true;
		if (activeTurtles.size() == 0) {
			noError = makeTreeandAddValues(instruction, null, language);
		}
		for (Turtle turtle : activeTurtles) {
			boolean valid = makeTreeandAddValues(instruction, turtle, language);
			if (!valid)
				noError = false;
		}
		SceneUpdater result = new SceneUpdater(activeTurtles, printValues, noError);
		return result;
	}
	
	private boolean makeTreeandAddValues(String instruction, Turtle t, String language){
		myParser.newInfo(instruction, t, language);
		printValues.addAll(tree.populateTree(myParser.getQueueOfNodes()));
		userSaves = myParser.getMap();
		return myParser.getNoError();	
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
