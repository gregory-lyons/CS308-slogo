package Backend;

import java.util.Stack;

import Commands.Command;

/** @author: 
 * justincarrao. This class is the one that parses the 
 * string instructions passed to the back end
 * It is designed to help the interpreter class, basically.
 * 
 */

public class Parser {

	private String myInput;
	String[] splitWords;

	public Parser(String input) {
		
		input.replaceAll("\\s+", " " + "");
        myInput = input.trim(); // removes any excess whitespace on the ends
		
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
	 * for now this assumes that the input is only one line and will either be a single word
	 * or a single word followed by a number
	 */
	public String getExpression() throws Exception {
		//ideally anyway
		return "";
	}
	
	public String commandType(){
		return splitWords[0];
	}
	
	public double data(){
		if(splitWords.length > 1)
		return Double.parseDouble(splitWords[1]);
		else return 0;
	}

	public boolean isNotEmpty() {
		return !myInput.isEmpty();
	}

}
