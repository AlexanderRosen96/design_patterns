package Observer;

import Business_Object.ClothesVariables;

/*
    Interface är för Observer mönstret.
    Metoden är till för att in ett obejekt och som har ändras / skapas

 */

public interface ProductObserver {
    void update (ClothesVariables clothes);

}
