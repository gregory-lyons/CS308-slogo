package Backend;

import java.util.ArrayList;
import java.util.List;

public class Input {
	
	
	public Input(String input) {
	}
	
	public List<String> parse(String input) {
		return operations(commands(input));
	}
	
	public List<String> commands(String input) {
		return null;
	}
	
	public List<String> operations(List<String> commands) {
		return null;
	}

}
