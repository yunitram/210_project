package model;

// represents a Character, with a name and a description
public class Character {

    final String characterName;
    final String description;

    // requires: nothing
    // modifies: nothing
    // effects: constructs a Character with a name and description.
    public Character(String characterName, String description) {
        this.characterName = characterName;
        this.description = description;
    }

    // requires: nothing
    // modifies: nothing
    // effects: returns the character description
    public String getDescription() {
        return this.description;
    }

    // requires: nothing.
    // modifies: nothing
    // effects: returns the character name
    public String getCharacterName() {
        return this.characterName;
    }

    // requires: nothing
    // modifies: nothing
    // effects: prints the character name and description
    public String charAnddesc() {
        return this.characterName + " " + this.description;
    }
}
