package persistence;
//import model.WorkRoom;

import model.TierList;
import org.json.JSONObject;


import java.io.*;

// Represents a writer that writes JSON representation of workroom to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // requires: nothing
    // modifies: this
    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // requires: nothing
    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // requires: nothing
    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(TierList tl) {
        JSONObject json = tl.toJson();
        saveToFile(json.toString(TAB));
    }

    // requires: nothing
    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // requires: nothing
    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}

