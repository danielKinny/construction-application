public class ScaffoldingTower extends Equipment{
    public ScaffoldingTower(String j){
        super(j);
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        } else {
            if(o!=null && o.getClass() == this.getClass()){
                ScaffoldingTower that = (ScaffoldingTower) o;
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
        return "This is a scaffolding tower and the requirements are "+this.getRequirements();
    }
}
