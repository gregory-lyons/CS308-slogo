package Backend;

import java.util.Stack;

import Commands.Command;

/*
 * @author: Justin Carrao. This class is the one that parses the string instructions passed to the backend
 * It is designed to help the interpreter class, basically.
 */

public class Parser {

	private String myInput;
	String[] splitWords;

	public Parser(String input) {

		myInput = input.trim(); // removes any excess whitespace on the ends
		splitWords = input.split("\\s+");
	}

	public String nextWord() {
		String emptyString = "";
		String nextWord;
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
			nextWord = myInput.substring(0, stopSpot + 1);
			myInput = myInput.substring(stopSpot + 1);
			return nextWord;
		}

		for (char c : restOfInput) {
			if (c == ' ') {
				stopSpot = restOfInput.toString().indexOf(c);
				nextWord = myInput.substring(0, stopSpot);
				myInput = myInput.substring(stopSpot + 1);
				return nextWord;
			}
		}

		nextWord = myInput;
		myInput = emptyString;
		return nextWord;

	}

	/*
	 * assumes that the input is only one line and will either be a single word
	 * or a single word followed by a number
	 */
	public String getExpression() throws Exception {
		String expression = "";
		String startWord = nextWord();
		expression = expression + startWord;
		// Command head = new Command(null);
		// Command current = head;
		String holder = myInput;
		while (isNotEmpty()) { // not sure how to do this Ashwin
			
		}
		return expression;
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
