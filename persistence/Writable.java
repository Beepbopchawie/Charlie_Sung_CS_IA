package persistence;
import org.json.JSONObeject;


public interface Writable {
    // Returns the writable as a JSON Object to be stored
    JSONObject toJSON();
}
