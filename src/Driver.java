public class Driver{
    private Location starting_location;
    private Avenue current_ave;
    private Street current_street;

    public Driver(Location starting){
        this.starting_location = starting;
    }

    public Street getCurrentStreet(Location location){
        if((location.getLocationName().equals("Hotel")) ||(starting_location.getLocationName().equals("Library"))){
            current_street = new Street("Bill St", new Location("Hotel"), new Location("Library"));
        }
        else if((location.getLocationName().equals("Diner")) ||(starting_location.getLocationName().equals("Coffee"))){
            current_street = new Street("Phil St", new Location("Diner"), new Location("Coffee"));
        }
        return current_street;
    }

    public Avenue getCurrentAvenue(Location location){
        if((location.getLocationName().equals("Hotel")) || (starting_location.getLocationName().equals("Diner"))){
            current_ave = new Avenue("Fourth Ave");
        }
        else if((location.getLocationName().equals("Library")) ||(starting_location.getLocationName().equals("Coffee"))){
            current_ave = new Avenue("Fifth Ave");
        }
        return current_ave;
    }
}