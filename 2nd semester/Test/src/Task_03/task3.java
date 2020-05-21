package Task_03;

import java.io.File;
import java.io.FileNotFoundException;

public class task3 {
    public static boolean running;

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("text1.txt");
        File file2 = new File("text2.txt");

        running = true;
        Char container = new Char(' ', false);

        Input inputThread = new Input(container, file1);
        Output outputThread = new Output(container, file2);

        inputThread.start();
        outputThread.start();

    }
}
