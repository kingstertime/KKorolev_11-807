package Task_02;

import java.util.List;

public class Raccoon {
    String name;
    int age;

    public Raccoon (String name, int age){
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Raccoon)){
            return false;
        }
        if (this == obj) {
            return true;
        }

        Raccoon raccoon = (Raccoon) obj;
        return this.getName().equals(raccoon.name) && this.getAge() == raccoon.getAge();
    }


    public int compareTo(Raccoon raccoonToAdd) {
        return this.age - raccoonToAdd.age;

    }

    @Override
    public String toString() {
        return "Raccoon{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
