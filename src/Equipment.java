public abstract class Equipment {
    private String requirements;
    public Equipment(String r){
        this.requirements = r;
    }

    public String getRequirements(){
        return this.requirements;
    }
}
