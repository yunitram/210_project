package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TierListTest {
    // test case of finding a tier in tierlist with 5 entries
    @Test
    void testfindTier() {
        TierList testy = new TierList("tierlist 1");
        new Tier();
        Tier testy1;
        testy.createElList();
        testy1 = testy.findTier("S");
        assertEquals(testy1.getName(), "S");
    }

    @Test
    void testgetPos() {
        TierList testy = new TierList("tierlist 1");
        new Tier();
        testy.createElList();
        assertEquals(testy.getPos("S"), 0);
        assertEquals(testy.getPos("B"), 2);

    }


    // test the case of adding a tier to an empty tierlist
    @Test
    void testaddTier() {
        TierList testy = new TierList("tierlist 1");
        assertEquals(testy.tiersList.size(), 0);
        testy.addTier("E");
        assertEquals(testy.tiersList.size(), 1);
        assertEquals(testy.tiersList.get(0).getName(), "E");
    }

    // test the case of adding a tier to a non-empty tierlist
    @Test
    void testaddanotherTier() {
        TierList testy = new TierList("tierlist 1");
        testy.createElList();
        assertEquals(testy.tiersList.size(), 5);
        testy.addTier("G");
        assertEquals(testy.tiersList.size(), 6);
        assertEquals(testy.tiersList.get(5).getName(), "G");
    }

    // test the case of swapping tier positions in the tierlist
    @Test
    void testswapTiers() {
        TierList testy = new TierList("tierlist 1");
        new Tier();
        testy.createElList();
        assertEquals(testy.getPos("S"), 0);
        assertEquals(testy.getPos("D"), 4);
        testy.swapTiers("S", "D");
        assertEquals(testy.getPos("S"), 4);
        assertEquals(testy.getPos("D"), 0);
    }


    @Test
    void testprintTiers() {
        TierList testy = new TierList("tierlist 1");
        Character naruto = new Character("naruto", "the seventh");
        Character vegeta = new Character("vegeta", "the saiyan prince");
        testy.addTier("S");
        testy.findTier("S").addCharacter(vegeta);
        testy.addTier("A");
        testy.findTier("A").addCharacter(naruto);
        assertEquals(testy.printTiers(), "S: vegeta \nA: naruto \n");

    }

    @Test
    void testAddFilledTier() {
        TierList tl = new TierList("better to cum in the sink");
        Tier t = new Tier();
        t.renameTier("than to sink in the cum");
        tl.addFilledTier(t);
        assertEquals(1, tl.getTiers().size());
        assertEquals(tl.getTiers().get(0).getName(), "than to sink in the cum");

    }

    @Test
    void testToJson() {
        TierList tl = new TierList("poopybutthole");
        tl.createElList();
        JSONObject json = tl.toJson();
        assertEquals(json.getString("name"), "poopybutthole");
        JSONArray jtiers = json.getJSONArray("tiers");
        JSONObject tier = (JSONObject) jtiers.get(0);
        assertEquals(tier.getString("name"), "S");
        JSONObject tier1 = (JSONObject) jtiers.get(1);
        assertEquals(tier1.getString("name"), "A");
        JSONObject tier2 = (JSONObject) jtiers.get(2);
        assertEquals(tier2.getString("name"), "B");
        JSONObject tier3 = (JSONObject) jtiers.get(3);
        assertEquals(tier3.getString("name"), "C");
        JSONObject tier4 = (JSONObject) jtiers.get(4);
        assertEquals(tier4.getString("name"), "D");
    }


}