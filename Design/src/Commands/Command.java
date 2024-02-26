package Commands;

import Business_Object.Pants;
import Business_Object.Skirt;
import Business_Object.TShirt;

/*
    Interface för att sätta metoder som alla kommand command behöver
 */

public interface Command {
    //metoder för varje kläders lag
    Pants process(Pants pants, String changes);
    Skirt process(Skirt skirt, String changes);
    TShirt process(TShirt tShirt, String changes);
}
