package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterListTest {
    // test for remove character
    // test case to remove one character from a characterlist of 5 characters
    @Test
    void testremoveCharacter() {
        CharacterList testy = new CharacterList();
        testy.createCharacters();
        testy.removeCharacter("goku");
        assertEquals(testy.getCharacters().size(), 4);
        assertEquals(testy.getCharacters().get(0), (testy.findChar("naruto")));
        assertEquals(testy.getCharacters().get(1), (testy.findChar("makima")));
        assertEquals(testy.getCharacters().get(2), (testy.findChar("corey")));
        assertEquals(testy.getCharacters().get(3), (testy.findChar("kirito")));
    }

    // test add a character to an empty character list
    @Test
    void testaddChar() {
        List<Character> testcharlist;
        CharacterList testy = new CharacterList();
        CharacterList testy1 = new CharacterList();
        testy.createCharacters();
        testy1.addChar(testy.findChar("naruto"));
        assertEquals(testy1.characters.size(), 1);
        assertEquals(testy1.characters.get(0), (testy.findChar("naruto")));
    }

    // test add a character to a non-empty character list
    @Test
    void testaddanotherChar() {
        List<Character> testcharlist;
        CharacterList testy = new CharacterList();
        CharacterList testy1 = new CharacterList();
        testy.createCharacters();
        testy1.addChar(testy.findChar("naruto"));
        assertEquals(testy1.characters.size(), 1);
        assertEquals(testy1.characters.get(0), (testy.findChar("naruto")));
        testy1.addChar(testy.findChar("makima"));
        assertEquals(testy1.characters.size(), 2);
        assertEquals(testy1.characters.get(0), (testy.findChar("naruto")));
        assertEquals(testy1.characters.get(1), (testy.findChar("makima")));
    }

    @Test
    void testfindChar() {
        List<Character > testcharlist;
        CharacterList testy = new CharacterList();
        Character testy1;
        testy.createCharacters();
        testy1 = testy.findChar("makima");
        assertEquals(testy1.getCharacterName(), "makima");
    }

    @Test
    void testprintCharacters() {
        CharacterList testy = new CharacterList();
        Character naruto = new Character("naruto", "the seventh");
        Character vegeta = new Character("vegeta", "the saiyan prince");
        testy.addChar(naruto);
        testy.addChar(vegeta);
        assertEquals(testy.printCharacters(), "naruto the seventh\nvegeta the saiyan prince\n");

    }

    @Test
    void testremoveCharacters() {
        CharacterList testy = new CharacterList();
        CharacterList testy1 = new CharacterList();
        Character naruto = new Character("naruto", "the seventh");
        Character vegeta = new Character("vegeta", "the saiyan prince");
        testy.addChar(naruto);
        testy.addChar(vegeta);
        assertEquals(testy.getCharacters().size(), 2);
        testy1.addChar(naruto);
        testy1.addChar(vegeta);
        testy.removeCharacters(testy, testy1);
        assertEquals(testy.getCharacters().size(), 0);

    }




}
