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
 * @author: Justin Carrao, Ashwin Kommajesula
 * 			This class is the one that parses the string
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
	private Map<String, ConstantNode> daMap;

	public Parser() {
		daMap = new HashMap<String, ConstantNode>();
	}

	public void newInfo(String input, Turtle turtle, String language) {
		myTurtle = turtle;
		ResourceBundle myBundle = ResourceBundle
				.getBundle("resources.languages/" + language);
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
			if (array[i].matches(":[a-zA-Z]+")) {
				convertedList[i] = array[i].substring(1);
				System.out.println(convertedList[i]);
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

	private String getNextString(String str, String[] array) {
		return array[Arrays.asList(array).indexOf(str) + 1];
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
				if (!(s.substring(s.length() - 4).equals("Node"))) {
					node = daMap.get(s);
					if (node instanceof ConstantNode)
						nodeList.add(node);
					else {
						System.out.println(s);
						System.out.println(Double.parseDouble(getNextString(s,
								splitWords)));
						daMap.put(
								s,
								new ConstantNode(Double
										.parseDouble(getNextString(s,
												splitWords))));
					}
					if (node != null)
						continue;
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

	public Map<String, ConstantNode> getMap() {
		return daMap;
	}

}
