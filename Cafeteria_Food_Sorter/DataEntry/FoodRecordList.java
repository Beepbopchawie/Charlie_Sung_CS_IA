package Cafeteria_Food_Sorter.DataEntry;
import java.util.*;



public class FoodRecordList {

    private ArrayList<FoodRecord> records;

    public FoodRecordList() {
        records = new ArrayList<FoodRecord>(); 
    }
    
    public void addFoodRecord(FoodRecord foodRecord) {
        records.add(foodRecord); 
    }

    public void removeFoodRecord(FoodRecord foodRecord){
        records.remove(foodRecord);
    }

    @Override
    public String toString() {
        String str = "";
        for (FoodRecord foodRecord : records) {
            str += foodRecord.toString() + "\n";
        }
        return str;

    }




}
