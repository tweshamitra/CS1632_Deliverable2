
public class Street{

    private String name_of_street;
    private Location first;
    private Location second;

    
    public Street(String name, Location first, Location second){
        name_of_street = name;
        this.first = first;
        this.second = second;
    }

    public String getStreetName(){
        return name_of_street;
    }

    public Location getOtherLocation(Location location){
        if(location.getLocationName().equals(first.getLocationName())){
            return this.second;
        }
        else return this.first;
    }
}