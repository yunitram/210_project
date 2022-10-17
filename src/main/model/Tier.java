package model;

import java.util.ArrayList;
import java.util.List;

// represents a Tier, consisting of a name and a list of characters
public class Tier {
    final List<Character> characters;
    private String tierName;

    // requires: nothing
    // modifies: nothing
    // effects: constructs a Tier with an empty list of Characters and empty String
    public Tier() {
        this.characters = new ArrayList<>();
        this.tierName = "";
    }

    // requires: a character in the CharacterList
    // modifies: this
    // effects: adds a character into the Tier
    public void addCharacter(Character c) {
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
    public void tierandchars() {
        System.out.println(this.tierName + ": " + this.charactersList() + " ");
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

}