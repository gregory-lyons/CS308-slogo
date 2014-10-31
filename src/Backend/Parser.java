package Backend;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.turtlecommands.CommandNode;

/**
 * @author: Justin Carrao, Ashwin Kommajesula
 * 			This class is the one that parses the string
 *          instructions passed to the back end It is designed to help the
 *          interpreter class, basically.
 * 
 */

public class Parser {

	private static final String NODES = "Nodes.";
	private static final String NODE = "Node";
	private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";
	private static final String EMPTY_STRING = "";
	private static final String TURTLECOMMANDS = "turtlecommands.";
	private static final String MATH = "math.";
	private static final String LOOPS = "loops.";
	private static final String BOOLEANS = "booleans.";
	private static final String RESOURCES_LANGUAGES = "resources.languages/";
	private String[] splitWords;
	private Turtle myTurtle;
	private static final String[] Packages = { EMPTY_STRING, BOOLEANS, LOOPS,
			MATH, TURTLECOMMANDS };
	private boolean noError;

	public void newInfo(String input, Turtle turtle, String language) {
		myTurtle = turtle;
		splitWords = makeArrayOfInput(input, language);
	}

	
	private String[] makeArrayOfInput(String input, String language){
		ResourceBundle myBundle = ResourceBundle
				.getBundle(RESOURCES_LANGUAGES + language);
		Map<String, String> mapOfWords = new HashMap<String, String>();
		Enumeration<String> keys = myBundle.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String[] value = myBundle.getString(key).split(",");
			for (int i = 0; i < value.length; i++) {
				mapOfWords.put(value[i], key);
			}
		}
		String[] words = input.split("\\s+");
		String[] convertedList = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			if (words[i].matches(NUMBER_REGEX)) {
				convertedList[i] = words[i];
				continue;
			}
			words[i] = words[i].toLowerCase();
			String converted = mapOfWords.get(words[i]);
			converted += NODE;
			convertedList[i] = converted;
		}
		return convertedList;		
	}

	public Queue<Node> getQueueOfNodes() {
		noError = true;
		Queue<Node> nodeList = new ArrayDeque<Node>();
		for (String s : splitWords) {
			Node node = null;
			try {
				double info = Double.parseDouble(s);
				node = new ConstantNode(info);
				nodeList.add(node);
				continue;
			} catch (Exception e) {
			}
			for (int j = 0; j < Packages.length; j++) {
				try {
					String stringToCheck = NODES + Packages[j] + s;
					node = (Node) Class.forName(stringToCheck).newInstance();

					if (node instanceof CommandNode) {
						((CommandNode) node).addTurtle(myTurtle);
					}
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException e) {
				}
			}
			try {
				nodeList.add(node);
			} catch (NullPointerException ne) {
				noError = false;
			}

		}
		return nodeList;
	}

	public String checkSaveType() {
		if (splitWords[0] == "To") {
			return "ToNode";
		}
		if (splitWords[0] == "Make") {
			return "MakeNode";
		} else {
			return "Invalid";
		}
	}

	public String getVariableName() {
		return splitWords[1];
	}

	public double getVariableValue() {
		return Double.parseDouble(splitWords[2]); // this is the variable value
	}

	public String[] getFunctionBody() {
		for (int i = 0; i < splitWords.length; i++) {
			int count = 0;
			if (splitWords[i] == "[" && count != 1) {
				count++;
			} else if (splitWords[i] == "[" && count == 1) {
				String[] newArray = Arrays.copyOfRange(splitWords, i,
						splitWords.length);
				return newArray;
			}
		}
		return splitWords;
	}

	public String[] getFunctionParams() {
		int start = 0;
		int stop = 0;
		int startCount = 0;
		int stopCount = 0;
		for (int i = 0; i < splitWords.length; i++) {
			if (splitWords[i] == "[" && startCount == 0) {
				start = i;
				startCount++;
			}
			if (splitWords[i] == "]" && stopCount == 0) {
				stop = i;
				stopCount++;
			}
		}
		String[] params = Arrays.copyOfRange(splitWords, start, stop);
		return params;
	}

	public String getFunctionName() {
		return splitWords[1];
	}

	public boolean getNoError() {
		return noError;
	}

}
