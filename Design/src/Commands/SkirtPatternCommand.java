package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Klass kör en metod för att sy in ett mönster i kjolen
    klassen implementerar command interfacet
    klassen har
    1st metod
 */

public class SkirtPatternCommand implements Command{
    //Konstruktor
    public SkirtPatternCommand() {
    }

    @Override
    public Pants process(Pants pants, String changes) {
        return null;
    }

    //Metod för att sy in ett mönster i kjolen. Kommer ifrån "Command"
    @Override
    public Skirt process(Skirt skirt, String changes) {
        System.out.println("\nDu har sytt in ett mönster på din kjol");
        skirt.setPattern(changes + " mönster");
        return skirt;
    }

    @Override
    public TShirt process(TShirt tShirt, String changes) {
        return null;
    }
}
