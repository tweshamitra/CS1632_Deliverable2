//This class represents one way avenues
public class Avenue{
    public String name_of_avenue;
    private Location start; 
    private Location end;

    public Avenue(String name, Location start, Location end){
        name_of_avenue = name;
        this.start = start;
        this.end = end;
    }

    public String getAvenueName(){
        return name_of_avenue;
    }

    public String getStart(){
        return start.getLocationName();
    }

    public String getEnd(){
        return end.getLocationName();
    }
    
    /*  Given the current location, this method returns the location the driver is 
        allowed to go to via a one-way avenue. 
    */
    public Location getOtherLocation(Location loc){
        Location location_to_return = null;
        if(loc.getLocationName().equals(this.getStart())){
            location_to_return = this.end;
        }
        else if(loc.getLocationName().equals(this.getEnd())){
            location_to_return = new Location("Outside City");
        }
        return location_to_return;
    }
}