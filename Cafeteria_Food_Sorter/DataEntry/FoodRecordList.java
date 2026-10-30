package Cafeteria_Food_Sorter.DataEntry;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import Cafeteria_Food_Sorter.Analytics.AnalyticsEngine;
import persistence.Writable;





public class FoodRecordList implements Writable, AnalyticsEngine {



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

    // Override because its inherited 
    @Override 
    public double getTotals_weight() {
       double totalWeight = 0;
       for (FoodRecord record : records) {
            totalWeight += record.getWeight();
       }
        return totalWeight;
    }

    public String getStartDate() {
        if(records.isEmpty()) {
            return null; 
        }
        String earliest = records.get(0).getDay();
        for (FoodRecord record : records) {
            if(record.getDay().compareTo(earliest) > 0) {
                earliest = record.getDay();
            }
        }
        return earliest;
    }

    public String getEndDate() {
        if (records.isEmpty()) {
            return null;
        }

        String latest = records.get(0).getDay();
        for (FoodRecord record : records) {
            if (record.getDay().compareTo(latest) > 0) {
                latest = record.getDay();
            }
        }
        return latest;
    }

    @Override
    public String getSummary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSummary'");
    }




}
