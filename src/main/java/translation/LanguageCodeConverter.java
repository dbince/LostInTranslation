package translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class provides the services of: <br/>
 * - converting language codes to their names <br/>
 * - converting language names to their codes
 */
public class LanguageCodeConverter {

    private final Map<String, String> languageCodeToLanguage = new HashMap<>();
    private final Map<String, String> languageToLanguageCode = new HashMap<>();

    /**
     * Default constructor that loads the language codes from "language-codes.txt"
     * in the resources folder.
     */
    public LanguageCodeConverter() {
        this("language-codes.txt");
    }

    /**
     * Overloaded constructor that allows us to specify the filename to load the language code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resources file can't be loaded properly
     */
    public LanguageCodeConverter(String filename) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(Objects.requireNonNull(getClass()
                    .getClassLoader().getResource(filename)).toURI()));

            Iterator<String> iterator = lines.iterator();
            iterator.next(); // skip the first line
            while (iterator.hasNext()) {
                String line = iterator.next();
                if (line.charAt(line.length() - 3) != ' ') {
                    languageCodeToLanguage.put("zh-tw", "Chinese (Taiwan)");
                    languageToLanguageCode.put("Chinese (Taiwan)", "zh-tw");
                }
                String code = line.substring(line.length() - 2);
                String subline = line.substring(0, line.length() - 2).trim();
                while (subline.contains(",")){
                    int index = subline.indexOf(",");
                    String name = subline.substring(0, index);
                    languageToLanguageCode.put(name, code);
                    subline = subline.substring(index + 1).trim();
                }
                String name = subline.trim();
                languageCodeToLanguage.put(code, name);
                languageToLanguageCode.put(name, code);
            }

        } catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Return the name of the language for the given language code.
     * @param code the 2-letter language code
     * @return the name of the language corresponding to the code
     */
    public String fromLanguageCode(String code) {
        code = languageCodeToLanguage.get(code);
        return code;
    }

    /**
     * Return the code of the language for the given language name.
     * @param language the name of the language
     * @return the 2-letter code of the language
     */
    public String fromLanguage(String language) {
        language = languageToLanguageCode.get(language);
        return language;
    }

    /**
     * Return how many languages are included in this language code converter.
     * @return how many languages are included in this language code converter.
     */
    public int getNumLanguages() {
        return languageCodeToLanguage.size();
    }
}
