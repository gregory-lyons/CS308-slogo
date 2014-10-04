package Backend;

import java.util.ArrayList;
import java.util.List;

public class Input extends Model {
	
	protected String myInput;
	protected List<String> myCommands = new ArrayList<String>();
	protected List<String> myOperations = new ArrayList<String>();
	
	public Input(String input) {
		super(input);
	}
	
	public List<String> parse(String input) {
		return operations(commands(input));
	}
	
	public List<String> commands(String input) {
		// to implement
		return myCommands;
	}
	
	public List<String> operations(List<String> commands) {
		// to implement
		return myOperations;
	}

}
