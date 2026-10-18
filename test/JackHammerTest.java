import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JackHammerTest {

    @Test
    void testEquals() {
        JackHammer JackHammer = new JackHammer("You must be over 18 years of age");
        JackHammer JackHammer2 = new JackHammer("You must be over 18 years of age");
        assertTrue(JackHammer.equals(JackHammer2));
    }

    @Test
    void testHashCode() {
        JackHammer JackHammer = new JackHammer("You must be over 18 years of age");
        JackHammer JackHammer2 = new JackHammer("You must be over 18 years of age");
        assertEquals(JackHammer.hashCode(),JackHammer2.hashCode());
    }

    @Test
    void testToString() {
        JackHammer JackHammer = new JackHammer("You must be over 18 years of age");
        assertEquals("This is a jackhammer and the requirements are You must be over 18 years of age", JackHammer.toString());
    }
}