package Business_Object;
/*
    Klass för att skapa en T-Shirt objekt

    klassen ärver ifrån ClothesVariable klaseen
    klassen har
    2st variblar
    2st konstruktoer


 */
public class TShirt extends ClothesVariables {
    private String sleeves;
    private String neck;

    //Konstruktorer
    public TShirt() {
    }

    public TShirt(String name, int id, String size, int price, String material, String color, String sleeves, String neck) {
        super(name, id, size, price, material, color);
        this.sleeves = sleeves;
        this.neck = neck;
    }

    //getters och setters
    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    //Metod för att skriva ut vad objekt har i sig
    @Override
    public String toString() {
        return ("Produkt typ: " + this.getName() + " med ID nummer: " + getId() +
                " \ni den här storlek " + this.getSize() +
                " \nmed de här matrialet " + this.getMaterial() +
                " \ni den här färgen " + this.getColor() +
                " \nmed dom här modifieringar " + getNeck() + " ," + getSleeves() +
                " \nprodukten kostar: " + getPrice());
    }
}
