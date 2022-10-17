package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    // test case of printing out a characters name and description
    @Test
    void testcharAnddesc() {
        Character testy = new Character("naruto","the hokage");
        testy.charAnddesc();
        assertEquals(testy.charAnddesc(),"naruto the hokage");


    }
}
