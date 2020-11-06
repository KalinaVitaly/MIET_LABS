package PersonClasses;

import PersonClasses.Person;

public class Botanist extends Person {
    private int average_mark;

    Botanist(String _name, String _surname, String _patronymic,
            boolean _sex, int _cash, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _cash, _age);
        average_mark = _average_mark;
    }
    @Override
    public void CreatePair(Person ...parents) {

    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " + super.age + " " + super.sex + " " + average_mark + " " + super.cash + "\n";
    }
}
