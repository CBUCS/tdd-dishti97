import java.util.ArrayList;
import java.util.List;

//Representation for an ancestor tree
interface IAT {
    <R> R accept(IATVisitor<R> visito);

    //Append two lists
    List<String> List = new ArrayList();
    List<String> append(List<String> l);
}

//Unknown person
class Unknown implements IAT {
    Unknown() {
    }
    public <R> R accept(IATVisitor<R> visitor) {
        return visitor.visitUnknown(this);
    }
    //append two an unknown
    public List<String> append(List<String> l) {
        return l;
    }

}

//Representation for a person
class Person implements IAT {
    String name;
    int yob;
    boolean isMale;
    IAT mom;
    IAT dad;
    //Constructor
    Person(String name, int yob, boolean isMale, IAT mom, IAT dad) {
        this.name = name;
        this.yob = yob;
        this.isMale = isMale;
        this.mom = mom;
        this.dad = dad;
    }
    public <R> R accept(IATVisitor<R> visitor) {
        return visitor.visitPerson(this);
    }

    public java.util.List<String> append(java.util.List<String> l) {
        return null;
    }

    //append parent and children of tree
    public int addNode() {
        //
        return 0;
    }

}

interface IATVisitor<R> {
    R visitUnknown(Unknown u);
    R visitPerson(Person p);
}

//IAT Visitor that returns a list of the names of all people
class IATVisitGetNames implements IATVisitor<List<String>> {
    public List<String> visitUnknown(Unknown u) {
        //return new <String>();

    }
    public List<String> visitPerson(Person p) {
       // return new Cons<String>(p.name, new MT<String>());
    }
}

//Examples
class ExamplesIATV {
    //persons
    public static void main(String[] args) {
        Unknown a = new Unknown();
        Person ralph = new Person("Ralph", 1995, true, a, a);
        Person kevin = new Person("Kevin", 1994, true, a , a);
        Person julia = new Person("Julia", 1991, false, ralph, a);
        Person lily = new Person("Lily", 1990, false, kevin, julia);
        Person who = new Person("?", 1738, false, lily, a);

        //Visitor
        IATVisitor<List<String>> byName = new IATVisitGetNames();


        //test Vistior
      //  public void testGetNames(String) {

                  //  t.checkExpect(who.accept(byName), new MT<String>());
        }
    }

}

