//This class represents one way avenues
public class Avenue{
    private String name_of_avenue;
    // private Location start;
    // private Location end;

    public Avenue(String name){
        name_of_avenue = name;
    }
    // public Avenue(String name, Location start, Location end){
    //     name_of_avenue = name;
    //     this.start = start;
    //     this.end = end;
    // }

    public String getAvenueName(){
        return name_of_avenue;
    }

    public Location getOtherLocation(Avenue ave, Location loc){
        if(ave.name_of_avenue.equals("Fourth Ave")){
            if(loc.getLocationName().equals("Hotel")){
                return new Location("Diner");
            }
            else// if(loc.getLocationName().equals("Diner"))
            {
                return new Location("Cleveland");
            }
        }
        else //if(ave.name_of_avenue.equals("Fifth Ave"))
        {
            if(loc.getLocationName().equals("Coffee")){
                return new Location("Library");
            }
            else //if(loc.getLocationName().equals("Library"))
            {
                return new Location("Philadelphia");
            }
        }
    }
}