import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JobCatalogTest {

    @Test
    void testGetJobs() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);

        JobCatalog jc = new JobCatalog();
        jc.getJobs().add(new Job(new Address("Lange Geer 8",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) ));
        assertNotNull(jc.getJobs());
    }

    @Test
    void testToString() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);

        JobCatalog jc = new JobCatalog();
        jc.getJobs().add(new Job(new Address("Lange Geer 8",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) ));
        assertEquals("The catalog contains the following jobs: \nThe address for this job is in Delft on Lange Geer 8 number 8, which has the postcode: 2611PV, the job description is description using the following equipment: \nThis is a jackhammer and the requirements are 18 to use this\nThis is a concrete mixer and the requirements are 18 to use this\n and at the following date: 14/2/2008\n",jc.toString());


    }

    @Test
    void testEquals() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);

        JobCatalog jc = new JobCatalog();
        JobCatalog jc2 = new JobCatalog();

        assertTrue(jc.equals(jc2));
    }

    @Test
    void testHashCode() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);

        JobCatalog jc = new JobCatalog();
        JobCatalog jc2 = new JobCatalog();

        assertEquals(jc.hashCode(),jc2.hashCode());
    }
}