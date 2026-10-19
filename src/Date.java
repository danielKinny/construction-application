public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    public String toString(){
        return this.day+"-"+this.month+"-"+this.year;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        } else {
            if(o!=null && o.getClass() == this.getClass()){
                Date that = (Date) o;
                return (this.day == that.day && this.month == that.month && this.year == that.year);
            } else {
                return false;
            }
        }
    }

    public int hashCode(){
        return 31*(Integer.hashCode(this.day) + Integer.hashCode(this.month) + Integer.hashCode(this.year));
    }
}
