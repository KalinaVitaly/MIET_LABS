package com.company;

import PersonClasses.*;
import Managment.FileManager;
import java.util.ArrayList;
import java.util.Date;

public class Demonstration {
    private ArrayList<Person> people;
    private Date date;
    private ArrayList<String> activity_history;
    private final String filename_persons;
    private final String file_activity_history;
    private String[] main_menu = new String[] {
            "Add Botanist\n",
            "Add Student\n",
            "Add Parent\n",
            "Add CoolParent\n",
            "Create pairs student and parent\n",
            "Create pairs botanist and cool parent\n",
            "Print all information\n",
            "Save all on File\n",
            "Read all from file\n",
            "Get history\n"
    };

    public Demonstration() {
        people = new ArrayList<Person>();
        activity_history = new ArrayList<String>();
        filename_persons = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/DataBase";
        file_activity_history = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/DataBaseActivityHistory";
        date = new Date();
    }

    public void add(Person person) {
        people.add(person);
        System.out.print("Add: " + person.toString());
    }

    public void MainMenuDisplay(boolean user_enter) {
        if (user_enter) {
            int number = 1;
            System.out.println("-----MENU-----");
            for(String i : main_menu) {
                System.out.print(number + ") " + i);
                ++number;
            }
            System.out.println("--------------");
        }
        else {
            System.out.println("-----MENU-----");
            System.out.println("1) Sign Up");
            System.out.println("2) Sign In");
            System.out.println("--------------");
        }
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
        else if (_choose == 8) {
            FileManager.Save(people, filename_persons );
        }
        else if (_choose == 9) {
            people = FileManager.Load(filename_persons );
        }
        else if (_choose == 10) {
            PrintHistoryActivity();
        }

        if (_choose >= 1 && _choose <= 9) {
            activity_history.add(date.toString() + "\t" + main_menu[_choose]);
        }
        else {
            activity_history.add(date.toString() + "\t" + "Error input " + _choose + "\n");
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

    void PrintHistoryActivity() {
        for (String i : activity_history) {
            System.out.print(i);
        }
    }

    void Print() {
        for (Person i : people) {
            System.out.print(i.toString());
        }
    }
}
