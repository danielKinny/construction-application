import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMixerTest {

    @Test
    void testEquals() {
        ConcreteMixer ConcreteMixer = new ConcreteMixer("You must be over 18 years of age");
        ConcreteMixer ConcreteMixer2 = new ConcreteMixer("You must be over 18 years of age");
        assertTrue(ConcreteMixer.equals(ConcreteMixer2));
    }

    @Test
    void testHashCode() {
        ConcreteMixer ConcreteMixer = new ConcreteMixer("You must be over 18 years of age");
        ConcreteMixer ConcreteMixer2 = new ConcreteMixer("You must be over 18 years of age");
        assertEquals(ConcreteMixer.hashCode(),ConcreteMixer2.hashCode());
    }

    @Test
    void testToString() {
        ConcreteMixer ConcreteMixer = new ConcreteMixer("You must be over 18 years of age");
        assertEquals("This is a concrete mixer and the requirements are You must be over 18 years of age", ConcreteMixer.toString());
    }

    @Test
    void testGetRequirements(){
        ConcreteMixer ConcreteMixer = new ConcreteMixer("You must be over 18 years of age");
        assertEquals("You must be over 18 years of age",ConcreteMixer.getRequirements());
    }
}