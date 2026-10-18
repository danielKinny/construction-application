public class Address {

    private String street;
    private int number;
    private String zipCode;
    private String city;

    /**Address is a constructor that initiates key fields within the class
     *
     * @param street street name
     * @param number house number
     * @param zipCode address zip code
     * @param city string representing the city
     */
    public Address(String street, int number, String zipCode, String city){
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * getter for street name
     * @return value of street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * getter for house number
     * @return value of house number
     */
    public int getNumber() {
        return number;
    }

    /**
     * getter for zip code
     * @return zip code of house
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * getter for city name
     * @return name of city
     */
    public String getCity() {
        return city;
    }

    /**
     * converts object to string
     * @return string representation of object
     */
    public String toString(){
        return "The address for this job is in "+city+" on "+street+" number "+number+", which has the postcode: "+this.zipCode;
    }

    /**
     * checks if two objects are equal
     * @param o   the reference object with which to compare.
     * @return boolean representing equality between main and reference object
     */
    public boolean equals(Object o){

        if (o==this){
            return true;
        } else {
            if(o!=null && o.getClass() == this.getClass()){
                Address that = (Address) o;
                return (this.street.equals(that.getStreet()) && this.zipCode.equals(that.getZipCode()) && this.city.equals(that.getCity()) && this.number == that.getNumber() );
            } else {
                return false;
            }
        }

    }

    /**
     * generates a hashcode for an object
     * @return hashCode for the object
     */
    public int hashCode(){
        return 31*(this.city.hashCode() + Integer.hashCode(this.number) + this.zipCode.hashCode() + this.street.hashCode()  );
    }
}
