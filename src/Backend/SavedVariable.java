package Backend;

public class SavedVariable extends SavedData{
	
	public double myValue;
	
	public SavedVariable(String name, double value) {
		super(name);
		myValue = value;
	}
	
	public double getValue() {
		return myValue;
	}

}
