package PersonClasses;

import PersonClasses.Person;
import PersonClasses.Botanist;

public class CoolParent extends Person {
    private Botanist botanist;
    private int cash;

    CoolParent (String _name, String _surname, String _patronymic,
             boolean _sex, int _age, int _average_mark) {
        super(_name, _surname, _patronymic, _sex, _age);
    }
    @Override
    public void CreatePair(Person ...botanists) {
        for(Person i : botanists) {
            if (!i.has_pair && ((Botanist)i).getAverageMark() == Math.log10(cash)) {
                super.has_pair = true;
                botanist = (Botanist) i;
                ((Botanist) i).setCoolParent(this);
                ((Botanist) i).has_pair = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.name + " " + super.surname + " " + super.patronymic + " " + super.age + " " + super.sex + "\n";
    }

    public int getCash() { return cash; }
    public void setBotanist(Botanist _botanist) { botanist = _botanist; }
}
