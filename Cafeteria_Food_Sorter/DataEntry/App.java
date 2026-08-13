package Cafeteria_Food_Sorter.DataEntry;
import java.util.*;

public class App {
    private FoodRecordList foodRecordList;
    private Scanner sc;

    public App() {
        foodRecordList = new FoodRecordList();
        sc = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            displayMainMenu();
            System.out.print("Please input an option");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                addInputTask();
            } else if (option == 2) {
                removeInputTask();
            } else if (option == 3) {
                displayFoodRecordList();
            } else {
                break;
            }
        }
    } 

    public void displayMainMenu() {
        System.out.println("1. add todo task");
        System.out.println("2. remove todo task");
        System.out.println("3. display all the tasks");
        System.out.println("4. exit");
    }

    public void addInputTask() {

        System.out.println("Please input a name: ");
        String name = sc.nextLine();
        
        System.out.println("Please input a date: ");
        String day = sc.nextLine();

        System.out.println("Please input a rounded up weight in ___: ");
        int amount = Integer.parseInt(sc.nextLine());

        System.out.println("Please input any notes: ");
        String note = sc.nextLine();

        foodRecordList.addFoodRecord(new FoodRecord(name, day, amount, note));
    }

    public void removeInputTask() {
        System.out.println("Please input a task title to remove");
        /* Doesnt do anything right now code, future feature */
    }

    public void displayFoodRecordList(){
        System.out.println(foodRecordList);
    }


}