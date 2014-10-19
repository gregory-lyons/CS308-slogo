package Commands;

import java.util.ArrayList;
import java.util.List;

public class Command {
	
	public String myReturnValue;
	public List<Command> myChildren;    
    
    public Command() {
    	myChildren = new ArrayList<Command>();
    }
    
    public List<Command> getChildren() {
        return myChildren;
    }
    
    public void addCommand(Command c) {
    	myChildren.add(c);
    }
    
    


}
