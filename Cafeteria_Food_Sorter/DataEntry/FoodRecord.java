package Cafeteria_Food_Sorter.DataEntry;


import org.json.JSONObject;

public class FoodRecord {
    private String name;
    private String day;
    private double weight;
    private String note;


    public FoodRecord(String name, String day, double weight, String note) {
        this.name = name;
        this.day = day;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}

    @Override
    public String toString() {
        return name + " " + day + " " + weight + " " + note;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("day", day);
        json.put("weight", weight);
        json.put("note", note);
        return json; 
    }


} 
 