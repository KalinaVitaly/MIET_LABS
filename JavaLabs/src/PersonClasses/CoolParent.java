package PersonClasses;

import PersonClasses.Person;

public class CoolParent extends Person {
    CoolParent (String _name, String _surname, String _patronymic,
             boolean _sex, int _cash, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _cash, _age);
    }
    @Override
    public void CreatePair() {

    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " + super.age + " " + super.sex + " " + super.cash + "\n";
    }
}
