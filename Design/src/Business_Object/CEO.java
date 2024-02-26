package Business_Object;

import Observer.ProductObserver;
import Singelton.OrderService;

/*
    Klass för att skapa en CEO obejkt

    Klassen implemterar inteface Productobserver och extrend från objectbase
    Den här klassen funkar som observer för ifall en produkt skapas och ifall den blir klar

 */

public class CEO extends ObjectBase implements ProductObserver {

    //konstruktor
    public CEO() {
    }
    public CEO(String name, int id) {
        super(name, id);
    }

    //Den här metod tar in ett objekt som har skapas eller blivt färdig. Beroden på vilken lista den tillhör så får man ut olika medelanden
    @Override
    public void update(ClothesVariables clothes) {
        for (ClothesVariables c : OrderService.getInstance().getCreateOrder()) {
            if (c.getId() == clothes.getId()) {
                System.out.println("\n" + this.getName() + " har tagit emot ett meddelande att ");
                System.out.println( clothes.getName() + " id "+ clothes.getId() + " håller på att tillvekas");
            }
        }
        for (ClothesVariables f : OrderService.getInstance().getFinishedOrder()) {
            if (f.getId() == clothes.getId()) {
                System.out.println("\n" + this.getName() + " har tagit emot ett meddelande att ");
                System.out.println( clothes.getName() + " id "+ clothes.getId() + " är klar");
            }
        }
    }
}
