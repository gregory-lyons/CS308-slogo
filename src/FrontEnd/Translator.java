package FrontEnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * String selector so that text can be selected in the correct language
 * @author Rica
 *
 */
public class Translator {
    public static List<String> myLanguageOrder = Arrays.asList(new String[]{DefaultStrings.ENGLISH, DefaultStrings.CHINESE, 
                                                                             DefaultStrings.FRENCH, DefaultStrings.ITALIAN, 
                                                                             DefaultStrings.PORTUGUESE, DefaultStrings.RUSSIAN});
    private static final ResourceBundle myLanguages = ResourceBundle.getBundle(DefaultStrings.DEFAULT_RESOURCE_PACKAGE);
    
    public static String translateWithKey(String key, String language) {
        int languageNum = myLanguageOrder.indexOf(language);
        List<String> myWordsList = Arrays.asList(myLanguages.getString(key).split("__"));
        return myWordsList.get(languageNum);
    }
    
    public static String translateDirect(String word, String language) {
        int languageNum = myLanguageOrder.indexOf(language);
        for (String key : myLanguages.keySet()) {
            List<String> myLanguageList = Arrays.asList(myLanguages.getString(key).split("__"));
            List<String> myUpperCaseLanguageList = new ArrayList<String>();
            for (String eachWord : myLanguageList)
                myUpperCaseLanguageList.add(eachWord.toUpperCase());
            if (myUpperCaseLanguageList.contains(word.toUpperCase()))
                return myLanguageList.get(languageNum);
        }
        return word;
    }
}
