package Cafeteria_Food_Sorter.DataEntry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import persistence.JsonReader;
import persistence.JsonWriter;

public class App {
    /* Fields / Attributes */
    private static final String JSON_STORE = "./data/FoodRecordList.json";
    private FoodRecordList foodRecordList;
    private Scanner sc;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    /*
     * Constructor
     * | |
     * | |
     * V V
     */

    public App() {
        foodRecordList = new FoodRecordList();
        sc = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        start();

    }

    public void start() {
        while (true) {
            displayMainMenu();
            System.out.print("Please input an option: ");
            int option = 0;
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option == 1) {
                    addInputTask();
                } else if (option == 2) {
                    removeInputTask();
                } else if (option == 3) {
                    displayFoodRecordList();
                } else if (option == 4) {
                    savefoodRecordList();
                } else if (option == 5) {
                    loadfoodRecordList();
                } else if (option == 6) {
                    return;
                } else {
                    System.out.println("Invalid Input, Please enter a number/integer 1 - 6 ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input, Please enter a number/integer (no decimals)!");
            }

        }
    }

    // Saves the foodRecordList to file

    private void savefoodRecordList() {
        try {
            jsonWriter.open();
            jsonWriter.write(foodRecordList);
            jsonWriter.close();
            System.out.println("Saved " + foodRecordList.getfoodRecordList() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    private void loadfoodRecordList() {
        try {
            foodRecordList = jsonReader.read();
            System.out.println("Loaded" + foodRecordList.getfoodRecordList() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file:" + JSON_STORE);
        }
    }

    public void displayMainMenu() {
        System.out.println("1. add records");
        System.out.println("2. remove records");
        System.out.println("3. display all the records");
        System.out.println("4. save records");
        System.out.println("5. load records");
        System.out.println("6. exit");
    }

    public void addInputTask() {

        System.out.println("Please input a name: ");
        String name = sc.nextLine();

        System.out.println("Please input a date [YYYY-MM-DD validation planned]: ");
        String day = sc.nextLine();

        System.out.println("Please input a rounded up weight (kg): ");
        int amount = Integer.parseInt(sc.nextLine());

        System.out.println("Please input any notes [optional]: ");
        String note = sc.nextLine();

        foodRecordList.addFoodRecord(new FoodRecord(name, day, amount, note));
    }

    public void removeInputTask() {
        System.out.println("Please input a task title to remove");
        /* Doesnt do anything right now code, future feature */
    }

    public void displayFoodRecordList() {
        System.out.println(foodRecordList);
    }

}

/*
 * 
 * ADD RECORD
 * name: Lunch waste [existing field]
 * day: 2026-05-04 [YYYY-MM-DD validation planned]
 * amount (kg): 12.5 [decimal support planned]
 * note: Pizza day [optional]
 * Record added to memory. [planned confirmation]
 * Use menu 4 to save to JSON. [manual save]
 * 
 * Invalid amount: Enter a finite mass of zero or more kg.
 * amount (kg): [planned re-prompt]
 */