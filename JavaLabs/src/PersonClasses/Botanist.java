package PersonClasses;

import PersonClasses.Person;
import PersonClasses.CoolParent;

public class Botanist extends Person {
    private int average_mark;
    private CoolParent parent;

    Botanist(String _name, String _surname, String _patronymic,
            boolean _sex, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _age);
        average_mark = _average_mark;
    }
    @Override
    public void CreatePair(Person ...coolparents) {
        for(Person i : coolparents) {
            if (!i.has_pair && Math.pow(10, average_mark) == ((CoolParent)i).getCash()) {
                super.has_pair = true;
                parent = (CoolParent) i;
                ((CoolParent) i).setBotanist(this);
                ((CoolParent) i).has_pair = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " + super.age + " " + super.sex + " " + average_mark + "\n";
    }

    public int getAverageMark() { return average_mark; }
    public void setCoolParent(CoolParent _parent) { parent = _parent; }
}
