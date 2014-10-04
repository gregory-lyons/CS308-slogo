package Backend;

import java.util.List;

public class Output extends Model {
	
	public List<List> myNextStates;

	public Output(String input) {
		super(input);
	}
	public Output(List<List> nextStates) {
		myNextStates = nextStates;
	}
	
	public List<List> getNextStates() {
		return myNextStates;
	}

}
