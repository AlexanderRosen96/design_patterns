package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Klass kör en metod för att justera byxorna längd
    klassen implementerar command interfacet
    klassen har
    1st metod
 */
public class PantsLengthCommand implements Command{
    //Konstruktor
    public PantsLengthCommand() {
    }

    //Metod för att justera längden på byxorna. Kommer ifrån "Command"
    @Override
    public Pants process(Pants pants, String changes) {
        System.out.println("\nByx längd är anpassad");
        pants.setLength(changes + " still");
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
