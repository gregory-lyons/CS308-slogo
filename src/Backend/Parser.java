package Backend;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;

import Nodes.Node;
import Nodes.turtlecommands.CommandNode;

/**
 * @author: justincarrao. This class is the one that parses the string
 *          instructions passed to the back end It is designed to help the
 *          interpreter class, basically.
 * 
 */

public class Parser {

	private String myInput;
	private String[] splitWords;
	private Queue<Node> nodeList;
	private Turtle myTurtle;
	private Map<String, String> myMap;

	
	//change constructor to allow for the language to change the input to the resource bundle
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
			array[i] = array[i].toLowerCase();
			String converted = myMap.get(array[i]);
			converted += "Node";
			convertedList[i] = converted;
			System.out.println(converted);
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
		for (String s : splitWords) {
			Node command = null;
			try {
				command = (Node) Class.forName(s).newInstance();
				if (command instanceof CommandNode) {
					((CommandNode) command).addTurtle(myTurtle);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nodeList.add(command);
		}
		return nodeList;
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

}
