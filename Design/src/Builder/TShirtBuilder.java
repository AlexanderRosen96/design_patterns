package Builder;

import Business_Object.CEO;
import Business_Object.TShirt;
import Singelton.OrderService;

/*
    Klass för att bygga upp en "T-Shirt" klass

    klassen skapar upp en ny tshirt objekt för att sedan
    ha 4st metod som ger olika värden till objektet
    och till sist retunera de ett nytt färdigat objektet
 */

public class TShirtBuilder {

    //upprättar en ny Tshirt objekt
    private TShirt newTShirt = new TShirt();

    //Konstruktor
    public TShirtBuilder() {
    }

    //Metod för att lägga till storlek i tshirt objekt
    public TShirtBuilder size(String s) {
        System.out.println("\nnu har storlek valts");
        String size = s.toUpperCase();
        if(size.equals("XS")){
            newTShirt.setSize(size);
            return this;
        }
        else if (size.equals("S")) {
            newTShirt.setSize(size);
            return this;
        }
        else if (size.equals("M")) {
            newTShirt.setSize(size);
            return this;
        }
        else if (size.equals("L")) {
            newTShirt.setSize(size);
            return this;
        }
        else if (size.equals("XL")) {
            newTShirt.setSize(size);
            return this;
        }
        else {
            return null;
        }
    }

    //Metod för att lägga till material i tshirt objekt
    public TShirtBuilder material(String m) {
        System.out.println("\nnu har matrial valts");
        String material = m.toLowerCase();
        if(material.equals("bomull")){
            newTShirt.setMaterial(material);
            return this;
        }else if(material.equals("lin")){
            newTShirt.setMaterial(material);
            return this;
        }else if(material.equals("polyester")){
            newTShirt.setMaterial(material);
            return this;
        }
        else {

            return null;
        }
    }

    //Metod för att lägga till färg i tshirt objekt
    public TShirtBuilder color(String c) {
        System.out.println("\nnu har färg valts");
        String color = c.toLowerCase();
        switch (color) {
            case "blå":
                newTShirt.setColor(color);
                return this;
            case "röd":
                newTShirt.setColor(color);
                return this;
            case "grön":
                newTShirt.setColor(color);
                return this;
            default:
                return null;
        }
    }

    //Metod för att lägga till CEO(observer) i tshirt objekt
    public TShirtBuilder ceo (CEO ceo){
        if(ceo != null){
            newTShirt.registerObserver(ceo);
            return this;
        }
        else {
            System.out.println("De finns ingen ECO de här funkar inte!");
            return this;
        }
    }

    //metod för att retunera en färdig tshirt objekt med värderna som vi la till
    public TShirt create() {
        if(newTShirt.getSize() != null && newTShirt.getMaterial() != null && newTShirt.getColor() != null){
            newTShirt.setName("T-Shirt");
            newTShirt.setPrice(60);
            newTShirt.setId(OrderService.getInstance().getCount());
            return newTShirt;
        }
        else {
            System.out.println("Något gick fel, kolla så att alla värden stämmer och försök igen");
            return null;
        }
    }
}
