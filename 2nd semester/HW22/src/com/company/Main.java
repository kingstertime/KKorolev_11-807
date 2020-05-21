package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String text = new String("Япония — маленькая страна, расположившаяся на гористых островах. Некогда Япония веками пребывaала в изоляции от остальной части мира и всячески препятствовала проникновению в эти края европейцев и их культуры, но с тех пор много изменилось.");
        Scanner sc = new Scanner(text.replace(',', ' ').replace('.', ' ').replace('—',' '));
        String str;

        Map<String, Integer> m = new SimpleMap<>();


        while (sc.hasNext()) {
            str = sc.next();
            int n = 1;

            if (m.get(str) == (null)) {
                m.put(str, n);
            } else {
                m.put(str, m.get(str)+1);
            }
        }
        ((SimpleMap<String, Integer>) m).print();
    }
}
