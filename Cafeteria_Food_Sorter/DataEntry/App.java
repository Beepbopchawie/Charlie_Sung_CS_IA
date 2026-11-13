package Cafeteria_Food_Sorter.DataEntry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.time.LocalDate;
/* Validates dates */
import java.time.format.DateTimeParseException;

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
                } else if (option == 7) {
                    showSummaryTask();
                } else if (option == 8) {
                    comparePeriodTask();
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
        System.out.println("7. show summary");
        System.out.println("8. compare periods");
    }

    public void addInputTask() {

        System.out.println("======================");
        System.out.println("Please input a name: ");
        String name = sc.nextLine();

        /* Date input with validationn */
        String day = "";
        boolean validDate = false;

        while (!validDate) {
            System.out.println("Please input a date (YYYY-MM-DD): ");
            day = sc.nextLine();

            try {
                LocalDate.parse(day);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println(
                    "Invalid date. Please enter a real date in YYYY-MM-DD format."
                );
            }
        }

        /* weight input with validation  */
        double amount = 0;
        boolean validWeight = false;

        while (!validWeight) {
            System.out.println("Please input the weight in kg: ");

            try {
                amount = Double.parseDouble(sc.nextLine());

                if (amount < 0 || !Double.isFinite(amount)) {
                    System.out.println("Please enter a finite weight of zero or more.");
                } else {
                    validWeight = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number, such as 2.5");
            }
        }

        System.out.println("Please input any notes [optional]: ");
        String note = sc.nextLine();

        foodRecordList.addFoodRecord(new FoodRecord(name, day, amount, note));
        System.out.println("======================");
    }

    public void removeInputTask() {
    List<FoodRecord> records = foodRecordList.getfoodRecordList();

    if (records.isEmpty()) {
        System.out.println("There are no records to remove.");
        return;
    }

    /*  Display records with numbers starting at 1. */
    for (int i = 0; i < records.size(); i++) {
        System.out.println((i + 1) + ". " + records.get(i));
    }

    while (true) {
        System.out.println("Enter a record number to remove, or 0 to cancel:");

        try {
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) {
                return;
            }

            if (choice < 1 || choice > records.size()) {
                System.out.println("Please choose a number from the list.");
                continue;
            }

            FoodRecord selectedRecord = records.get(choice - 1);

            System.out.println("Remove this record?");
            System.out.println(selectedRecord);
            System.out.println("Type yes to confirm:");

            String confirmation = sc.nextLine();

            
            if (confirmation.equalsIgnoreCase("yes")) {
                foodRecordList.removeFoodRecord(selectedRecord);
                System.out.println("Record removed. Use option 4 to save.");
            } else {
                System.out.println("Removal cancelled.");
            }

            return;

        } catch (NumberFormatException e) {
            System.out.println("Please enter a whole number.");
        }
    }
    }

    public void displayFoodRecordList() {
        System.out.println(foodRecordList);
    }

    public void showSummaryTask() {
        /* Do after the AnalyticsEngine */
        System.out.println(foodRecordList.getSummary());
        System.out.println("======================");
    }

    public void comparePeriodTask(){
        /*do after showSummary */
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