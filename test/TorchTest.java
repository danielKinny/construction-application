import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorchTest {

    @Test
    void testEquals() {
        Torch Torch = new Torch("You must be over 18 years of age");
        Torch Torch2 = new Torch("You must be over 18 years of age");
        assertTrue(Torch.equals(Torch2));
    }

    @Test
    void testHashCode() {
        Torch Torch = new Torch("You must be over 18 years of age");
        Torch Torch2 = new Torch("You must be over 18 years of age");
        assertEquals(Torch.hashCode(),Torch2.hashCode());
    }

    @Test
    void testToString() {
        Torch Torch = new Torch("You must be over 18 years of age");
        assertEquals("This is a torch and the requirements are You must be over 18 years of age", Torch.toString());
    }
}