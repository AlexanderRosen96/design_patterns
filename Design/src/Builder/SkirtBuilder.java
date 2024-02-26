package Builder;

import Business_Object.CEO;
import Business_Object.Skirt;
import Singelton.OrderService;

/*
    Klass för att bygga upp en "Skirt" klass

    klassen skapar upp en ny skirt objekt för att sedan
    ha 4st metod som ger olika värden till objektet
    och till sist retunera de ett nytt färdigat objektet
 */

public class SkirtBuilder {
    //Upprättar en ny Skirt obejkt
    private Skirt newSkirt = new Skirt();

    //Konstruktor
    public SkirtBuilder() {
    }

    //Metod för att lägga till storlek i Skirt objekt
    public SkirtBuilder size(String s) {
        System.out.println("\nnu har storlek valts");
        String size = s.toUpperCase();
        if(size.equals("XS")){
            newSkirt.setSize(size);
            return this;
        }
        else if (size.equals("S")) {
            newSkirt.setSize(size);
            return this;
        }
        else if (size.equals("M")) {
            newSkirt.setSize(size);
            return this;
        }
        else if (size.equals("L")) {
            newSkirt.setSize(size);
            return this;
        }
        else if (size.equals("XL")) {
            newSkirt.setSize(size);
            return this;
        }
        else {
            return null;
        }
    }

    //Metod för att lägga till material i Skirt objekt
    public SkirtBuilder material(String m) {
        System.out.println("\nnu har matrial valts");
        String material = m.toLowerCase();
        if(material.equals("bomull")){
            newSkirt.setMaterial(material);
            return this;
        }else if(material.equals("lin")){
            newSkirt.setMaterial(material);
            return this;
        }else if(material.equals("polyester")){
            newSkirt.setMaterial(material);
            return this;
        }
        else {

            return null;
        }
    }

    //Metod för att lägga till färg i Skirt objekt
    public SkirtBuilder color(String c) {
        System.out.println("\nnu har färg valts");
        String color = c.toLowerCase();
        switch (color) {
            case "blå":
                newSkirt.setColor(color);
                return this;
            case "svart":
                newSkirt.setColor(color);
                return this;
            case "vit":
                newSkirt.setColor(color);
                return this;
            case "rosa":
                newSkirt.setColor(color);
                return this;
            default:
                return null;
        }
    }

    //Metod för att lägga till CEO(observer) i skirt objekt
    public SkirtBuilder ceo (CEO ceo){
        if(ceo != null){
            newSkirt.registerObserver(ceo);
            return this;
        }
        else {
            System.out.println("De finns ingen ECO de här funkar inte!");
            return this;
        }
    }

    //metod för att retunera en färdig skirt objekt med värderna som vi la till
    public Skirt create() {
        if(newSkirt.getSize() != null && newSkirt.getMaterial() != null && newSkirt.getColor() != null){
            newSkirt.setName("Kjol");
            newSkirt.setPrice(100);
            newSkirt.setId(OrderService.getInstance().getCount());
            return newSkirt;
        }
        else {
            System.out.println("Något gick fel, kolla så att alla värden stämmer och försök igen");
            return null;
        }
    }
}
