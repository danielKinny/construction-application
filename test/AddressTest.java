import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void getStreet() {
        Address a = new Address("Lange Geer", 8, "2611PV","Delft");
        assertEquals("Lange Geer",a.getStreet());
    }

    @Test
    void getNumber() {
        Address a = new Address("Lange Geer", 8, "2611PV","Delft");
        assertEquals(8,a.getNumber());
    }

    @Test
    void getZipCode() {
        Address a = new Address("Lange Geer", 8, "2611PV","Delft");
        assertEquals("2611PV",a.getZipCode());
    }

    @Test
    void getCity() {
        Address a = new Address("Lange Geer", 8, "2611PV","Delft");
        assertEquals("Delft", a.getCity());
    }

    @Test
    void testToString() {
        Address a = new Address("Lange Geer", 8, "2611PV","Delft");
        assertEquals("The address is in Delft on Lange Geer number 8, which has the postcode: 2611PV",a.toString());
    }

    @Test
    void testEquals() {
        Address a = new Address("Lange Geer", 8, "2611PV","Delft");
        Address a1 = new Address("Lange Geer", 8, "2611PV","Delft");
        assertTrue(a.equals(a1));
    }

    @Test
    void testHashCode() {
        Address a = new Address("Lange Geer", 8, "2611PV","Delft");
        int hash = a.hashCode();
        Address a1 = new Address("Lange Geer", 8, "2611PV","Delft");
        assertEquals(a1.hashCode(), hash);
    }
}