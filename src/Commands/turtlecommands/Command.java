package Commands.turtlecommands;

import java.util.ArrayList;
import java.util.List;

public class Command {
	
	public String myReturnValue;
	private List<Command> myChildren;
    private Command myParent;
    
    
    public Command(Command parent) {
    	myParent = parent;
    	myChildren = new ArrayList<Command>();
    }
    
    public Command getParent() {
        return myParent;
    }
    
    public List<Command> getChildren() {
        return myChildren;
    }
    
    public void addCommand(Command c) {
    	myChildren.add(c);
    }
    
    


}
