package persistence;

import model.Character;
import model.CharacterList;
import model.Tier;
import model.TierList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            TierList tl = new TierList("Tierlist 1");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    // tests writer with an empty tierlist and a tierlist with empty tiers
    @Test
    void testWriterEmptyWorkroom() {
        try {
            TierList tl = new TierList("Tierlist 1");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTierList1.json");
            writer.open();
            writer.write(tl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTierList1.json");
            tl = reader.read();
            assertEquals("Tierlist 1", tl.getName());
            assertEquals(0, tl.getTiers().size());
            tl.createElList();
            assertEquals(5, tl.getTiers().size());
            assertEquals(0, tl.getTiers().get(0).getCharacters().size());
            assertEquals(0, tl.getTiers().get(1).getCharacters().size());
            assertEquals(0, tl.getTiers().get(2).getCharacters().size());
            assertEquals(0, tl.getTiers().get(3).getCharacters().size());
            assertEquals(0, tl.getTiers().get(4).getCharacters().size());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            TierList tl = new TierList("Tierlist 1");
            CharacterList cl = new CharacterList();
            cl.createCharacters();
            Character naruto = new Character("naruto", "the hokage");
            Character makima = new Character("makima", "i LOVE her <33");
            tl.createElList();
            tl.getTiers().get(0).addCharacter(makima);
            tl.getTiers().get(2).addCharacter(naruto);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTierList1.json");
            writer.open();
            writer.write(tl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTierList1.json");
            tl = reader.read();
            cl = reader.find();
            List<Tier> tiers = tl.getTiers();
            assertEquals("Tierlist 1", tl.getName());
            assertEquals(1, tiers.get(0).getCharacters().size());
            assertEquals("makima", tiers.get(0).getCharacters().get(0).getCharacterName());
            assertEquals(0, tiers.get(1).getCharacters().size());
            assertEquals(1, tiers.get(2).getCharacters().size());
            assertEquals("naruto", tiers.get(2).getCharacters().get(0).getCharacterName());
            assertEquals(0, tiers.get(3).getCharacters().size());
            assertEquals(0, tiers.get(4).getCharacters().size());
            assertEquals(2, cl.getCharacters().size());
            assertEquals("makima", cl.getCharacters().get(0).getCharacterName());
            assertEquals("naruto", cl.getCharacters().get(1).getCharacterName());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}