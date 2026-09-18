package Cafeteria_Food_Sorter.DataEntry;


import org.json.JSONObject;

public class FoodRecord {
    private String name;
    private String day;
    private int amount;
    private String note;


    public FoodRecord(String name, String day, int amount, String note) {
        this.name = name;
        this.day = day;
        this.amount = amount;
        this.note = note;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {return day;}
    public void setDay(String day) {
        this.day = day;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}

    @Override
    public String toString() {
        return name + " " + day + " " + amount + " " + note;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("day", day);
        json.put("amount", amount);
        json.put("note", note);
        return json; 
    }
} 
 