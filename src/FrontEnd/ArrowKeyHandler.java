package FrontEnd;

import javafx.scene.input.KeyCode;

public class ArrowKeyHandler {

	public static final String FORWARD = " FD 2";
	public static final String DIRECT_UP = "SETH 0";
	public static final String DIRECT_DOWN = "SETH 180";
	public static final String DIRECT_LEFT = "SETH 270";
	public static final String DIRECT_RIGHT = "SETH 90";
	
	public ArrowKeyHandler() {		
	}
	
	public String makeInstruction(KeyCode kc){
		String instruction = "";
		switch (kc)
		{
		case UP: instruction += DIRECT_UP + FORWARD; break;
		case DOWN: instruction += DIRECT_DOWN + FORWARD; break;
		case LEFT: instruction += DIRECT_LEFT + FORWARD;  break;
		case RIGHT: instruction += DIRECT_RIGHT + FORWARD; break;
		default: ;
		}
		return instruction;
	}

}
