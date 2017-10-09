//This class represents one way avenues
public class Avenue{
    private String name_of_avenue;

    public Avenue(String name){
        name_of_avenue = name;
    }

    public String getAvenueName(){
        return name_of_avenue;
    }

    public Location getOtherLocation(Location loc){
        Location location_to_return = null;
        if(name_of_avenue.equals("Fourth Ave")){
            if(loc.getLocationName().equals("Hotel")){
                location_to_return =  new Location("Diner");
            }
            if(loc.getLocationName().equals("Diner")){
                location_to_return = new Location("Outside City");
            }
        }
       else{
            if(loc.getLocationName().equals("Coffee")){
                location_to_return =  new Location("Library");
            } 
            if(loc.getLocationName().equals("Library")){
                location_to_return = new Location("Outside City");
            }
        }
        return location_to_return;
    }
}