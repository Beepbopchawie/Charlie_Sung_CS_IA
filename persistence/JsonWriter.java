package persistence;

import org.json.JSONObject;

import Cafeteria_Food_Sorter.DataEntry.FoodRecordList;

/* what this does is read the user text and convert it into 
json object to put in a json file*/

import java.io.*;

public class JsonWriter {

    /* static = everyone shares the same  */
    private static final int TAB = 4;

    private PrintWriter writer;

    private String location;

    public JsonWriter(String location) { this.location = location; }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(location));
    }

    public void write(FoodRecordList wr) {
        JSONObject json = wr.toJson();
        saveToFile(json.toString(TAB));
    }

    public void close() { writer.close();}

    private void saveToFile(String json) {writer.print(json); }

}

