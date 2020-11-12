package PersonClasses;

import PersonClasses.Person;
import PersonClasses.CoolParent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Botanist extends Person  implements Serializable {
    private int average_mark;
    private CoolParent parent;

    public Botanist(String _name, String _surname, String _patronymic,
                    boolean _sex, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _age);
        average_mark = _average_mark;
    }

    public  Botanist() {
        super();
    }
    @Override
    public void CreatePair(ArrayList<Person> coolparents) {
        for(Person i : coolparents) {
            if (!i.has_pair && i instanceof CoolParent && Math.pow(10, average_mark) == ((CoolParent)i).getCash()) {
                super.has_pair = true;
                parent = new CoolParent();
                parent = (CoolParent) i;
                ((CoolParent) i).setBotanist(this);
                ((CoolParent) i).has_pair = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " +
                super.age + " " + super.sex + " " + average_mark + " " + super.has_pair + "\n";
    }
    @Override
    public void setData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        super.name = in.nextLine();
        System.out.println("Enter your surname");
        super.surname = in.nextLine();
        System.out.println("Enter your patronymic");
        super.patronymic = in.nextLine();
        System.out.println("Enter your age");
        super.age = in.nextInt();
        System.out.println("Enter your sex");
        super.sex = in.nextBoolean();
        System.out.println("Enter your average mark");
        average_mark = in.nextInt();
    }

    public int getAverageMark() { return average_mark; }
    public void setCoolParent(CoolParent _parent) { parent = _parent; }
}
