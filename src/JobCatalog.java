import java.util.ArrayList;
import java.util.List;

public class JobCatalog {
    private List<Job> jobs;

    public JobCatalog(){
        this.jobs = new ArrayList<Job>();
    }

    public List<Job> getJobs(){
        return this.jobs;
    }

    public String toString(){
        String jobsString = "\n";
        for(Job j: this.jobs){
            jobsString += j.toString() + "\n";
        }

        return "The catalog contains the following jobs: "+jobsString;
    }

    public boolean equals(Object o){
        if (o==this){
            return true;
        } else {
            if (o!=null && this.getClass() == o.getClass()){
                JobCatalog that = (JobCatalog) o;
                return this.jobs.equals(that.getJobs());
            } else {
                return false;
            }
        }
    }

    public int hashCode(){
        return this.jobs.hashCode();
    }
}
