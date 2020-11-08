package PersonClasses;

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

    public abstract void CreatePair(Person ...parents);
    public abstract String toString();

    public int getAge() {return age;}
    public boolean getSex() {return sex;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getPatronymic() {return patronymic;}
}
