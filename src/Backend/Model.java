package Backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Nodes.ConstantNode;

/**
 * 
 *
 *The Model serves as the overarching class for the back end.  It builds the Abstract Syntax Tree (AST) by using a Parser to 
 *parse the instruction passed from the controller.  The back end can detect syntax errors and uses reflection to create the tree.
 *
 * @author Ashwin, Justin, Greg
 *
 */

public class Model {

	protected String myInput;
	private Parser myParser;
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
	
}
