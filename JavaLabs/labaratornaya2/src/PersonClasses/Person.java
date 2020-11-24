package PersonClasses;

import java.util.ArrayList;

public abstract class Person {
    protected int age;
    protected String name;
    protected String surname;
    protected String patronymic;
    protected boolean sex;
    protected boolean has_pair;

    Person(String _name, String _surname, String _patronymic,
           boolean _sex, int _age) {
        age = _age;
        name = _name;
        surname = _surname;
        patronymic = _patronymic;
        sex = _sex;
        has_pair = false;
    }

    public Person() {}

    public abstract void CreatePair(ArrayList<Person> person);
    public abstract String toString();

    public int getAge() {return age;}
    public boolean getSex() {return sex;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getPatronymic() {return patronymic;}
    public boolean getHasPair() {return has_pair;}
}