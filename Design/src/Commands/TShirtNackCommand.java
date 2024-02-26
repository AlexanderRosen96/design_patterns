package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Klass kör en metod för att sy in nacken
    klassen implementerar command interfacet
    klassen har
    1st metod
 */
public class TShirtNackCommand implements Command{
    //Konstruktor
    public TShirtNackCommand() {
    }

    @Override
    public Pants process(Pants pants, String changes) {
        return null;
    }

    @Override
    public Skirt process(Skirt skirt, String changes) {
        return null;
    }

    //Metod för att sy in nacken. Kommer ifrån "Command"
    @Override
    public TShirt process(TShirt tShirt, String changes) {
        System.out.println("\nDu har sytt in nacken");
        tShirt.setNeck(changes +"-neck");
        return tShirt;
    }
}
