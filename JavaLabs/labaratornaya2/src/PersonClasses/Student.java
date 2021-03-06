package PersonClasses;

import PersonClasses.Person;
import PersonClasses.Parent;

import java.util.ArrayList;

public class Student extends Person{
    private int average_mark;
    private Parent parent;

    public Student(String _name, String _surname, String _patronymic,
                   boolean _sex, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _age);
        average_mark = _average_mark;
    }

    public Student() {
        super();
    }
    @Override
    public void CreatePair(ArrayList<Person> parents) {
        for(Person i : parents) {
            if (!i.has_pair && i instanceof Parent && i.getName().equals(super.patronymic)) {
                super.has_pair = true;
                parent = new Parent();
                parent = (Parent)i;
                ((Parent) i).setStudent(this);
                ((Parent) i).has_pair = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " + super.age + " " +
                super.sex + " " + average_mark + " " + super.has_pair + "\n";
    }

    public void setParent(Parent _parent) { parent = _parent;}
}