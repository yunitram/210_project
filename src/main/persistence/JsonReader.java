package persistence;

import model.Character;
import model.CharacterList;
import model.Tier;
import model.TierList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // requires: nothing
    // modifies: nothing
    // EFFECTS: reads TierList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TierList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // requires: nothing
    // modifies: nothing
    // EFFECTS: reads CharacterList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CharacterList find() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return findWorkRoom(jsonObject);
    }

    // requires: nothing
    // modifies: nothing
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // requires: nothing
    // modifies: nothing
    // EFFECTS: parses TierList from JSON object and returns it
    private TierList parseWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        TierList tl = new TierList(name);
        addTiers(tl, jsonObject);
        return tl;
    }

    // requires: nothing
    // MODIFIES: tl
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addTiers(TierList tl, JSONObject jsonObject) {
        JSONArray listOfTiers = jsonObject.getJSONArray("tiers");
        for (Object eltier : listOfTiers) {
            JSONObject nextThingy = (JSONObject) eltier;
            addTier(tl, nextThingy);
        }
    }

    // requires: nothing
    // modifies: tier
    // effects adds all the characters in JSON tier to the tier given
    private void addCharacters(Tier tier, JSONObject jsonObject) {
        JSONArray listOfCharacters = jsonObject.getJSONArray("tiercontent");
        for (Object character : listOfCharacters) {
            JSONObject nextCharacter = (JSONObject) character;
            String name = nextCharacter.getString("characterName");
            String description = nextCharacter.getString("description");
            Character thelegend = new Character(name, description);
            tier.addCharacter(thelegend);
        }
    }

    // requires: nothing
    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addTier(TierList wr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Tier thingy = new Tier();
        CharacterList cl = new CharacterList();
        addCharacters(thingy, jsonObject);
        thingy.renameTier(name);
        wr.addFilledTier(thingy);
    }

    // requires: nothing
    // modifies: nothing
    // EFFECTS: parses JSON object and returns a list of characters in it
    private CharacterList findWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        CharacterList cl = new CharacterList();
        addChars(cl, jsonObject);
        return cl;
    }

    // requires: nothing
    // MODIFIES: cl
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addChars(CharacterList cl, JSONObject jsonObject) {
        JSONArray listOfTiers = jsonObject.getJSONArray("tiers");
        for (Object eltier : listOfTiers) {
            JSONObject nextThingy = (JSONObject) eltier;
            addChar(cl, nextThingy);
        }
    }

    // requires: nothing
    // modifies: cl
    // effects adds all the characters in JSON tier to the tier given
    private void addChar(CharacterList cl, JSONObject jsonObject) {
        JSONArray listOfCharacters = jsonObject.getJSONArray("tiercontent");
        for (Object character : listOfCharacters) {
            JSONObject nextCharacter = (JSONObject) character;
            String name = nextCharacter.getString("characterName");
            String description = nextCharacter.getString("description");
            Character thelegend = new Character(name, description);
            cl.addChar(thelegend);
        }
    }


}
