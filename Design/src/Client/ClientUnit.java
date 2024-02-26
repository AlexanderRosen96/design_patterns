package Client;

import Builder.PantsBuilder;
import Builder.SkirtBuilder;
import Builder.TShirtBuilder;
import Business_Object.*;
import Commands.*;
import Singelton.OrderService;
import java.util.Scanner;

/*
    Klass för att hantera programmet
    Klassen innehåller
    9st Klass objekt
    7st Variablar
    1st Konstruktor
    7st Metoder
 */
public class ClientUnit {
    private CommandProcess command = new CommandProcess();                  // för att hantera alla commandos
    private OrderService orderService = OrderService.getInstance();         // för att lättare hantera Singelton klassen
    private Scanner clientScanner = new Scanner(System.in);                 // för att ta in data från användaren
    private CEO ceo = new CEO("Wigells VD", 1);                    // för att lägga till en CEO från början
    private Pants currentPants;
    private Skirt currentSkirt;
    private TShirt currentTShirt;
    private Customer customer;
    private Receipt receipt;
    private boolean runMeny = true;
    private boolean controllSize;
    private boolean controllMaterial;
    private boolean controllColor;
    private boolean controllBuild;
    private int userInputInt;
    private String dataInput;

    //Konstruktor
    public ClientUnit() {
    }

    //Metod för att enkelt köra programet
    public void programStart(){
        loginCustomer();                //Skapa en kund
        while (runMeny){
            menyOne();                  //Välja plagg att skapa
            menyTwo(userInputInt);      //Bygga upp plagget (Builder mönster, innehånner oberver mönster)
            menyThree();                //Lägg till personliga justeringar till plagget (Commando mönster, innehånner oberver mönster)
        }
    }

    //Metod för att låta användaren välja vad om vill göra skapa/avsluta och om dom har skapat något betala och avsluta
    private void menyOne(){
        //de första du möts av, du får välja att skapa ett plagger eller att avsluta
        if(OrderService.getInstance().getFinishedOrder().isEmpty()) {
            System.out.println("\nVälkommen till meny för skapande av custom-kläder");
            System.out.println("Väljer någon av följande altenativ\n");
            System.out.println("1) Ska ett par byxor");
            System.out.println("2) Ska en T-shirt");
            System.out.println("3) Ska en kjol");
            System.out.println("4) Avsluta!");
        }

        else {
            //Den här meny kommer bara upp ifall kunden har skapa en plagg. För då finns möjligheten att gå till betalning och avsluta eller att skapa mer plagg
            System.out.println("\nVälkommen till meny för skapande av customer kläder");
            System.out.println("Du har för närvarande " + orderService.getFinishedOrder().size() + "st produkter i din inkorg");
            System.out.println("Väljer att ska flera produkter eller gå till betalning\n" +
                               "Väljer någon av följande altenativ\n");
            System.out.println("1) Ska ett par byxor");
            System.out.println("2) Ska en T-shirt");
            System.out.println("3) Ska en kjol");
            System.out.println("4) Avsluta och logga ut");
            System.out.println("5) Betala och avsluta");
        }

        //Kontroll ifall man skulle skiva in fel värde
        while (true) {
            if ( clientScanner.hasNextInt()) {
                userInputInt = clientScanner.nextInt();
                if (userInputInt >= 1 && userInputInt <= 5) {
                    break;
                } else {
                    System.out.println("\nDu har skrivit in fel, försök igen!");
                }
            }
            else {
                System.out.println("Du har skrivit in fel, försök igen!");
                clientScanner.next();
            }
        }
    }

