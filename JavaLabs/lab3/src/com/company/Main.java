package com.company;

import PersonClasses.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
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

        Scanner in = new Scanner(System.in);
        Demostration d = new Demostration();
        d.add(student1);
        d.add(student2);
        d.add(student3);
        d.add(student4);
        d.add(botanist1);
        d.add(botanist2);
        d.add(botanist3);
        d.add(botanist4);
        d.add(coolParent1);
        d.add(coolParent2);
        d.add(coolParent3);
        d.add(coolParent4);
        d.add(parent1);
        d.add(parent2);
        d.add(parent3);
        d.add(parent4);

        while (true) {
            d.MainMenuDisplay();
            int choose = in.nextInt();
            d.Processing(choose);
        }
    }
}
