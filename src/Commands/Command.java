package Commands;

import java.util.ArrayList;
import java.util.List;

public class Command {
	
	/**
	 * @author justincarrao
	 * this class and all of its subclasses 
	 * are ultimately the format that Executor.java will use to 
	 * perform operations on instances of the turtle class.
	 * 
	 * 
	 */
	
	public String myReturnValue;
	public List<Command> myChildren;
    public Command myParent;
    
    
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
