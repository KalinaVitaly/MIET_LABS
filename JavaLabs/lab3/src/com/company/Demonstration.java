package com.company;

import Managment.GarbageError;
import PersonClasses.*;
import Managment.FileManager;
import UserPack.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Demonstration {
    private ArrayList<Person> people;
    private Date date;
    private ArrayList<String> activity_history;
    private final String file_activity_history;

    public Demonstration() {
        people = new ArrayList<Person>();
        activity_history = new ArrayList<String>();
        file_activity_history = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/DataBaseActivityHistory";
        date = new Date();
    }

    public void Setup() {
        activity_history = FileManager.Load(file_activity_history);
        people = FileManager.Load(Person.getFilenamePersons());
        GarbageError.Load();
    }

    public void add(Person person) {
        people.add(person);
        System.out.print("Add: " + person.toString());
    }

    public void FirstMainMenuDisplay() {
        System.out.println("-----MENU-----");
        System.out.println("1) Sign Up");
        System.out.println("2) Sign In");
        System.out.println("--------------");
    }
    public void SecondMainMenu(User user) {
        int number = 1;
        System.out.println("-----MENU-----");
        for(String i : user.getMenu()) {
            System.out.println(number + ") " + i);
            ++number;
        }
        System.out.println("--------------");
    }

    public User ProcessingFirst(ArrayList<User> users, int _choose) {
        Scanner in = new Scanner(System.in);
        if (_choose == 1) {
            User user;
            System.out.println("Enter Yes if root user else No:\t");
            if (in.nextLine().equals("Yes")) {
                user = new RootUser();
            }
            else {
                user = new OperatorUser();
            }
            System.out.println("Enter login:\t");
            String input = in.nextLine();
            user.setLogin(input);
            System.out.println("Enter password:\t");
            input = in.nextLine();
            user.setPassword(input);
            users.add(user);
            FileManager.Save(users, User.getFileVerification());
            activity_history.add(date.toString() + "\t" + _choose);
            return user;
        }
        else if (_choose == 2) {
            System.out.println("Enter login:\t");
            String input1 = in.nextLine();
            System.out.println("Enter password:\t");
            String input2 = in.nextLine();
            for(User i : users) {
                if (i.getPassword().equals(input2) && i.getLogin().equals(input1)) {
                    System.out.println("Hello " + input1);
                    return i;
                }
            }
            activity_history.add(date.toString() + "\t" + _choose);
        }
        else {
            GarbageError.addError("Incorrect choose: " + _choose);
        }
        return null;
    }

    public void Processing(User user, String _choose) {
        System.out.println(user.getMenu().contains(_choose));
        if (user.getMenu().contains(_choose)) {
            if (_choose.equals("Add Botanist")) {
                Botanist botanist = new Botanist();
                botanist.setData();
                people.add(botanist);
            }
            else if (_choose.equals("Add Student")) {
                Student student = new Student();
                student.setData();
                people.add(student);
            }
            else if (_choose.equals("Add Parent")) {
                Parent parent = new Parent();
                parent.setData();
                people.add(parent);
            }
            else if (_choose.equals("Add CoolParent")) {
                CoolParent coolParent = new CoolParent();
                coolParent.setData();
                people.add(coolParent);
            }
            else if (_choose.equals("Create pairs student and parent")) {
                CreatePairsStudentsAndParents();
            }
            else if (_choose.equals("Create pairs botanist and cool parent")) {
                CreatePairsBotanistsAndCoolParents();
            }
            else if (_choose.equals("Print all information")) {
                Print();
            }
            else if (_choose.equals("Save all on File")) {
                FileManager.Save(people, Person.getFilenamePersons());
            }
            else if (_choose.equals("Read all from file")) {
                people = FileManager.Load(Person.getFilenamePersons());
            }
            else if (_choose.equals("Print history activity")) {
                PrintHistoryActivity();
            }
            else if (_choose.equals("Print history errors")) {
                GarbageError.PrintHistoryErrors();
            }
            else if (_choose.equals("Exit")) {
                ExitProgram();
            }
            activity_history.add(date.toString() + "\t" + _choose);
        }
        else {
            GarbageError.addError("Incorrect choose: " + _choose);
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

    public void PrintHistoryActivity() {
        for (String i : activity_history) {
            System.out.println(i);
        }
    }

    public void Print() {
        for (Person i : people) {
            System.out.print(i.toString());
        }
    }

    public void ExitProgram() {
        FileManager.Save(GarbageError.getErrorHistory(), GarbageError.getFileError());
        FileManager.Save(activity_history, file_activity_history);
        GarbageError.Save();
    }
}
