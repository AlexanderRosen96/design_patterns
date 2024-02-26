package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Klass kör en metod för att justera armlängdne
    klassen implementerar command interfacet
    klassen har
    1st metod
 */

public class TShirtSleevesCommand implements Command{
    //Konstruktor
    public TShirtSleevesCommand() {
    }

    @Override
    public Pants process(Pants pants, String changes) {
        return null;
    }

    @Override
    public Skirt process(Skirt skirt, String changes) {
        return null;
    }

    //Metod för att justera armlängden. Kommer ifrån "Command"
    @Override
    public TShirt process(TShirt tShirt, String changes) {
        System.out.println("\nDu har justerad längden på dina T-Shirten armar");
        tShirt.setSleeves(changes + " armar");
        return tShirt;
    }
}
