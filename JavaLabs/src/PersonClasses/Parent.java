package PersonClasses;

import PersonClasses.Person;
import PersonClasses.Student;

public class Parent extends Person {
    private Student student;

    public Parent(String _name, String _surname, String _patronymic,
                  boolean _sex, int _age) {
        super(_name, _surname, _patronymic, _sex, _age);
    }

    public Parent() {
        super();
    }
    @Override
    public void CreatePair(Person ...students) {
        for(Person i : students) {
            if (!i.has_pair && i.getPatronymic().equals(super.name)) {
                super.has_pair = true;
                student = new Student();
                student = (Student) i;
                ((Student) i).setParent(this);
                ((Student) i).has_pair = true;
            }
        }
    }

    @Override
    public String toString() {
      return "Pair:" + super.name + " " + super.surname + " " + super.patronymic + " " +
                super.age + " " + super.sex + " " + "\n" + student.getName() + "\n";
    }

    public void setStudent(Student _student) {student = _student;}
}
