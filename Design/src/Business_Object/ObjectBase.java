package Business_Object;

/*
    Klass för att ärva ifrån

    klassen är till för att sätta upp variblar alla andra business_object behöver

 */

public class ObjectBase {
    private String name;
    private int id;

    //Konstruktorer
    public ObjectBase() {
    }

    public ObjectBase(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //getters och setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
