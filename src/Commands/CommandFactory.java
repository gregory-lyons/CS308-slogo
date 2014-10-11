package Commands;

import java.util.List;

public class CommandFactory {
	
	private List<String> supportedLanguages = Arrays.asList("chinese", "english", "french", "italian", "portuguese", "russian");
	
	public CommandFactory() {
		
	}
	
	public String setLanguage(String language) {
		return language;
	}

}
