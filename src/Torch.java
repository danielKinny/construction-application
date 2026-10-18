public class Torch extends Equipment implements PowerSupply{
    public Torch(String j){
        super(j);
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        } else {
            if(o!=null && o.getClass() == this.getClass()){
                Torch that = (Torch) o;
                return (this.getRequirements().equals(that.getRequirements()));
            } else {
                return false;
            }
        }
    }

    public String getPowerSupply(){
        return "4.2W";
    }

    public int hashCode(){
        return 31*this.getRequirements().hashCode();
    }

    public String toString(){
        return "This is a torch and the requirements are "+this.getRequirements();
    }
}
