package model;

import java.util.ArrayList;
import java.util.List;

// represents the list of characters that has not been put into any tiers, consists of a list of characters
public class CharacterList {
    final List<Character> characters;

    // requires: nothing
    // modifies: nothing
    // effect: constructs a CharacterList with an empty list of characters
    public CharacterList() {
        this.characters = new ArrayList<>();
    }

    // requires: nothing
    // modifies: nothing
    // effect: returns the list of characters
    public List<Character> getCharacters() {
        return this.characters;
    }

    // requires: name of a character that is in the character list
    // modifies: this
    // effect: removes the character from the character list
    public CharacterList removeCharacter(String s) {
        int w = 0;
        for (int count = 0; count < this.characters.size(); count++) {
            if (this.characters.get(count).getCharacterName().equals(s)) {
                w = count;
            }
        }
        this.characters.remove(w);
        return this;
    }

    // requires: nothing
    // modifies: this
    // effects: creates 5 characters, adds them to the character list
    public List<Character> createCharacters() {
        Character naruto = new Character("naruto", " (the hokage)");
        this.characters.add(naruto);
        Character goku = new Character("goku", " (in the hyperbolic time chamber)");
        this.characters.add(goku);
        Character makima = new Character("makima", " (very cool)");
        this.characters.add(makima);
        Character corey = new Character("corey", " (in the house)");
        this.characters.add(corey);
        Character kirito = new Character("your mother", ":)");
        this.characters.add(kirito);
        return this.characters;
    }

    // requires: nothing
    // modifies: nothing
    // effects: prints all characters in the list with their descriptions
    public String printCharacters() {
        String s = "<html><p>";
        for (Character c : this.characters) {
            s = s.concat(c.charAnddesc()).concat("<html><p>");
        }
        return s;
    }

    // requires: name of a character in the character list
    // modifies: nothing
    // effects: returns the character associated with the name
    public Character findChar(String ch) {
        int w = 0;
        for (int count = 0; count < this.characters.size(); count++) {
            if (characters.get(count).getCharacterName().equals(ch)) {
                w = count;
            }
        } // finds index location of character
        return characters.get(w);
    }

    // requires: nothing
    // modifies: this
    // effects: adds character to the characterlist
    public void addChar(Character c) {
        EventLog.getInstance().logEvent(new Event("Character created"));
        this.characters.add(c);
    }

    // requires: nothing
    // modifies: cl
    // effects, takes two characterlists cl and bl, removes elements of bl from cl
    public CharacterList removeCharacters(CharacterList cl, CharacterList bl) {
        for (Character b : bl.getCharacters()) {
            cl.removeCharacter(b.getCharacterName());
        }
        EventLog.getInstance().logEvent(new Event("Characters created"));
        return cl;
    }
}
