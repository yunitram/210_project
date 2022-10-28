package persistence;

import org.json.JSONObject;

public interface Writable {
    // requires: nothing
    // modifies: nothing
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
