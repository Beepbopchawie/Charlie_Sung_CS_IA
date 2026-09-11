package persistence;

import model.WorkRoom;
import org.json.JSONObject;
import org.json.JSONWriter;

/* what this does is read the user text and convert it into 
json object to put in a json file*/

import java.io.*;

public class JsonWriter {

    /* private static final int TAB = 4; */

    private PrintWriter writer;

    private String location;

    public JsonWriter(String location) { this.location = location; }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(location));
    }

    /* TAB will be defined soon just give me a sec same with WorkRoom*/
    public void write(WorkRoom wr) {
        JSONObject json = wr.toJson();
        saveToFile(json.toString(TAB));
    }

    public void close() { writer.close();}

    private void saveToFile(String json) {writer.print(json); }

}

