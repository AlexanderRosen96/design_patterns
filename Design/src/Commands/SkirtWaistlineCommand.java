package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Klass kör en metod för att justerar midjemåttet på kjolen
    klassen implementerar command interfacet
    klassen har
    1st metod
 */
public class SkirtWaistlineCommand implements Command {
    //Konstruktor
    public SkirtWaistlineCommand() {
    }

    @Override
    public Pants process(Pants pants, String changes) {
        return null;
    }

    //Metod för att justera midjemåtten på kjol objektet. kommer ifrån "Command
    @Override
    public Skirt process(Skirt skirt, String changes) {
        System.out.println("\nDu har justerad midje måttet på din kjol");
        skirt.setWaistline(changes +" midjeinställning");
        return skirt;
    }

    @Override
    public TShirt process(TShirt tShirt, String changes) {
        return null;
    }
}
