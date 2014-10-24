package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import Nodes.Node;
import javafx.geometry.Point2D;

public class Model {

	public HashMap<String, String> userSaves;
	protected String myInput;
	private Parser myParser;
	private Turtle turtle;
	private AST tree;

	public Model() {

	}

	public Model(String input) {
		myInput = input;
	}

	public Parser getParser() {
		return myParser;
	}

	public SceneUpdater parse(String instruction, List<Turtle> activeTurtles) {
		List<Double> printValues = new ArrayList<Double>();
		for (Turtle turtle : activeTurtles) {
			myParser = new Parser(instruction, turtle);
			printValues.addAll(tree.populateTree(myParser.getQueueOfNodes()));
		}
		return new SceneUpdater(activeTurtles,printValues);
	}
	
	public HashMap<String, String> getSavedFile() {
		return userSaves;
	}
	

}
