package Business_Object;

/*
    Klass för att ärva ifrån

    Klassen ärver ifrån ObjectBase klassen och den här klassen jobb är att sätt upp gemensamma variablar som andra klasser komemr att behöva
    klassen har
    5st variblar
    3st konstruktorer
    2st metoder
 */

public class ClothesVariables extends ObjectBase {
    private String size;
    private int price;
    private String material;
    private String color;
    protected CEO observer;

    //Konstruktorer
    public ClothesVariables() {
    }

    public ClothesVariables(String size, int price, String material, String color) {
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
    }

    public ClothesVariables(String name, int id, String size, int price, String material, String color) {
        super(name, id);
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
    }

    //Metod fär att lägga till en observer i klass objektet
    public void registerObserver(CEO observer){
        this.observer = observer;
    }

    //Metod för att updater att de har blivt en ändring av de objekt
    public void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }

    //getters och setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
