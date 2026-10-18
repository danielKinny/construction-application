import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void getDay() {
        Date d = new Date(14,2,2008);
        assertEquals(14,d.getDay());
    }

    @Test
    void getMonth() {
        Date d = new Date(14,02,2008);
        assertEquals(2,d.getMonth());
    }

    @Test
    void getYear() {
        Date d = new Date(14,02,2008);
        assertEquals(2008,d.getYear());
    }

    @Test
    void testToString() {
        Date d = new Date(14,02,2008);
        assertEquals("14/02/2008",d.toString());

    }

    @Test
    void testEquals() {
        Date d = new Date(14,02,2008);

        Date d1 = new Date(14,02,2008);

        assertTrue(d.equals(d1));
    }

    @Test
    void testHashCode() {
        Date d = new Date(14,02,2008);

        Date d1 = new Date(14,02,2008);

        assertEquals(d.hashCode(),d1.hashCode());
    }
}