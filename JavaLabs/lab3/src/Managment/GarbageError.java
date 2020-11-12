package Managment;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import Managment.FileManager;

public class GarbageError {
    private static ArrayList<String> error_history = new ArrayList<String>();
    private static String file_error = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/Log";
    private static Date date = new Date();

    public static void addError(String _error) {
        error_history.add(date.toString() + "\t" + "Error input " + _error + "\n");
    }

    public static void Save() {
        FileManager.Save(error_history, file_error);
    }

    public static void Load() {
        error_history = FileManager.Load(file_error);
    }

    public static ArrayList<String> getErrorHistory() {
        return error_history;
    }
    public static String getFileError() {
        return file_error;
    }

    public static void PrintHistoryErrors() {
        if (!error_history.equals(null)) {
            for(String i : error_history) {
                System.out.print(i);
            }
        }
    }
}
