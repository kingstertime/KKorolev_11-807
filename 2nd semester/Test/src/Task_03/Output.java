package Task_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Output extends Thread{
    Character     c;
    Char charContainer;
    File out;

    FileOutputStream fileOutputStream;

    public Output(Char c, File out) throws FileNotFoundException {
        this.charContainer = c;
        this.out = out;
        fileOutputStream = new FileOutputStream(out);
    }

}
