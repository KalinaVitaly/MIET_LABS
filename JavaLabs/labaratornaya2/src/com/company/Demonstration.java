package com.company;

import PersonClasses.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Demonstration {
    private ArrayList<Person> people;

    public Demonstration() {
        people = new ArrayList<Person>();
    }

    void PrintPerson() {
        for(Person i : people) {
            System.out.print(i.toString());
        }
    }

    public void CreatePairsStudentsAndParents() {
        for(Person i : people) {
            if (i instanceof Student && !i.getHasPair()) {
                ((Student)i).CreatePair(people);
            }
        }
    }
    public void CreatePairsBotanistsAndCoolParents() {
        for(Person i : people) {
            if (i instanceof Botanist && !i.getHasPair()) {
                ((Botanist)i).CreatePair(people);
            }
        }
    }


    public void addPerson() {
        people.add(new Student("Andrew", "Monkey", "Roma", true, 34, 4));
        people.add(new Student("Israel", "Monkey", "Vardy", true, 34, 4));
        people.add(new Student("John", "Monkey", "Ahroma", true, 34, 4));
        people.add(new Student("Jeimi", "Monkey", "Luicy", true, 34, 4));
        people.add(new Botanist("Alan", "Turing", "Sancho", true, 14, 5));
        people.add(new Botanist("Elvin", "Rasberry", "Scho", true, 14, 4));
        people.add(new Botanist("John", "Nash", "Larson", true, 14, 3));
        people.add(new Botanist("Salim", "NoTuring", "Sancho", true, 14, 2));
        people.add(new CoolParent("Salim", "NoTuring", "Sancho", true, 28, 100000));
        people.add(new CoolParent("Grisha", "Nuing", "AsapSancho", true, 29, 10000));
        people.add(new CoolParent("Morgenshtern", "Aguero", "Maradonovich", true, 34, 1000));
        people.add(new CoolParent("Salim", "NoTuring", "Sancho", true, 19, 100));
        people.add(new Parent("Roma", "Monkey", "Assalam", true, 68));
        people.add(new Parent("Vardy", "Akimov", "VAssalam", true, 68));
        people.add(new Parent("Ahroma", "Salimov", "XAssalam", true, 68));
        people.add(new Parent("Luicy", "Mansurov", "PAssalam", true, 68));
    }
}
