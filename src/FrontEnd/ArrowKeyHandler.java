package FrontEnd;

import javafx.scene.input.KeyCode;

public class ArrowKeyHandler {

	public static final String FORWARD = " FD 5";
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
		case UP: instruction += DIRECT_UP + FORWARD;
		case DOWN: instruction += DIRECT_DOWN + FORWARD;
		case LEFT: instruction += DIRECT_LEFT + FORWARD;
		case RIGHT: instruction += DIRECT_RIGHT + FORWARD;
		default: ;
		}
		return instruction;
	}

}
