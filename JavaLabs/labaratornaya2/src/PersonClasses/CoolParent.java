package PersonClasses;

import PersonClasses.Person;
import PersonClasses.Botanist;

import java.util.ArrayList;

public class CoolParent extends Person {
    private Botanist botanist;
    private int cash;

    public CoolParent (String _name, String _surname, String _patronymic,
                       boolean _sex, int _age, int _cash) {
        super(_name, _surname, _patronymic, _sex, _age);
        cash = _cash;
    }

    public  CoolParent() {
        super();
    }
    @Override
    public void CreatePair(ArrayList<Person> botanists) {
        for(Person i : botanists) {
            if (!i.has_pair && i instanceof Botanist && ((Botanist)i).getAverageMark() == Math.log10(cash)) {
                super.has_pair = true;
                botanist = new Botanist();
                botanist = (Botanist) i;
                ((Botanist) i).setCoolParent(this);
                ((Botanist) i).has_pair = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " +
                super.age + " " + super.sex + " " + super.has_pair + "\n";
    }

    public int getCash() { return cash; }
    public void setBotanist(Botanist _botanist) { botanist = _botanist; }
}