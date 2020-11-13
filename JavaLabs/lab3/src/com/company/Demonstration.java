package com.company;

import PersonClasses.*;
import Managment.FileManager;
import UserPack.*;
import Managment.MyLogger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Demonstration {
    private ArrayList<Person> people;
    private ArrayList<User> users;
    private final String filename_persons;
    private final String file_verification;

    public Demonstration() {
        people = new ArrayList<Person>();
        users = new ArrayList<User>();
        MyLogger.Setup("Logger.txt");
        MyLogger.log(MyLogger.LogLevel.INFO, "Demonstration");
        filename_persons = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/DataBase";
        file_verification = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/DataBase2";
    }

    public void FirstMainMenuDisplay() {
        System.out.println("-----MENU-----");
        System.out.println("1) Sign Up");
        System.out.println("2) Sign In");
        System.out.println("--------------");
    }

    public User ProccessingFirst(String _choose) {
        System.out.println(users.size());
        Scanner in = new Scanner(System.in);
        User nuser = null;
        if (_choose.equals("Sign In")) {
            //Registration
            System.out.println("Enter Yes if root user else No:\t");
            if (in.nextLine().equals("Yes")) {
                nuser = new RootUser();
            }
            else {
                nuser = new OperatorUser();
            }
            System.out.println("Enter login:\t");
            String input = in.nextLine();
            nuser.setLogin(input);
            System.out.println("Enter password:\t");
            input = in.nextLine();
            nuser.setPassword(input);
            users.add(nuser);
            return nuser;
        }
        else if(_choose.equals("Sign Up")) {
            System.out.println("Enter login:\t");
            String input1 = in.nextLine();
            System.out.println("Enter password:\t");
            String input2 = in.nextLine();
            for(User i : users) {
                if (i.getPassword().equals(input2) && i.getLogin().equals(input1)) {
                    System.out.println("Hello " + input1);
                    if (i instanceof RootUser) {
                        nuser = new RootUser();
                    }
                    else {
                        nuser = new OperatorUser();
                    }
                    nuser = i;
                }
            }
        }
        MyLogger.log(MyLogger.LogLevel.INFO, "Processing " + _choose);
        return nuser;
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
                PrintAllPersonInformation();
            }
            else if (_choose.equals("Save all on File")) {
                FileManager.Save(people, Person.getFilenamePersons());
            }
            else if (_choose.equals("Read all from file")) {
                people = FileManager.Load(Person.getFilenamePersons());
            }
            else if (_choose.equals("Exit")) {
                ExitProgram();
            }
            else if (_choose.equals("Add debug")) {
                user = (RootUser)user;
                ((RootUser) user).addDebug();
            }
            else if(_choose.equals("Add auto test")) {
                user = (RootUser)user;
                ((RootUser) user).addAutoTest();
            }
            else if (_choose.equals("Delete auto test")) {
                user = (RootUser)user;
                ((RootUser) user).removeAutoTest();
            }
            else if (_choose.equals("Delete debug")) {
                user = (RootUser)user;
                ((RootUser) user).removeDebug();
            }
        }
        MyLogger.log(MyLogger.LogLevel.INFO, "Processing " + _choose);
    }

    public void PrintAllPersonInformation() {
        for (Person i : people) {
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

    public void PrintUsersCount() {
        System.out.println(users.size());
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

    void PrintPerson() {
        for(Person i : people) {
            System.out.print(i.toString());
        }
    }

    public void add(Person person) {
        people.add(person);
        System.out.print("Add: " + person.toString());
    }

    public void Setup() {
        people = FileManager.<Person>Load(filename_persons);
        users = FileManager.<User>Load(file_verification);
        MyLogger.log(MyLogger.LogLevel.INFO, "Setup function");
    }
    public void ExitProgram() {
        FileManager.<ArrayList<Person>>Save(people, filename_persons);
        FileManager.<ArrayList<User>>Save(users, file_verification);
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
