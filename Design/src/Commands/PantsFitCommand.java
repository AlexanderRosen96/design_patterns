package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Klass kör en metod för att sy in byxor
    klassen implementerar command interfacet
    klassen har
    1st metod
 */
public class PantsFitCommand implements Command{
    //Konstruktor
    public PantsFitCommand() {
    }

    //Metod för att sy in byxor. Kommer ifrån "Command"
    @Override
    public Pants process(Pants pants, String changes) {
        System.out.println("\nDu har sytt in dina byxor");
        pants.setFit(changes + " form");
        return pants;
    }

    @Override
    public Skirt process(Skirt skirt, String changes) {
        return null;
    }

    @Override
    public TShirt process(TShirt tShirt, String changes) {
        return null;
    }
}
