package Managment;

import java.util.ArrayList;
import PersonClasses.*;
import java.io.*;
import java.io.FileNotFoundException;

public class FileManager {
    public FileManager() {}

    public static <T> void Save(T value, String path) {
        if (CreateFile(path)) {
            try {
                FileOutputStream f = new FileOutputStream(new File(path));
                ObjectOutputStream o = new ObjectOutputStream(f);
                // Write objects to file
                o.writeObject(value);
                o.close();
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static <T> ArrayList<T> Load(String path) {
        ArrayList<T> value = null;
        try {
            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            value = (ArrayList) oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "hui1");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "hui2");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + "hui3");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + "hui4");
        }
        return value;
    }

    private static boolean CreateFile(String path) {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                return true;
            } else {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
    }
}
