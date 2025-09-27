package translation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageCodeConverterTest {

    @Test
    public void fromLanguageCodeEN() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("English", converter.fromLanguageCode("en"));
    }

    @Test
    public void fromLanguageCodeAB() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("Abkhazian", converter.fromLanguageCode("ab"));
    }

    @Test
    public void fromLanguageCodeAllLoaded() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals(184, converter.getNumLanguages());
    }

    @Test
    public void fromLanguageCode() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("en", converter.fromLanguage("English"));
    }

    @Test
    public void fromLanguageCodeNuosu() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("ii", converter.fromLanguage("Nuosu"));
    }

    @Test
    public void fromLanguageCodetw() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("zh-tw", converter.fromLanguage("Chinese (Taiwan)"));
    }

    @Test
    public void fromLanguageCode1() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("Zulu", converter.fromLanguageCode("zu"));
    }

    @Test
    public void fromLanguageCodezhtw() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("Twi", converter.fromLanguageCode("tw"));
    }
}