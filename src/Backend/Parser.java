package Backend;

import java.util.Stack;

public class Parser {
	
	private String myInput;
	
	
	public Parser(String input) {
		
		myInput = input.trim(); //removes any excess whitespace on the ends
		
	}
	
	public String nextWord() {
		String emptyString = "";
		String nextWord;
		char[] restOfInput = myInput.substring(1).toCharArray();
		int stopSpot = 0;
		
		if (myInput.charAt(0) == '(') {
			
			
			Stack<Character> stackHelper = new Stack<Character>();
			stackHelper.push('x');
			
			for(char c: restOfInput) {
				if (c == '(') {
					stackHelper.push(c);
				}
				else if (c == ')') {
					stackHelper.pop();
					if (stackHelper.isEmpty()) {
						stopSpot = restOfInput.toString().indexOf(c);
						break;
					}
				}
			}
			nextWord = myInput.substring(0, stopSpot+1);
			myInput = myInput.substring(stopSpot+1);
			return nextWord;
		}
		
		for (char c: restOfInput) {
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
	
	public boolean hasMore() {
		return !myInput.isEmpty();
	}
	
	

}
