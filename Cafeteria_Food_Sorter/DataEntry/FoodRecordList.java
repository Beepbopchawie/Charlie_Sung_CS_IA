package Cafeteria_Food_Sorter.DataEntry;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;





public class FoodRecordList implements Writable {



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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("records", recordsToJson());
        return json;


    }

    private JSONArray recordsToJson() {
       JSONArray jsonArray = new JSONArray();

       for (FoodRecord r : records) {
        jsonArray.put(r.toJson());
       }

       return jsonArray;
    }

    /* Makes it where the list can be checked but cannot be modified */
    public List<FoodRecord> getfoodRecordList() {
        return Collections.unmodifiableList(records);

    }




}
