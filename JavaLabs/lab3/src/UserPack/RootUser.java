package UserPack;

import java.io.Serializable;
import java.util.ArrayList;

public class RootUser extends User implements Serializable {
    boolean debug;
    boolean auto_test;

    public RootUser() {
        super();
        addDebug();
        addAutoTest();
    }

    public void removeDebug() {
        if (main_menu.contains("Debug")){
            main_menu.remove("Debug");
            main_menu.remove("Delete debug");
            main_menu.add("Add debug");
            debug = false;
        }
    }

    public void removeAutoTest() {
        if (!main_menu.contains("Auto test")){
            main_menu.remove("Auto test");
            main_menu.remove("Delete auto test");
            main_menu.add("Add auto test");
            auto_test = false;
        }
    }

    public void addDebug() {
        if (!main_menu.contains("Debug")){
            main_menu.remove("Add debug");
            main_menu.add("Debug");
            main_menu.add("Delete debug");
            debug = true;
        }
    }

    public void addAutoTest() {
        if (!main_menu.contains("Auto test")){
            main_menu.remove("Add auto test");
            main_menu.add("Auto test");
            main_menu.add("Delete auto test");
            auto_test = true;
        }
    }

    @Override
    public ArrayList<String> getMenu() {
        return main_menu;
    }
}
