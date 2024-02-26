package Singelton;

import Business_Object.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Klass som hanterar list och köer med ett singelton mönster så att alla kan nå dom och att de bara finns ett objekt av dom
    Klassen har
    2st variablar
    1st lista
    2st köer
    2st konstruktorer
    2st metoder

 */

public class OrderService {
    private static OrderService instance;
    private int count = 1;
    private List<Customer> customerList = new ArrayList<>();
    private Queue<ClothesVariables> createOrder = new LinkedList();
    private Queue<ClothesVariables> finishedOrder = new LinkedList();

    //konstruktorer
    private OrderService() {
    }
    public static OrderService getInstance(){
        if(instance == null){
            instance = new OrderService();
        }
        return instance;

    }

    //Metod för att lägga till en produkt till skapar kör och ge objektet ett ID och notifyger observeren (CEO) att en produkt håller på att skapas
    public void addProduktToCreateList(ClothesVariables object){
        createOrder.add(object);
        object.notifyObserver();
    }

    //Metod för att skapa en värde objekt och lägga till deni värdig objekt kön. Den kollar i skapar kön om objekt som har skickas med finns. Om den gör de så tas den bort från skapar kön och läggs i in färig kön och den skickar iväg en signal till observern (CEO) att objekten är klar
    public void addProduktToFinishList(ClothesVariables object){
        for (ClothesVariables c : createOrder){
            if(c.getId() == object.getId()){
                createOrder.remove();
                finishedOrder.add(object);
                object.notifyObserver();
            }
        }
    }

    //Getters
    public Queue<ClothesVariables> getCreateOrder() {
        return createOrder;
    }

    public Queue<ClothesVariables> getFinishedOrder() {
        return finishedOrder;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public int getCount() {
        return count++;
    }
}

