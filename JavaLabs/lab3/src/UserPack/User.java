package UserPack;

import java.util.ArrayList;

public abstract class User {
    protected ArrayList<String> main_menu;
    protected ArrayList<String> menu_for_current_user;
    protected String login;
    protected String password;
    protected static String file_verification;



    public User() {
        file_verification = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/Verification";
        menu_for_current_user = new ArrayList<String>();
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
        main_menu.add("Read all from file\n");
        main_menu.add("Get history\n");
        main_menu.add("Exit");
    }
}
