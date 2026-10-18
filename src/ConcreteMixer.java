public class ConcreteMixer extends Equipment{
    public ConcreteMixer(String j){
        super(j);
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        } else {
            if(o!=null && o.getClass() == this.getClass()){
                ConcreteMixer that = (ConcreteMixer) o;
                return (this.getRequirements().equals(that.getRequirements()));
            } else {
                return false;
            }
        }
    }

    public int hashCode(){
        return 31*this.getRequirements().hashCode();
    }

    public String toString(){
        return "This is a concrete mixer and the requirements are "+this.getRequirements();
    }
}
