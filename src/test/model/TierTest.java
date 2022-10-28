package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // test case: find a character in a tier
    @Test
    void testfindCharintier() {
        List<Character > testcharlist;
        Tier testy = new Tier();
        Character testy1 = new Character("naruto","the hokage");
        Character testy2 = new Character("goku","the strongest saiyan");
        testy.addCharacter(testy1);
        testy.addCharacter(testy2);
        assertEquals(testy1, testy.findCharintier("naruto"));
        assertEquals(testy2, testy.findCharintier("goku"));


    }

    // test case: test characterslist
    @Test
    void testcharactersList() {
        List<Character > testcharlist;
        Tier testy = new Tier();
        Character testy1 = new Character("naruto","the hokage");
        Character testy2 = new Character("goku","the strongest saiyan");
        testy.addCharacter(testy1);
        testy.addCharacter(testy2);
        assertEquals(testy.charactersList(), "naruto goku ");


    }

    // test case: test renaming a tier
    @Test
    void testrenameTier() {
        Tier testy = new Tier();
        testy.renameTier("the goat");
        assertEquals(testy.getName(), "the goat");


    }

    // test case: returning a tier and its contents
    @Test
    void testtiersandchars() {
        Tier testy = new Tier();
        Character makima = new Character("makima", "would die for her");
        testy.renameTier("god tier");
        testy.addCharacter(makima);
        assertEquals(testy.tierandchars(), "god tier: makima ");
    }

    @Test
    void testToJson() {
        Character makima = new Character("makima", "would die for her");
        Tier t = new Tier();
        t.addCharacter(makima);
        t.renameTier("oh yeah ive got a big one");
        assertEquals(t.toJson().getString("name"), "oh yeah ive got a big one");
        JSONArray characterlist = t.toJson().getJSONArray("tiercontent");
        JSONObject jcharacter = (JSONObject) characterlist.get(0);
        assertEquals(jcharacter.get("characterName"), "makima");
        assertEquals(jcharacter.get("description"), "would die for her");
    }

    @Test
    void testToJsonemptyTier() {
        Tier t = new Tier();
        t.renameTier("oh yeah ive got a big one");
        assertEquals(t.toJson().getString("name"), "oh yeah ive got a big one");
        JSONArray characterlist = t.toJson().getJSONArray("tiercontent");
        assertTrue(characterlist.isEmpty());
    }

}
