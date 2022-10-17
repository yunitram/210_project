package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    @Test
    void testgetCharactername() {
        Character testy = new Character("naruto" , "the hokage");
        assertEquals(testy.getCharacterName(), "naruto");
    }

    @Test
    void testgetDescription() {
        Character testy = new Character("naruto" , "the hokage");
        assertEquals(testy.getDescription(), "the hokage");
    }



    }

