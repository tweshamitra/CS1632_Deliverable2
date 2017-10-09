/*This class stores information about a two-way street
*/
public class Street{

    private String name_of_street;
    private Location first;
    private Location second;

    /*  This constructor initializes a street that connects two locations, specified
        by the user.
    */
    public Street(String name, Location first, Location second){
        name_of_street = name;
        this.first = first;
        this.second = second;
    }

    public String getStreetName(){
        return name_of_street;
    }
    //Given the current location, this method returns the location the driver is allowed to go to.
    public Location getOtherLocation(Location location){
        if(location.getLocationName().equals(first.getLocationName())){
            return this.second;
        }
        else return this.first;
    }
}