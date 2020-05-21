package com.company;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Азат", 18, 4, 7);
        Student st2 = new Student("Булат", 17, 5, 6);

        AgeComparator bgc = new AgeComparator();
        NameComparator bnc = new NameComparator();
        AcademicPerformanceComparator apc = new AcademicPerformanceComparator();

        SortedStudentGroup ssg = new SortedStudentGroup(4, bnc);
        ssg.add(st1);
        ssg.add(st2);

        SortedStudentGroup ssg1 = new SortedStudentGroup(4, bgc);
        ssg1.add(st1);
        ssg1.add(st2);

        SortedStudentGroup ssg2 = new SortedStudentGroup(4, apc);
        ssg2.add(st1);
        ssg2.add(st2);

        ssg.get();
        ssg1.get();
        ssg2.get();
    }
}
