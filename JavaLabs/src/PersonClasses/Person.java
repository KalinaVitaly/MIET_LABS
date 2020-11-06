package PersonClasses;

public abstract class Person {
    protected int age;
    protected int cash;
    protected String name;
    protected String surname;
    protected String patronymic;
    protected boolean sex;
    protected boolean has_pair;

    Person(String _name, String _surname, String _patronymic,
           boolean _sex, int _cash, int _age) {
        age = _age;
        cash = _cash;
        name = _name;
        surname = _surname;
        patronymic = _patronymic;
        sex = _sex;
        has_pair = false;
    }

    public abstract void CreatePair(Person ...parents);
    public abstract String toString();

    public int getAge() {return age;}
    public int getCash() {return cash;}
    public boolean getSex() {return sex;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getPatronymic() {return patronymic;}
}
