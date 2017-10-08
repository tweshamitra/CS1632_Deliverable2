public class Location{
    private String name_of_location;

    public Location(){
        name_of_location = "";
    }
    
    public Location(String name){
        name_of_location = name;
    }

    public String getLocationName(){
        return this.name_of_location;
    }
}