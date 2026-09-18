package persistence;

import org.json.JSONObject;

/* interface defines the behavior of a class */
public interface Writable {
    // Returns the writable as a JSON Object to be stored
    JSONObject toJson();
}
