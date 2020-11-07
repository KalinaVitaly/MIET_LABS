package PersonClasses;

import PersonClasses.Person;
import PersonClasses.Student;

public class Parent extends Person {
    private Student student;

    Parent (String _name, String _surname, String _patronymic,
                boolean _sex, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _age);
    }
    @Override
    public void CreatePair(Person ...students) {
        for(Person i : students) {
            if (!i.has_pair && i.getPatronymic().equals(super.name)) {
                super.has_pair = true;
                student = (Student) i;
                ((Student) i).setParent(this);
                ((Student) i).has_pair = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " + super.age + " " + super.sex + " " + "\n";
    }

    public void setStudent(Student _student) {student = _student;}
}
