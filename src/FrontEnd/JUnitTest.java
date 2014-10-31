package FrontEnd;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import FrontEnd.View;
import TurtleView.TurtleWindow;

import org.junit.Rule;
import org.junit.Test;

public class JUnitTest {

	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	public JUnitTest() {
		
	}
	
	@Test
	public void checkViewInit(){
		
		View v = new View();
		assertNotNull(v.getScene());
		assertNotNull(v.getTurtleInfo());
		assertNotNull(v.getTurtleWindow());
	}
	
	@Test
	public void checkDialog(){
		View v = new View();
		assertNotNull(v.makeErrorDialog("TEST", "TEST2"));
		
	}
	
	@Test
	public void checkLanguage(){
		View v = new View();
		assertEquals(v.getCurrentLanguage(), ViewConstants.DEFAULT_LANGUAGE);
	}
	
	@Test
	public void addTurtle(){
		View v = new View();
		TurtleWindow tw = v.getTurtleWindow();
		tw.makeTurtle();
		Object value = null;
		try {
			Field turtleCount = null;
			turtleCount = tw.getClass().getDeclaredField("numTurtles");
			turtleCount.setAccessible(true);
			try {
				value = turtleCount.get(tw);
			} catch (IllegalArgumentException | IllegalAccessException e) {
			}
			
		} catch (NoSuchFieldException | SecurityException e) {
			
		}
        assertEquals(value, tw.START_TURTLES+1);
	}

}
