package persistence;
import java.io.*;



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


    public List read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseList(jsonObject);

    }




}
