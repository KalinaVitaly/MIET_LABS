package PersonClasses;

import PersonClasses.Person;
import PersonClasses.Parent;

public class Student extends Person{

    private int average_mark;
    private Parent parent;

    Student(String _name, String _surname, String _patronymic,
            boolean _sex, int _cash, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _cash, _age);
        average_mark = _average_mark;
    }
    @Override
    public void CreatePair(Person ...parents) {
        for(Person i : parents) {
            if (!i.has_pair && i.getName() == super.patronymic) {
                super.has_pair = true;
                parent = (Parent)i;
                //here
            }
        }
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " + super.age + " " + super.sex + " " + average_mark + " " + super.cash + "\n";
    }
}
