import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaffoldingTowerTest {

    @Test
    void testEquals() {
        ScaffoldingTower ScaffoldingTower = new ScaffoldingTower("You must be over 18 years of age");
        ScaffoldingTower ScaffoldingTower2 = new ScaffoldingTower("You must be over 18 years of age");
        assertTrue(ScaffoldingTower.equals(ScaffoldingTower2));
    }

    @Test
    void testHashCode() {
        ScaffoldingTower ScaffoldingTower = new ScaffoldingTower("You must be over 18 years of age");
        ScaffoldingTower ScaffoldingTower2 = new ScaffoldingTower("You must be over 18 years of age");
        assertEquals(ScaffoldingTower.hashCode(),ScaffoldingTower2.hashCode());
    }

    @Test
    void testToString() {
        ScaffoldingTower ScaffoldingTower = new ScaffoldingTower("You must be over 18 years of age");
        assertEquals("This is a scaffolding tower and the requirements are You must be over 18 years of age", ScaffoldingTower.toString());
    }
}