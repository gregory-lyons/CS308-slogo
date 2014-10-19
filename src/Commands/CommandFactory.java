package Commands;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import Backend.Parser;


/**
 * 
 * @author justincarrao
 * This is the class we use for
 * building commands.  It gets
 * the command inputs from the
 * interpreter
 *
 */
public class CommandFactory {
	
	private List<String> supportedLanguages = Arrays.asList("Chinese", "English", "French", "Italian", "Portuguese", "Russian");
	private HashMap<String, String> expressionGetter = new HashMap<String, String>();
	ArrayList<String> myInterpretedInputs = new ArrayList<String>();
	
	public CommandFactory(ArrayList<String> commandInputs) {
		myInterpretedInputs = commandInputs;
		
	}
	
	/*
	 * need this to get relevant info from 
	 * resources.languages file and map it 
	 * into expressionGetter 
	 */
	public String getLanguage(String language) { 
		expressionGetter.clear();
		
		if (supportedLanguages.contains(language)) {
			Scanner scan = new Scanner(getClass().getResourceAsStream("/resources.'anguages/" + language + ".properties"));
			
			
			while (scan.hasNextLine()) {
				
				String current = scan.nextLine(); 		
				
				if (!current.startsWith("#") && !current.isEmpty()) {
					String commands = scan.nextLine();
					String[] expressionArgs = commands.split("\\s+");
					expressionGetter.put(expressionArgs[0], expressionArgs[2]);
				}
			}
			scan.close();
			String emptyString = "";
			return emptyString;
		}
		else {
			return "Language not found";
		}
		
		
	}
	
	
		


	
	

	public Command buildInstruction(String expression) throws Exception {
		String firstLetter = expression.substring(0, 1);
		try {
			double number = Double.parseDouble(expression);
			return new ConstantCommand(number);
		}
		
		catch (Exception exc) {
			try {
				
				if (firstLetter == "(") {
					return new Command();
				}
				else if (firstLetter == ":") {
					return new CompoundCommand();
				}
				
				String commandName = expressionGetter.get(expression);
				Class commandType = Class.forName(commandName); 
				/*
				 * I don't know what to do here, because I only know how to
				 * implement this using the Superclass Command's constructor.
				 * The subclasses often have other constructor parameters.
				 */
				Constructor commandInstance = commandType.getConstructors()[0];
				return (Command) (commandInstance.newInstance());
			}
			
			catch (Exception x) {
				throw new Exception("That's not a real command.");
			}
		}	
	}

}
