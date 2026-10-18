import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
class JobTest {

    @Test
    void getJobNumber() {

        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);
        Job that = new Job(new Address("Lange Geer 8",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) );
        assertNotNull(that.getJobNumber());

    }

    @Test
    void getJobTotal() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);
        Job that = new Job(new Address("Lange Geer 8",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) );
        assertNotNull(Job.getJobTotal());
    }

    @Test
    void getLocation() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);
        Job that = new Job(new Address("Lange Geer",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) );
        assertEquals(new Address("Lange Geer",8,"2611PV","Delft"), that.getLocation());
    }

    @Test
    void getDescription() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);
        Job that = new Job(new Address("Lange Geer 8",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) );
        assertEquals("description",that.getDescription());
    }

    @Test
    void getRequiredEquipment() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);
        Job that = new Job(new Address("Lange Geer 8",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) );
        assertTrue(al.equals(that.getRequiredEquipment()));
    }

    @Test
    void getPlannedDate() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);
        Job that = new Job(new Address("Lange Geer 8",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) );
        assertTrue(that.getPlannedDate().equals(new Date(14,02,2008)));
    }

    @Test
    void testToString() {
        JackHammer jh = new JackHammer("18 to use this");
        ConcreteMixer cm = new ConcreteMixer("18 to use this");
        ArrayList<Equipment> al = new ArrayList<Equipment>();
        al.add(jh);
        al.add(cm);
        Job that = new Job(new Address("Lange Geer",8,"2611PV","Delft"),"description", al, new Date(14,2,2008) );

        String equipmentString = "\n";
        for(Equipment e : al){
            equipmentString += e.toString() + "\n";
        }


        assertEquals("The address for this job is in Delft on Lange Geer number 8, which has the postcode: 2611PV, the job description is description using the following equipment: "+equipmentString+" and at the following date: 14/2/2008",that.toString());
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}