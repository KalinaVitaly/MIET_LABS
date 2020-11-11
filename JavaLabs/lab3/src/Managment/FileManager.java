package Managment;

import java.util.ArrayList;
import PersonClasses.*;
import java.io.*;

public class FileManager {
    public FileManager() {}

    public static void Save(ArrayList<Person> persons, String filename) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(persons);
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Person> Load(String filename) {
        ArrayList<Person> persons = new ArrayList<Person>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            persons = ((ArrayList<Person>)ois.readObject());
            for(Person p : persons)
                System.out.printf(p.toString());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return persons;
    }
}
