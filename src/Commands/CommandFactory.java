package Commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CommandFactory {
	
	private List<String> supportedLanguages = Arrays.asList("chinese", "english", "french", "italian", "portuguese", "russian");
	private HashMap<String, String> expressionGetter = new HashMap<String, String>();
	private Scanner scanner;
	
	public CommandFactory() {
		
		
	}
	
	public String setLanguage(String language) {
		expressionGetter.clear();
		
		try {
			Stream stream = getClass().getResourceAsStream("")
		}
		catch (Exception exception) {
			return "Language not found";
		}
		
		/*if (supportedLanguages.contains(language)) {
			return language;
		}
		return "Invalid Language";*/
	}
	
	public Command buildInstruction(Command parent, String expression) throws Exception {
		String firstLetter = expression.substring(0, 1);
		
		if (firstLetter == ":") {
			return new Command(parent);
		}
		else if (firstLetter == "(") {
			return new CompoundCommand(parent);
		}
		
		
	}

}
