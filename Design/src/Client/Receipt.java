package Client;

import Business_Object.ClothesVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
    Klass för att skapa en lista på objekt som kunde har köpt
    klassen har
    1st lista
    1st konstruktor
    1st metod

 */

public class Receipt {
    //List på alla objekt
    private List<ClothesVariables> receiptList = new ArrayList<>();

    //Konstruktor
    public Receipt() {
    }

    //Metod att lägga till i listan från en kö
    public void createAReceipt(Queue<ClothesVariables> list){
        for (ClothesVariables c: list) {
            receiptList.add(c);
        }
    }

    //getter
    public List<ClothesVariables> getReceiptList() {
        return receiptList;
    }

}
