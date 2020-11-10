package com.company;

import PersonClasses.*;

import java.util.ArrayList;

public class Demostration {
    public ArrayList<Person> people = new ArrayList<Person>();

    public Demostration() {}

    public void add(Person person) {
        people.add(person);
        System.out.print("Add: " + person.toString());
    }

    public void MainMenuDisplay() {
        System.out.println("-----MENU-----");
        System.out.println("1) Add Botanist");
        System.out.println("2) Add Student");
        System.out.println("3) Add Parent");
        System.out.println("4) Add CoolParent");
        System.out.println("5) Create pairs student and parent");
        System.out.println("6) Create pairs botanist and cool parent");
        System.out.println("7) Print all information");
        System.out.println("--------------");
    }

    public void Processing(int _choose) {
        if (_choose >= 1 && _choose <= 4) {
            Person botanist;
            if (_choose == 1) {
                botanist = new Botanist();
            }
            else if (_choose == 2) {
                botanist = new Student();
            }
            else if (_choose == 3) {
                botanist = new Parent();
            }
            else {
                botanist = new CoolParent();
            }
            botanist.setData();
            add(botanist);
        }
        else if (_choose == 5) {
            CreatePairsStudentsAndParents();
        }
        else if (_choose == 6) {
            CreatePairsBotanistsAndCoolParents();
        }
        else if (_choose == 7) {
            Print();
        }
    }

    void CreatePairsStudentsAndParents() {
        for(Person i : people) {
            if (i instanceof Student && !i.getHasPair()) {
                ((Student)i).CreatePair(people);
            }
        }
    }
    void CreatePairsBotanistsAndCoolParents() {
        for(Person i : people) {
            if (i instanceof Botanist && !i.getHasPair()) {
                ((Botanist)i).CreatePair(people);
            }
        }
    }

    void Print() {
        for (Person i : people) {
            System.out.print(i.toString());
        }
    }
}
