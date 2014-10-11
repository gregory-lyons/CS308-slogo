package Commands;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import Backend.Parser;

public class CommandFactory {
	
	private List<String> supportedLanguages = Arrays.asList("Chinese", "English", "French", "Italian", "Portuguese", "Russian");
	private HashMap<String, String> expressionGetter = new HashMap<String, String>();
	
	public CommandFactory() {
		
		
	}
	
	/*
	 * need this to get relevant info from 
	 * resources.languages file and map it 
	 * into expressionGetter 
	 */
	public String setLanguage(String language) { 
		expressionGetter.clear();
		
		if (supportedLanguages.contains(language)) {
			Scanner scn = new Scanner(getClass().getResourceAsStream("/resources.anguages/" + language));
			
			
			while (scn.hasNextLine()) {
				String current = scn.nextLine(); 
				Parser parser = new Parser(current);
				
				if (!current.isEmpty() && !current.startsWith("#")) {
					expressionGetter.put(parser.nextWord(), parser.nextWord());
				}
			}
			scn.close();
			String emptyString = "";
			return emptyString;
		}
		else {
			return "Language not found";
		}
		
		
	}
	
	

	public Command buildInstruction(Command parent, String expression) throws Exception {
		String firstLetter = expression.substring(0, 1);
		try {
			double number = Double.parseDouble(expression);
			return new ConstantCommand(parent, number);
		}
		
		catch (Exception exc) {
			try {
				
				if (firstLetter == "(") {
					return new Command(parent);
				}
				else if (firstLetter == ":") {
					return new CompoundCommand(parent);
				}
				
				String commandName = expressionGetter.get(expression);
				Class commandType = Class.forName(commandName); 
				/*
				 * I don't know what to do here, because I only know how to
				 * implement this using the Superclass Command's constructor.
				 * The subclasses often have other constructor parameters.
				 */
				Constructor commandInstance = commandType.getConstructors()[0];
				return (Command) (commandInstance.newInstance(parent));
			}
			
			catch (Exception x) {
				throw new Exception("That's not a real command.");
			}
		}	
	}

}
