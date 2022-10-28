package persistence;

import model.Tier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTier(String name, Tier tier) {
        assertEquals(name, tier.getName());

    }
}
