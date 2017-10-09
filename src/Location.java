/*  This class stores information about a location. It simply has a method to 
    return the name of the location. 
*/
public class Location{
    private String name_of_location;

    public Location(String name){
        name_of_location = name;
    }

    public String getLocationName(){
        return this.name_of_location;
    }
}