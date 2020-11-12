package Managment;

import java.util.ArrayList;
import PersonClasses.*;
import java.io.*;

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

    public static <T> T Load(String path) {
        T value = null;
        try {
            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            value = (T) oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
