package PersonClasses;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Person implements Serializable {
    protected int age;
    protected String name;
    protected String surname;
    protected String patronymic;
    protected boolean sex;
    protected boolean has_pair;
    protected static String filename_persons;

    Person(String _name, String _surname, String _patronymic,
           boolean _sex, int _age) {
        filename_persons = "/home/vitaly/Документы/MIET_LABS/JavaLabs/lab3/DataBase";
        age = _age;
        name = _name;
        surname = _surname;
        patronymic = _patronymic;
        sex = _sex;
        has_pair = false;
    }

    public Person() {}

    public abstract void CreatePair(ArrayList<Person> person);
    public abstract void setData();
    public abstract String toString();

    public int getAge() {return age;}
    public boolean getSex() {return sex;}
    public boolean getHasPair() {return has_pair;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getPatronymic() {return patronymic;}
    public static String getFilenamePersons() {return filename_persons;}
}
