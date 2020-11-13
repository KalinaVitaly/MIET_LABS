package UserPack;

import java.io.Serializable;
import java.util.ArrayList;

public class RootUser extends User implements Serializable {
    boolean debug;
    boolean auto_test;

    public RootUser() {
        super();
        debug = false;
        auto_test = false;
    }

    public void removeDebug() {
        if (main_menu.contains("Debug\n")){
            main_menu.remove("Debug\n");
            debug = false;
        }
    }

    public void removeAutoTest() {
        if (!main_menu.contains("Auto test\n")){
            main_menu.remove("Auto test\n");
            auto_test = false;
        }
    }

    public void addDebug() {
        if (!main_menu.contains("Debug\n")){
            main_menu.add("Debug\n");
            debug = true;
        }
    }

    public void addAutoTest() {
        if (!main_menu.contains("Auto test\n")){
            main_menu.add("Auto test\n");
            auto_test = true;
        }
    }

    @Override
    public ArrayList<String> getMenu() {
        return main_menu;
    }
}
