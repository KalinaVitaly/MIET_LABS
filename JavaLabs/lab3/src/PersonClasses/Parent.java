package PersonClasses;

import PersonClasses.Person;
import PersonClasses.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Parent extends Person implements Serializable {
    private Student student;

    public Parent(String _name, String _surname, String _patronymic,
                  boolean _sex, int _age) {
        super(_name, _surname, _patronymic, _sex, _age);
    }

    public Parent() {
        super();
    }

    @Override
    public void CreatePair(ArrayList<Person>  students) {
        for(Person i : students) {
            if (!i.has_pair && i instanceof Student && i.getPatronymic().equals(super.name)) {
                super.has_pair = true;
                student = new Student();
                student = (Student) i;
                ((Student) i).setParent(this);
                ((Student) i).has_pair = true;
            }
        }
    }

    @Override
    public void setData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        super.name = in.nextLine();
        System.out.println("Enter your surname");
        super.surname = in.nextLine();
        System.out.println("Enter your patronymic");
        super.patronymic = in.nextLine();
        System.out.println("Enter your age");
        super.age = in.nextInt();
        System.out.println("Enter your sex");
        super.sex = in.nextBoolean();
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " +
                super.age + " " + super.sex + " " + super.has_pair + "\n";
    }

    public void setStudent(Student _student) {student = _student;}
}
