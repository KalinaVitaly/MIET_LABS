package UserPack;

import Managment.FileManager;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
    protected ArrayList<String> main_menu;
    protected String login;
    protected String password;

    public User() {
        main_menu = new ArrayList<String>();
        main_menu.add("Add Botanist");
        main_menu.add("Add Student");
        main_menu.add("Add Parent");
        main_menu.add("Add CoolParent");
        main_menu.add("Create pairs student and parent");
        main_menu.add("Create pairs botanist and cool parent");
        main_menu.add("Print all information");
        main_menu.add("Save all on file");
        main_menu.add("Read all from file");
        main_menu.add("Exit");
    }

    public abstract ArrayList<String> getMenu();

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
