package com.company;

import java.util.Comparator;

public class SortedStudentGroup {
    Student[] st;
    int n = 0;
    Comparator<Student> comparator;
    private int amount = 0;

    public SortedStudentGroup(int size) {
        this.st = new Student[size];
    }

    public SortedStudentGroup(int size, Comparator<Student> comparator) {
        this(size);
        this.comparator = comparator;
    }

    public void add (Student studentToAdd) {
        int c = 0;
        if (comparator == null) {
            while (c < amount && st[c].compareTo(studentToAdd) < 0) {
                c++;
            }
        }
        else {
            while (c < amount &&
                    comparator.compare(st[c], studentToAdd) < 0) {
                c++;
            }
        }
        for (int i = amount - 1; i >= c; i--) {
            st[i + 1] = st[i];
        }
        //вставляем на нужное место
        st[c] = studentToAdd;
        amount++;
    }

    public void get () {
        for (int i = 0; i < amount; i++) {
            System.out.println(st[i].toString());
        }
    }
}
