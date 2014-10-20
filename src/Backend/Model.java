package Backend;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class Model {

	protected String myInput;
	private Interpreter myInterpreter;
	private Parser myParser;
	private Turtle turtle;
	private AST tree;

	public Model() {

	}

	public Model(String input) {
		myInput = input;
	}

	public Interpreter getInterpreter() {
		return myInterpreter;
	}

	public Parser getParser() {
		return myParser;
	}

	public SceneUpdater parse(String instruction, boolean penState) {
		myParser = new Parser(instruction);
		tree.populateTree(myParser.getQueueOfNodes());
		List<Point2D> list = new ArrayList<Point2D>();
		list.add(new Point2D(200.0, 100.0));
		list.add(new Point2D(100.0, 50.0));
		list.add(new Point2D(500.0, 200.0));
		
		double angle = 90.0;
		Turtle turtle = new Turtle(list, angle, new ArrayList<String>(), true,
				true, "Error");
		SceneUpdater scene = new SceneUpdater(turtle);
		return scene;

	}

}
