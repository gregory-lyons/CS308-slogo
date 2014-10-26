package Backend;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.booleans.BooleanNode;
import Nodes.math.MathNode;
import Nodes.turtlecommands.CommandNode;
import Nodes.turtlecommands.ForwardNode;

/**
 * @author: justincarrao. This class is the one that parses the string
 *          instructions passed to the back end It is designed to help the
 *          interpreter class, basically.
 * 
 */

public class Parser {

	private String myInput;
	private String[] splitWords;
	private Turtle myTurtle;
	private Map<String, String> myMap;
	private static final String[] Packages = { "", "booleans.", "loops.",
			"math.", "turtlecommands." };
	private boolean noError;

	// change constructor to allow for the language to change the input to the
	// resource bundle
	public Parser(String input, Turtle turtle) {
		myTurtle = turtle;
		ResourceBundle myBundle = ResourceBundle
				.getBundle("resources.languages/English");
		myMap = convertResourceBundleToMap(myBundle);
		splitWords = input.split("\\s+");
		splitWords = convert(splitWords);
	}

	/**
	 * converts will make each of the strings general to take into account the
	 * different types of input for the same node use a properties file
	 * 
	 * @param array
	 * @return
	 */
	private String[] convert(String[] array) {
		String[] convertedList = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i].matches("-?\\d+(\\.\\d+)?")) {
				convertedList[i] = array[i];
				continue;
			}
			array[i] = array[i].toLowerCase();
			String converted = myMap.get(array[i]);
			converted += "Node";
			convertedList[i] = converted;
		}
		return convertedList;
	}

	private Map<String, String> convertResourceBundleToMap(
			ResourceBundle resource) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> keys = resource.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String[] value = resource.getString(key).split(",");
			for (int i = 0; i < value.length; i++) {
				map.put(value[i], key);
			}
		}
		return map;
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
					String stringToCheck = "Nodes." + Packages[j] + s;
					node = (Node) Class.forName(stringToCheck).newInstance();

					if (node instanceof CommandNode) {
						((CommandNode) node).addTurtle(myTurtle);
					}
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException e) {
				}
			}
			try{
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

	public String getWord() {
		String emptyString = "";
		String word;
		char[] restOfInput = myInput.substring(1).toCharArray();
		int stopSpot = 0;

		if (myInput.charAt(0) == '(') {

			Stack<Character> stackHelper = new Stack<Character>();
			stackHelper.push('x');

			for (char c : restOfInput) {
				if (c == '(') {
					stackHelper.push(c);
				} else if (c == ')') {
					stackHelper.pop();
					if (stackHelper.isEmpty()) {
						stopSpot = restOfInput.toString().indexOf(c);
						break;
					}
				}
			}
			word = myInput.substring(0, stopSpot + 1);
			myInput = myInput.substring(stopSpot + 1);
			return word;
		}

		for (char c : restOfInput) {
			if (c == ' ') {
				stopSpot = restOfInput.toString().indexOf(c);
				word = myInput.substring(0, stopSpot);
				myInput = myInput.substring(stopSpot + 1);
				return word;
			}
		}

		word = myInput;
		myInput = emptyString;
		return word;

	}

	/*
	 * for now this assumes that the input is only one line and will either be a
	 * single word or a single word followed by a number
	 */
	public String getExpression() throws Exception {
		// ideally anyway
		return "";
	}

	public String commandType() {
		return splitWords[0];
	}

	public double data() {
		if (splitWords.length > 1)
			return Double.parseDouble(splitWords[1]);
		else
			return 0;
	}

	public boolean isNotEmpty() {
		return !myInput.isEmpty();
	}

	public boolean getNoError() {
		return noError;
	}

}