    //Metod för att bygga plagget. Beroden på vad man välja så kommer man till olika menyer
    private void menyTwo(int input){
        restSystem();
        switch (input){
            //Meny för att bygga byxor
            case 1: {

                while (!controllBuild) {
                    PantsBuilder pantsBuilder = new PantsBuilder()     //Skapa objekt för att bygga ett pants objekt
                                 .ceo(ceo);

                    while (!controllSize) {
                        System.out.println("\nVilken storlek vill du på dina byxor väljer mellan (XS, S, M, L och XL)?");
                        dataInput = clientScanner.next().toUpperCase();
                        if ((dataInput.equals("XS") || dataInput.equals("S") || dataInput.equals("M") || dataInput.equals("L") || dataInput.equals("XL"))) {         //Välj storlek
                            pantsBuilder.size(dataInput);
                            controllSize = true;
                        } else {
                            System.out.println("du har skriv in fel storlek");
                        }
                    }

                    while (!controllMaterial) {
                        System.out.println("\nVilken matrial vill du på dina byxor?");
                        System.out.println("välj mellan (bomull, lin och polyester)");
                        dataInput = clientScanner.next().toLowerCase();
                        if (dataInput.equals("bomull") || dataInput.equals("lin") ||dataInput.equals("polyester")) {          //Välja matrial
                            pantsBuilder.material(dataInput);
                            controllMaterial = true;
                        } else {
                            System.out.println("du har skriv in fel matrial");
                        }
                    }

                    while (!controllColor) {
                        System.out.println("\nVilken färg vill du ha på din byxor?");
                        System.out.println("välj mellan (Blå, Svart och Vit)");
                        dataInput = clientScanner.next().toLowerCase();
                        if (dataInput.equals("blå") || dataInput.equals("svart") || dataInput.equals("vit")) {      //Välja färg
                            pantsBuilder.color(dataInput);
                            controllColor = true;
                        } else {
                            System.out.println("du har skriv in fel färg");
                        }
                    }

                    currentPants = pantsBuilder.create();
                    if (currentPants != null){
                        OrderService.getInstance().addProduktToCreateList(currentPants);
                        controllBuild = true;
                        break;
                    }
                }
                break;
            }

            //Meny för att bygga upp en T-Shirt
            case 2: {
                while (!controllBuild) {
                    TShirtBuilder tShirtBuilder = new TShirtBuilder()    //Skapa objekt för att bygga ett T-shirt objekt
                                  .ceo(ceo);

                    while (!controllSize) {
                        System.out.println("\nVilken storlek vill du på dina T-Shirt väljer mellan (XS, S, M, L och XL)?");
                        dataInput = clientScanner.next().toUpperCase();
                        if ((dataInput.equals("XS") || dataInput.equals("S") || dataInput.equals("M") || dataInput.equals("L") || dataInput.equals("XL"))) {     //Välja storlek
                            tShirtBuilder.size(dataInput);
                            controllSize = true;
                        } else {
                            System.out.println("du har skriv in fel storlek");
                        }
                    }

                    while (!controllMaterial) {
                        System.out.println("\nVilken matrial vill du på dina T-Shirt?");
                        System.out.println("välj mellan (bomull, lin och polyester)");
                        dataInput = clientScanner.next().toLowerCase();
                        if (dataInput.equals("bomull") || dataInput.equals("lin") || dataInput.equals("polyester")) {          //välja matrial
                            tShirtBuilder.material(dataInput);
                            controllMaterial = true;
                        } else {
                            System.out.println("du har skriv in fel matrial");
                        }
                    }

                    while (!controllColor) {
                        System.out.println("\nVilken färg vill du ha på din T-Shirt?");
                        System.out.println("välj mellan (Blå, Röd, Grön)");
                        dataInput = clientScanner.next().toLowerCase();
                        if (dataInput.equals("blå") || dataInput.equals("röd") || dataInput.equals("grön")) {       //Välja färg
                            tShirtBuilder.color(dataInput);
                            controllColor = true;
                        } else {
                            System.out.println("du har skriv in fel färg");
                        }
                    }

                    currentTShirt = tShirtBuilder.create();
                    if(currentTShirt != null) {
                        orderService.addProduktToCreateList(currentTShirt);
                        controllBuild = true;
                        break;
                    }
                }
                break;
            }

            //Meny för att bygga en Kjol
            case 3: {

                while (!controllBuild) {
                    SkirtBuilder skirtBuilder = new SkirtBuilder()      //LSkapa objekt för att bygga ett Skirt objekt
                                 .ceo(ceo);

                    while (!controllSize) {
                        System.out.println("\nVilken storlek vill du på dina kjol väljer mellan (XS, S, M, L och XL)?");
                        dataInput = clientScanner.next().toUpperCase();
                        if ((dataInput.equals("XS") || dataInput.equals("S") || dataInput.equals("M") || dataInput.equals("L") || dataInput.equals("XL"))) {         //Välja storlek
                            skirtBuilder.size(dataInput);
                            controllSize = true;
                        } else {
                            System.out.println("du har skriv in fel storlek");
                        }
                    }
                    while (!controllMaterial) {
                        System.out.println("\nVilken matrial vill du på dina kjol?");
                        System.out.println("välj mellan (bomull, lin och polyester)");
                        dataInput = clientScanner.next().toLowerCase();
                        if (dataInput.equals("bomull") || dataInput.equals("lin") || dataInput.equals("polyester")) {          //Välja matrial
                            skirtBuilder.material(dataInput);
                            controllMaterial = true;
                        } else {
                            System.out.println("du har skriv in fel matrial");
                        }
                    }
                    while (!controllColor) {
                        System.out.println("\nVilken färg vill du ha på din kjol?");
                        System.out.println("välj mellan (Blå, Svart, Vit, Rosa)");
                        dataInput = clientScanner.next().toLowerCase();
                        if (dataInput.equals("blå") || dataInput.equals("svart") || dataInput.equals("vit") || dataInput.equals("rosa")) {      //Välja färg
                            skirtBuilder.color(dataInput);
                            controllColor = true;
                        } else {
                            System.out.println("du har skriv in fel färg");
                        }
                    }

                    currentSkirt = skirtBuilder.create();
                    if(currentSkirt != null){
                        orderService.addProduktToCreateList(currentSkirt);
                        controllBuild = true;
                        break;
                    }
                }
                break;
            }
            case 4:{
                //Avsluta programet
                System.out.println("logout! hej då och välkommen åter " + customer.getName());
                runMeny = false;
                break;
            }
            case 5:{
                //Skapa ett kvitto och lägg till alla färdiga objekt som kund har skapa på kvitto och spara de på kunden
                receipt = new Receipt();
                receipt.createAReceipt(orderService.getFinishedOrder());
                customer.setReceipt(receipt);
                customer.writeTheReceipt();
                runMeny = false;
                break;
            }
            default:
                if(orderService.getFinishedOrder().isEmpty()) {
                    System.out.println("Skriv in ett nummer mellen 1-4 ");
                    break;
                }
                else {
                    System.out.println("Skriv in ett nummer mellen 1-5");
                }
        }
    }


