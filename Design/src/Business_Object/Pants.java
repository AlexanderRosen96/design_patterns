package Business_Object;

/*
    Klass för att skapa en pants objekt

    klassen ärver ifrån ClothesVariable klaseen
    klassen har
    2st variblar
    2st konstruktoer


 */

public class Pants extends ClothesVariables {
    private String fit;
    private String length;

    //Konstruktorer
    public Pants() {
    }

    public Pants(String name, int id, String size, int price, String material, String color, String fit, String length) {
        super(name, id, size, price, material, color);
        this.fit = fit;
        this.length = length;
    }

    //getters och setter
    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    //Metod för att skriva ut vad objekt har i sig
    @Override
    public String toString() {
        return ("Produkt typ: " + this.getName() + " med ID nummer: " + getId() +
                " \ni den här storlek " + this.getSize() +
                " \nmed de här matrialet " + this.getMaterial() +
                " \ni den här färgen " + this.getColor() +
                " \nmed dom här modifieringar " + getFit() + ", " + getLength() +
                " \nprodukten kostar: " + getPrice());
    }
}
