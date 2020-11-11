package UserPack;

import java.util.ArrayList;

public abstract class User {
    protected ArrayList<String> main_menu;
    protected String login;
    protected String password;
    protected static String file_verification;

    public User() {
        file_verification = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/Verification";
        main_menu = new ArrayList<String>();
        main_menu.add("Add Botanist\n");
        main_menu.add("Add Student\n");
        main_menu.add("Add Parent\n");
        main_menu.add("Add CoolParent\n");
        main_menu.add("Create pairs student and parent\n");
        main_menu.add("Create pairs botanist and cool parent\n");
        main_menu.add("Print all information\n");
        main_menu.add("Save all on File\n");
        main_menu.add("Read all from file\n");
        main_menu.add("Print history activity\n");
        main_menu.add("Print history errors\n");
        main_menu.add("Exit\n");
    }

    public abstract ArrayList<String> getMenu();
    public static String getFileVerification() {
        return file_verification;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String _login) {
        login = _login;
    }
    public void setPassword(String _password) {
        password = _password;
    }
}
