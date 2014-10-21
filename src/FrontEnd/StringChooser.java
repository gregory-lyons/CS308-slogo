package FrontEnd;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * String selector so that text can be selected in the correct language
 * @author Rica
 *
 */
public class StringChooser {
    public static List<String> myLanguageOrder = Arrays.asList(new String[]{DefaultStrings.ENGLISH, DefaultStrings.CHINESE, 
                                                                             DefaultStrings.FRENCH, DefaultStrings.ITALIAN, 
                                                                             DefaultStrings.PORTUGUESE, DefaultStrings.RUSSIAN});
    private static final ResourceBundle myLanguages = ResourceBundle.getBundle(DefaultStrings.DEFAULT_RESOURCE_PACKAGE);

    public static String getWordInLang(String language, String wordToAdd) {
        int languageNum = myLanguageOrder.indexOf(language);
        
        List<String> myWordsList = Arrays.asList(myLanguages.getString(wordToAdd).split("__"));
        return myWordsList.get(languageNum);
    }

}
