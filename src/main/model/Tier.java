package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// represents a Tier, consisting of a name and a list of characters
public class Tier implements Writable {
    final List<Character> characters;
    private String tierName;

    // requires: nothing
    // modifies: nothing
    // effects: constructs a Tier with an empty list of Characters and empty String
    public Tier() {
        this.characters = new ArrayList<>();
        this.tierName = "";
    }

    public List<Character> getCharacters() {
        return this.characters;
    }

    // requires: a character in the CharacterList
    // modifies: this
    // effects: adds a character into the Tier
    public void addCharacter(Character c) {
        EventLog.getInstance().logEvent(new Event("Character added to tier"));
        this.characters.add(c);
    }

    // requires: the name of a character in a Tier
    // modifies: this
    // effects: removes the character associated with the given name, returns the list of characters in the tier
    public void removeCharacterfromtier(String s) {
        int w = 0;
        for (int count = 0; count < this.characters.size(); count++) {
            if (this.characters.get(count).getCharacterName().equals(s)) {
                w = count;
            }
        }
        EventLog.getInstance().logEvent(new Event("Character removed from tier"));
        this.characters.remove(w);
    }

    // requires: nothing
    // modifies: this
    // effects: retrieves the name of the Tier
    public String getName() {
        return this.tierName;
    }

    // requires: nothing
    // modifies: this
    // effects: renames the tier
    public void renameTier(String t) {
        this.tierName = t;
    }

    // requires: nothing
    // modifies: nothing
    // effects: returns all the characters in the tier
    public String charactersList() {
        String s = "";
        for (Character c: this.characters) {
            s = s.concat(c.getCharacterName() + " ");
        }
        return s;
    }

    // requires: nothing
    // modifies: nothing
    // effects: prints out the tier name followed by the characters in the tier
    public String tierandchars() {
        String s = "";
        return s.concat(this.tierName).concat(": ").concat(this.charactersList());
    }

    // requires: name of a character in the Tier
    // modifies: nothing
    // effects: finds the character with the name in the tier, returns it
    public Character findCharintier(String ch) {
        int w = 0;
        for (int count = 0; count < this.characters.size(); count++) {
            if (characters.get(count).getCharacterName().equals(ch)) {
                w = count;
            }
        }
        return this.characters.get(w);
    }

    // requires: nothing
    // modifies: nothing
    // effects: takes a tier and converts it into a JSONObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", tierName);
        json.put("tiercontent", characters);
        return json;
    }

}
