public class JackHammer extends Equipment implements PowerSupply{
    public JackHammer(String j){
        super(j);
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        } else {
            if(o!=null && o.getClass() == this.getClass()){
                JackHammer that = (JackHammer) o;
                return (this.getRequirements().equals(that.getRequirements()));
            } else {
                return false;
            }
        }
    }

    public String getPowerSupply(){
        return "4.6W";
    }

    public int hashCode(){
        return 31*this.getRequirements().hashCode();
    }

    public String toString(){
        return "This is a jackhammer and the requirements are "+this.getRequirements();
    }
}
