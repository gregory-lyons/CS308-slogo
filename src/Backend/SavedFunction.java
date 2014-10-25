package Backend;

public class SavedFunction extends SavedData {
	
	String[] myParams;
	String[] myProcedure;
	
	public SavedFunction(String name, String[] params, String[] procedure) {
		super(name);
		myParams = params;
		myProcedure = procedure;
	}
	
	public String[] getParams() {
		return myParams;
	}
	
	public String[] getProcedure() {
		return myProcedure;
	}

}
