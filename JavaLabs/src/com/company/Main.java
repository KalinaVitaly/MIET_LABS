package com.company;

import PersonClasses.Botanist;
import PersonClasses.Parent;
import PersonClasses.CoolParent;
import PersonClasses.Student;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Andrew", "Monkey", "Roma", true, 34, 4);
        Student student2 = new Student("Israel", "Monkey", "Vardy", true, 34, 4);
        Student student3 = new Student("John", "Monkey", "Ahroma", true, 34, 4);
        Student student4 = new Student("Jeimi", "Monkey", "Luicy", true, 34, 4);
        Botanist botanist1 = new Botanist("Alan", "Turing", "Sancho", true, 14, 5);
        Botanist botanist2 = new Botanist("Elvin", "Rasberry", "Scho", true, 14, 4);
        Botanist botanist3 = new Botanist("John", "Nash", "Larson", true, 14, 3);
        Botanist botanist4 = new Botanist("Salim", "NoTuring", "Sancho", true, 14, 2);
        CoolParent coolParent1 = new CoolParent("Salim", "NoTuring", "Sancho", true, 28, 100000);
        CoolParent coolParent2 = new CoolParent("Grisha", "Nuing", "AsapSancho", true, 29, 10000);
        CoolParent coolParent3 = new CoolParent("Morgenshtern", "Aguero", "Maradonovich", true, 34, 1000);
        CoolParent coolParent4 = new CoolParent("Salim", "NoTuring", "Sancho", true, 19, 100);
        Parent parent1 = new Parent("Roma", "Monkey", "Assalam", true, 68);
        Parent parent2 = new Parent("Vardy", "Akimov", "VAssalam", true, 68);
        Parent parent3 = new Parent("Ahroma", "Salimov", "XAssalam", true, 68);
        Parent parent4 = new Parent("Luicy", "Mansurov", "PAssalam", true, 68);

        student1.CreatePair(parent1, parent2, parent3, parent4);
        student2.CreatePair(parent1, parent2, parent3, parent4);
        parent3.CreatePair(student1, student2, student3, student4);
        parent4.CreatePair(student1, student2, student3, student4);
        botanist1.CreatePair(coolParent1, coolParent2, coolParent3, coolParent4);
        botanist2.CreatePair(coolParent1, coolParent2, coolParent3, coolParent4);
        coolParent3.CreatePair(botanist1, botanist2, botanist3, botanist4);
        coolParent4.CreatePair(botanist1, botanist2, botanist3, botanist4);

        System.out.print(student1.toString() + student2.toString() +
        student3.toString() + student4.toString() + botanist1.toString() +
        botanist2.toString() + botanist3.toString() +
        botanist4.toString() +coolParent1.toString() +coolParent2.toString() +
        coolParent3.toString() + coolParent4.toString() + parent1.toString() +
        parent2.toString() + parent3.toString() + parent4.toString());
    }
}
