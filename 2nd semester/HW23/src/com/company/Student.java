package com.company;

public class Student {

   String name;
   int age;
   int academicPerformance;
   int numberOfGroup;

    public Student (String name, int age, int academicPerformance, int numberOfGroup ){
        this.name = name;
        this.age = age;
        this.academicPerformance = academicPerformance;
        this.numberOfGroup = numberOfGroup;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAcademicPerformance() {
        return academicPerformance;
    }

    public int getNumberOfGroup(){
        return numberOfGroup;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)){
            return false;
        }
        if (this == obj) {
            return true;
        }

        Student st = (Student) obj;
        return this.getNumberOfGroup() == st.getNumberOfGroup() && this.getName().equals(st.name) && this.getAge() == st.getAge();
    }


    public int compareTo(Student studentToAdd) {
        return this.age - studentToAdd.age;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", academicPerformance=" + academicPerformance +
                ", numberOfGroup=" + numberOfGroup +
                '}';
    }
}
