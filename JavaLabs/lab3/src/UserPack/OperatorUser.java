package UserPack;

import java.io.Serializable;
import java.util.ArrayList;

public class OperatorUser extends User implements Serializable {

    @Override
    public ArrayList<String> getMenu() {
        return main_menu;
    }
}
