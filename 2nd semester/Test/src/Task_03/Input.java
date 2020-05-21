package Task_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Input {
    Character c;
    Char charContainer;
    File in;

    FileInputStream fileInputStream;

    public Input(Char c, File in) throws FileNotFoundException {
        this.charContainer = c;
        this.in = in;
        fileInputStream = new FileInputStream(in);
    }


    public void start() {
        while (Task_03.running) {
            System.out.println("in");
            synchronized (charContainer) {




            }
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }
}
