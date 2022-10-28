package persistence;

import model.CharacterList;
import model.Tier;
import model.TierList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TierList tl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTierList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTierList.json");
        try {
            TierList tl = reader.read();
            List<Tier> tiers = tl.getTiers();
            assertEquals("Tierlist 1", tl.getName());
            assertEquals(0, tiers.get(0).getCharacters().size());
            assertEquals(0, tiers.get(1).getCharacters().size());
            assertEquals(0, tiers.get(2).getCharacters().size());
            assertEquals(0, tiers.get(3).getCharacters().size());
            assertEquals(0, tiers.get(4).getCharacters().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTierList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTierList.json");
        CharacterList cl = new CharacterList();
        cl.createCharacters();
        assertEquals(5, cl.getCharacters().size());
        try {
            TierList tl = reader.read();
            cl = reader.find();
            List<Tier> tiers = tl.getTiers();
            assertEquals("Tierlist 1", tl.getName());
            assertEquals(0, tiers.get(0).getCharacters().size());
            assertEquals(1, tiers.get(1).getCharacters().size());
            assertEquals("goku", tiers.get(1).getCharacters().get(0).getCharacterName());
            assertEquals(0, tiers.get(2).getCharacters().size());
            assertEquals(1, tiers.get(3).getCharacters().size());
            assertEquals("makima", tiers.get(3).getCharacters().get(0).getCharacterName());
            assertEquals(0, tiers.get(4).getCharacters().size());
            assertEquals(2, cl.getCharacters().size());
            assertEquals("goku", cl.getCharacters().get(0).getCharacterName());
            assertEquals("makima", cl.getCharacters().get(1).getCharacterName());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}