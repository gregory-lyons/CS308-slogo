package FrontEnd;

import static org.junit.Assert.*;
import FrontEnd.View;

import org.junit.Test;

public class JUnitTest {

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

}