    //Metod för att anpassa plagget till kunden. Varje plagg har tre olika altenativ som kund kan välja mellan och de skönt igenom commands.
    private void menyThree() {
        if (userInputInt == 1) {
            System.out.println("\nFör byxor kan du välja att göra:\n");
            while (currentPants.getFit() == null || currentPants.getLength() == null){

                //Command för att justera till formen på byxornam
                while (currentPants.getFit() == null) {
                    System.out.println("En form anpassning, dina val är :");
                    System.out.println("Reguler");
                    System.out.println("Fit");
                    System.out.println("Casual");
                    System.out.println("\nsvar Reguler, Fit, eller Casual");
                    dataInput = clientScanner.next().toLowerCase();
                    if (dataInput.equals("reguler") || dataInput.equals("fit") || dataInput.equals("casual")) {
                        command.pantsFit(currentPants, dataInput);
                    } else {
                        System.out.println("\nVäljer mellan (Reguler, Fit eller Casual)");
                    }
                }

                //Command för att justera till längden på byxornam
                while (currentPants.getLength() == null) {
                    System.out.println("\nKlipp till önskad längd, välj mellan");
                    System.out.println("Lång");
                    System.out.println("Precis");
                    System.out.println("Kort");
                    System.out.println("\nsvar Lång, Precis, eller Kort");
                    dataInput = clientScanner.next().toLowerCase();
                    if (dataInput.equals("lång") || dataInput.equals("precis") || dataInput.equals("kort")) {
                        command.pantsLength(currentPants, dataInput);
                    }
                     else {
                        System.out.println("\nVälj mellan Lång, Precis, eller Kort");
                    }
                }
            }
            OrderService.getInstance().addProduktToFinishList(currentPants);
            }

        else if (userInputInt == 2) {
            System.out.println("\nFör T-shirt kan du välja att göra:\n");
            while (currentTShirt.getNeck() == null || currentTShirt.getSleeves() == null){

                //Command för att justera nacken på t-shirten
                while (currentTShirt.getNeck() == null) {
                    System.out.println("Justera din nack till dessa olika modeler, dina val är :");
                    System.out.println("V-neck");
                    System.out.println("O-neck");
                    System.out.println("T-neck");
                    System.out.println("\nsvar V, O, eller T");
                    dataInput = clientScanner.next().toUpperCase();
                    if (dataInput.equals("V") || dataInput.equals("O") || dataInput.equals("T")) {
                        command.tshirtNack(currentTShirt, dataInput);
                    } else {
                        System.out.println("\nVäljer mellan (V, O eller T)");
                    }
                }

                //Command för att justera arm längden på t-shirten
                while (currentTShirt.getSleeves() == null) {
                    System.out.println("\nEn anpassin till din armar, välj mellan");
                    System.out.println("Lång");
                    System.out.println("Kort");
                    System.out.println("Inga");
                    System.out.println("\nsvar lång, Kort, eller Inga");
                    dataInput = clientScanner.next().toLowerCase();
                    if (dataInput.equals("lång") || dataInput.equals("inga") || dataInput.equals("kort")) {
                        command.tshirtSleeves(currentTShirt, dataInput);
                    }
                    else {
                        System.out.println("\nVälj mellan Lång, Precis, eller Kort");
                    }
                }
            }
            OrderService.getInstance().addProduktToFinishList(currentTShirt);
        }
        else if (userInputInt == 3) {
            System.out.println("\nFör kjol kan du välja att göra:\n");
            while (currentSkirt.getPattern() == null || currentSkirt.getWaistline() == null){

                //Command för att lägga till ett mönster på kjolenn
                while (currentSkirt.getPattern() == null) {
                    System.out.println("Du kan lägga till ett mönster på din kjol, dina val är :");
                    System.out.println("Blommor");
                    System.out.println("Ränder");
                    System.out.println("Ringar");
                    System.out.println("\nsvar Blommor, Ränder, eller Ringar");
                    dataInput = clientScanner.next().toLowerCase();
                    if (dataInput.equals("blommor") || dataInput.equals("ränder") || dataInput.equals("ringar")) {
                        command.skirtPattern(currentSkirt, dataInput);
                    } else {
                        System.out.println("\nVäljer mellan (blommor, ränder eller ringar)");
                    }
                }

                //Command för att justera midje storleken
                while (currentSkirt.getWaistline() == null) {
                    System.out.println("\nKlipp till önskad längd, välj mellan");
                    System.out.println("Tajt");
                    System.out.println("Löst");
                    System.out.println("Lagom");
                    System.out.println("\nsvar Tajt, Löst, eller Lagom");
                    dataInput = clientScanner.next().toLowerCase();
                    if (dataInput.equals("tajt") || dataInput.equals("löst") || dataInput.equals("lagom")) {
                        command.skirtWaistline(currentSkirt, dataInput);
                    }
                    else {
                        System.out.println("\nVälj mellan Tajt, Löst, eller Lagom");
                    }
                }
            }
            OrderService.getInstance().addProduktToFinishList(currentSkirt);
        }

    }

    //Metod för att skapa en kund
    private void loginCustomer(){
        System.out.println("\nNy kund!");
        System.out.println("Var vänlig skriv in följan info:");

        System.out.print("Name:");
        String tempName = clientScanner.nextLine();

        System.out.print("Adress:");
        String tempAdress = clientScanner.nextLine();

        System.out.print("E-Mail:");
        String tempEMail = clientScanner.nextLine();

        int tempid = (orderService.getCustomerList().size()+1);
        customer = new Customer(tempName,tempid,tempAdress,tempEMail);

        orderService.getCustomerList().add(customer);
    };

    //Metod för att ändra CEO. Denna metod används inte men jag kände att jag vill ska en metod för att kunna ändra ifall de skulle behövas i fram tiden
    private void changeCEO(String name){
        ceo.setName(name);
        ceo.setId(ceo.getId()+1);
    }

    //Metod att resta efter att en plagg har skapas
    private void restSystem(){
        controllSize = false;
        controllMaterial = false;
        controllColor = false;
        controllBuild = false;
        currentPants = null;
        currentSkirt = null;
        currentTShirt = null;
    }
}
