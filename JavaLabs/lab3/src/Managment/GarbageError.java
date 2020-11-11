package Managment;

import java.util.ArrayList;
import java.util.Date;

public class GarbageError {
    private static ArrayList<String> error_history;
    private static String file_error = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/Log";
    private static Date date = new Date();

    public static void addError(String _error) {
        error_history.add(date.toString() + "\t" + "Error input " + _error + "\n");
    }

    public static ArrayList<String> getErrorHistory() {
        return error_history;
    }
    public static String getFileError() {
        return file_error;
    }
}
