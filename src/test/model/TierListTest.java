package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TierListTest {
    // test case of finding a tier in tierlist with 5 entries
    @Test
    void testfindTier() {
        TierList testy = new TierList();
        new Tier();
        Tier testy1;
        testy.createElList();
        testy1 = testy.findTier("S");
        assertEquals(testy1.getName(), "S");
    }

    @Test
    void testgetPos() {
        TierList testy = new TierList();
        new Tier();
        testy.createElList();
        assertEquals(testy.getPos("S"), 0);
        assertEquals(testy.getPos("B"), 2);

    }


    // test the case of adding a tier to an empty tierlist
    @Test
    void testaddTier() {
        TierList testy = new TierList();
        assertEquals(testy.tiersList.size(), 0);
        testy.addTier("E");
        assertEquals(testy.tiersList.size(), 1);
        assertEquals(testy.tiersList.get(0).getName(), "E");
    }

    // test the case of adding a tier to a non-empty tierlist
    @Test
    void testaddanotherTier() {
        TierList testy = new TierList();
        testy.createElList();
        assertEquals(testy.tiersList.size(), 5);
        testy.addTier("G");
        assertEquals(testy.tiersList.size(), 6);
        assertEquals(testy.tiersList.get(5).getName(), "G");
    }

    @Test
    void testswapTiers() {
        TierList testy = new TierList();
        new Tier();
        testy.createElList();
        assertEquals(testy.getPos("S"), 0);
        assertEquals(testy.getPos("D"), 4);
        testy.swapTiers("S", "D");
        assertEquals(testy.getPos("S"), 4);
        assertEquals(testy.getPos("D"), 0);
    }
}