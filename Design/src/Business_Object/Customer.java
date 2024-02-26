package Business_Object;

import Client.Receipt;

/*
    Klass för att skapa en customer

    klassen ärver ifrån Objectbase klassen
    klassen har
    4st variblar
    2st konstruktorer
    1st metod
 */

public class Customer extends ObjectBase {
    private String adress;
    private String eMail;
    private Receipt receipt;

    //Konstruktorer
    public Customer() {
    }
    public Customer(String name, int id, String adress, String eMail) {
        super(name, id);
        this.adress = adress;
        this.eMail = eMail;
    }

    //Metod för att skriva ut en kvitto på vad kund har köpt
    public void writeTheReceipt(){
        System.out.println("!Kvitto!\n");
        System.out.println("Proukter att skapa:");
        int totalcost = 0;
        for(ClothesVariables c : receipt.getReceiptList()){
            System.out.println(c);
            totalcost = c.getPrice() + totalcost;
            System.out.println(" ");
        }
        System.out.println("\n" + getName() + " ,kundnummer " + getId() + " kommer bli faktuerar ett belopp på " + totalcost +",");
        System.out.println("till adress: " + getAdress());
        System.out.print("och till mail: " + geteMail());
    }

    //getters och setters
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}
