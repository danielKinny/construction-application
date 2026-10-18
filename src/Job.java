import java.util.Arrays;
import java.util.List;

public class Job {


    private int jobNumber;
    private static int jobTotal;
    private Address location;
    private String description;
    private List<Equipment> requiredEquipment;
    private Date plannedDate;

    public Job(Address location, String description, List<Equipment> requiredEquipment, Date plannedDate){
        this.location = location;
        this.description = description;
        this.requiredEquipment = requiredEquipment;
        this.plannedDate = plannedDate;

        jobTotal++;
        this.jobNumber = jobTotal;
    }


    public int getJobNumber() {
        return jobNumber;
    }

    public static int getJobTotal() {
        return jobTotal;
    }

    public Address getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }


    public String toString(){
        String equipmentString = "\n";
        for(Equipment e : this.requiredEquipment){
            equipmentString += e.toString() + "\n";
        }
        return this.location.toString() + ", the job description is " +this.description+ " using the following equipment: "+equipmentString+" and at the following date: "+plannedDate.toString();
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        } else {
            if (o!=null && o.getClass() == this.getClass()){
                Job that = (Job) o;
                return (this.plannedDate.equals(that.getPlannedDate()) && this.location.equals(that.getLocation()) && this.requiredEquipment.equals(that.getRequiredEquipment()) && this.description.equals(that.getDescription()));
            } else {
                return false;
            }
        }
    }

    public int hashCode(){
        return 31 * (this.description.hashCode() + this.location.hashCode() + this.requiredEquipment.hashCode() + this.plannedDate.hashCode());
    }
}
