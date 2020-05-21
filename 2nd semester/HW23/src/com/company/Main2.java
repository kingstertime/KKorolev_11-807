package com.company;

import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        Student st1 = new Student("Азат", 18, 4, 7);
        Student st2 = new Student("Булат", 17, 5, 6);

        Comparator<Student> byNameComparator =
                (o1, o2) -> o1.compareTo(o2);

        Comparator<Student> byAcademicPerformanceComparator =
                (o1, o2) -> o1.getAcademicPerformance() -o2.getAcademicPerformance();

        Comparator<Student> byAgeComparator =
                (o1, o2) -> o1.getAge() - o2.getAge();

        SortedStudentGroup ssg = new SortedStudentGroup(4, byNameComparator);
        ssg.add(st1);
        ssg.add(st2);

        SortedStudentGroup ssg1 = new SortedStudentGroup(4, byAgeComparator);
        ssg1.add(st1);
        ssg1.add(st2);

        SortedStudentGroup ssg2 = new SortedStudentGroup(4, byAcademicPerformanceComparator);
        ssg2.add(st1);
        ssg2.add(st2);

        ssg.get();
        ssg1.get();
        ssg2.get();
    }
}
