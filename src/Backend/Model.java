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
	List<Double> printValues;
//	public ArrayList<SavedData> userSaves;

	public Model() {
		tree = new AST();
		printValues = new ArrayList<Double>();

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
		myParser = new Parser(instruction, t, language);
		printValues.addAll(tree.populateTree(myParser.getQueueOfNodes()));
		return myParser.getNoError();	
	}
	
}
