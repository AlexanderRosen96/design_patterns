package Business_Object;
/*
    Klass för att skapa en skirt objekt

    klassen ärver ifrån ClothesVariable klaseen
    klassen har
    2st variblar
    2st konstruktoer


 */
public class Skirt extends ClothesVariables {
    private String waistline;
    private String pattern;

    //Konstruktorer
    public Skirt() {
    }

    public Skirt(String name, int id, String size, int price, String material, String color, String waistline, String pattern) {
        super(name, id, size, price, material, color);
        this.waistline = waistline;
        this.pattern = pattern;
    }

    //getters och setters
    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    //Metod för att skriva ut vad objekt har i sig
    @Override
    public String toString() {
        return ("Produkt typ: " + this.getName() + " med ID nummer: " + getId() +
                " \ni den här storlek " + this.getSize() +
                " \nmed de här matrialet " + this.getMaterial() +
                " \ni den här färgen " + this.getColor() +
                " \nmed dom här modifieringar " + getWaistline() + " ," + getPattern() +
                " \nprodukten kostar: " + getPrice());
    }
}
