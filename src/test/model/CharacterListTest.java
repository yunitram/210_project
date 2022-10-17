package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterListTest {
    // test for remove character

    @Test
    void testremoveCharacter() {
        List<Character> testcharlist;
        CharacterList testy = new CharacterList();
        testcharlist = testy.createCharacters();
        testcharlist.remove(2);
        assertEquals(testcharlist.size(), 4);
        assertEquals(testcharlist.get(0), (testy.findChar("naruto")));
        testcharlist = testy.removeCharacter("goku");
        assertEquals(testcharlist.size(), 3);
        assertEquals(testcharlist.get(0), (testy.findChar("naruto")));
        assertEquals(testcharlist.get(1), (testy.findChar("corey")));
        assertEquals(testcharlist.get(2), (testy.findChar("kirito")));

    } // remove character OPERATES on a CharacterList, TAKES in a string and RETURNS a list of characters
      // minus the Character with the name of the string

}
