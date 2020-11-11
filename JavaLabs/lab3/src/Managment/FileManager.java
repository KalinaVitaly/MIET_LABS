package Managment;

import java.util.ArrayList;
import PersonClasses.*;
import java.io.*;

public class FileManager {
    public FileManager() {}

    public static <T> void Save(ArrayList<T> persons, String filename) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(persons);
            System.out.println("File has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static <T> ArrayList<T> Load(String filename) {
        ArrayList<T> persons = new ArrayList<T>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            persons = ((ArrayList<T>)ois.readObject());
            for(T p : persons)
                System.out.printf(p.toString());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return persons;
    }
}
