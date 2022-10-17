package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterListTest {
    // test for remove character
    // test case to remove one character from a characterlist of 5 characters
    @Test
    void testremoveCharacter() {
        List<Character> testcharlist;
        CharacterList testy = new CharacterList();
        testy.createCharacters();
        testcharlist = testy.removeCharacter("goku");
        assertEquals(testcharlist.size(), 4);
        assertEquals(testcharlist.get(0), (testy.findChar("naruto")));
        assertEquals(testcharlist.get(1), (testy.findChar("makima")));
        assertEquals(testcharlist.get(2), (testy.findChar("corey")));
        assertEquals(testcharlist.get(3), (testy.findChar("kirito")));
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




}
