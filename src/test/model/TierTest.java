package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TierTest {


    // test case: adding a character to an empty list
    @Test
    void testaddCharacter() {
        List<Character> testaddlist;
        Tier testy = new Tier();
        CharacterList testy1 = new CharacterList();
        testaddlist = testy1.createCharacters();
        testy.addCharacter(testaddlist.get(0));
        assertEquals(testy.characters.size(), 1);
        assertEquals(testaddlist.get(0), (testy1.findChar("naruto")));
    }

    // test case: adding a character to an non-empty list
    @Test
    void testaddsecondCharacter() {
        List<Character> testaddlist;
        Tier testy = new Tier();
        CharacterList testy1 = new CharacterList();
        testaddlist = testy1.createCharacters();
        testy.addCharacter(testaddlist.get(0));
        testy.addCharacter(testaddlist.get(1));
        assertEquals(testy.characters.size(), 2);
        assertEquals(testaddlist.get(0), (testy1.findChar("naruto")));
        assertEquals(testaddlist.get(1), (testy1.findChar("goku")));
    }

    // test case: remove a character from a list
    @Test
    void testremoveCharacterfromtier() {
        List<Character> testaddlist;
        Tier testy = new Tier();
        CharacterList testy1 = new CharacterList();
        testaddlist = testy1.createCharacters();
        testy.addCharacter(testaddlist.get(0));
        assertEquals(testy.characters.size(), 1);
        assertEquals(testaddlist.get(0), (testy1.findChar("naruto")));
        testy.removeCharacterfromtier("naruto");
        assertEquals(testy.characters.size(), 0);

    }

}
