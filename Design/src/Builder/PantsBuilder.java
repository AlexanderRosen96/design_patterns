package Builder;

import Business_Object.CEO;
import Business_Object.Pants;
import Singelton.OrderService;


/*
    Klass för att bygga upp en "Pants" klass

    klassen skapar upp en ny pants objekt för att sedan
    ha 4st metod som ger olika värden till objektet
    och till sist retunera de ett nytt färdigat objektet
 */

public class PantsBuilder {
    //Upprättar en ny pants objekt
    private Pants newPants = new Pants();

    //Konstruktor
    public PantsBuilder() {
    }

    //Metod för att lägga till storlek i pants objekt
    public PantsBuilder size(String size) {
        System.out.println("\nnu har färg valts");
        if(size.equals("XS")){
            newPants.setSize(size);
            return this;
        }
        else if (size.equals("S")) {
            newPants.setSize(size);
            return this;
        }
        else if (size.equals("M")) {
            newPants.setSize(size);
            return this;
        }
        else if (size.equals("L")) {
            newPants.setSize(size);
            return this;
        }
        else if (size.equals("XL")) {
            newPants.setSize(size);
            return this;
        }
        else {
            return null;
        }
    }

    //Metod för att lägga till material i pants objekt
    public PantsBuilder material(String material) {
        System.out.println("\nnu har material valts");
        if(material.equals("bomull")){
            newPants.setMaterial(material);
            return this;
        }else if(material.equals("lin")){
            newPants.setMaterial(material);
            return this;
        }else if(material.equals("polyester")){
            newPants.setMaterial(material);
            return this;
        }
        else {

            return null;
        }
    }

    //Metod för att lägga till färg i pants objekt
    public PantsBuilder color(String color) {
        System.out.println("\nnu har färg valts");
        switch (color) {
            case "blå":
                newPants.setColor(color);
                return this;
            case "svart":
                newPants.setColor(color);
                return this;
            case "vit":
                newPants.setColor(color);
                return this;
            default:
                return null;
        }
    }

    //Metod för att lägga till en CEO(observer) i pants objekt
    public PantsBuilder ceo (CEO ceo){
        if(ceo != null){
            newPants.registerObserver(ceo);
            return this;
        }
        else {
            System.out.println("De finns ingen ECO de här funkar inte!");
            return this;
        }
    }

    //Metod för att retunera en färdig pants objekt med värderna som vi la till
    public Pants create() {
        if(newPants.getSize() != null && newPants.getMaterial() != null && newPants.getColor() != null ){
            newPants.setName("Byxor");
            newPants.setPrice(120);
            newPants.setId(OrderService.getInstance().getCount());
            return newPants;
        }
        else {
            System.out.println("Något gick fel, kolla så att alla värden stämmer och försök igen");
            return null;
        }
    }
}
