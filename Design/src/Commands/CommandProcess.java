package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Klass som innehåller alla command för lättare åtkommst till dom
    klassen har
    6st metoder
 */

public class CommandProcess {
    private PantsFitCommand pantsFitCommand = new PantsFitCommand();
    private PantsLengthCommand pantsLengthCommand = new PantsLengthCommand();
    private SkirtWaistlineCommand skirtWaistlineCommand = new SkirtWaistlineCommand();
    private SkirtPatternCommand skirtPatternCommand = new SkirtPatternCommand();
    private TShirtNackCommand tShirtNackCommand = new TShirtNackCommand();
    private TShirtSleevesCommand tShirtSleevesCommand = new TShirtSleevesCommand();

    //Kontsruktor
    public CommandProcess() {
    }

    //Metoder: som kör process metod för vardera klass så att man kan nå dom ifrån en och sammma objekt
    public void pantsFit (Pants pants, String changes){
        pantsFitCommand.process(pants, changes);
    }
    public void pantsLength (Pants pants, String changes){
        pantsLengthCommand.process(pants, changes);
    }
    public void skirtWaistline(Skirt skirt, String changes){
        skirtWaistlineCommand.process(skirt, changes);
    }
    public void skirtPattern(Skirt skirt, String changes){
        skirtPatternCommand.process(skirt, changes);
    }
    public void tshirtNack (TShirt tShirt, String changes){
        tShirtNackCommand.process(tShirt, changes);
    }
    public void tshirtSleeves (TShirt tShirt, String changes){
        tShirtSleevesCommand.process(tShirt, changes);
    }

}
