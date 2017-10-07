public class Location{
    private String name_of_location;

    public Location(){
        name_of_location = "";
    }
    
    public Location(String name){
        name_of_location = name;
    }

    public String getLocation(){
        return name_of_location;
    }
}