/*
pereda4a locala
ne tolko ru-en
 */

import javafx.print.Printer;
import javafx.scene.transform.Translate;

import java.io.IOException;
import java.util.Locale;

public class PrinterTranslation implements Printer<String> {
    public Translate print(String s, Locale locale) {
        try {
            return Translate.translate(locale.getLanguage(), s);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
