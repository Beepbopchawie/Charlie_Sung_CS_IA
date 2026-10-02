package persistence;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

import Cafeteria_Food_Sorter.DataEntry.FoodRecordList;
import Cafeteria_Food_Sorter.DataEntry.FoodRecord;


/* variables

location
write

*/


public class JsonReader {

    private String source; 

    /* This will create the reader to read from the source file */
    public JsonReader(String source) {this.source = source; }


    /* This reads whatever is in the Record and returns it
    throws an IOException if an error occurs during the data retrival  */


    public FoodRecordList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFoodRecordList(jsonObject);

    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        /* File reading input format  */
        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    /*  */
    private FoodRecordList parseFoodRecordList(JSONObject jsonObject) {
        FoodRecordList rl = new FoodRecordList();
        addFoodRecords(rl, jsonObject);
        return rl;
    }

    private void addFoodRecords(FoodRecordList rl, JSONObject jsonObject) {
        System.out.println(jsonObject.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("records");
        for (Object json : jsonArray) {
            JSONObject nextFoodrecord = (JSONObject) json;
            addFoodRecord(rl, nextFoodrecord);
        }

    }



    private void addFoodRecord(FoodRecordList rl, JSONObject jsonObject){
        String name = jsonObject.getString("name");
        String day = jsonObject.getString("day");
        Integer amount = jsonObject.getInt("amount");
        String note = jsonObject.getString("note");
        FoodRecord record = new FoodRecord(name, day, amount, note);
        rl.addFoodRecord(record);
    }

}
