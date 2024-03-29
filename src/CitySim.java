import java.util.Random;
public class CitySim {

    public static Avenue getCurrentAvenue(Location curr, Location start){
        Avenue current_avenue = null;
        if((curr.getLocationName().equals("Hotel")) || (start.getLocationName().equals("Diner"))){
            current_avenue = new Avenue("Fourth Ave", new Location("Hotel"), new Location("Diner"));
        }
        else if((curr.getLocationName().equals("Library")) ||(start.getLocationName().equals("Coffee"))){
            current_avenue = new Avenue("Fifth Ave", new Location("Coffee"), new Location("Library"));
        }
        return current_avenue;
    }

    public static String getCurrentStreet(Location curr){
        if((curr.getLocationName().equals("Hotel")) || (curr.getLocationName().equals("Library"))){
            return "Bill St";
        }
        else return "Phil St";
    }
   
    public static void main(String[] args){
        if(args.length ==0 || args.length >1 ){
            System.out.println("Please enter one integer argument");
            System.exit(0);
        }      
        try{
            Integer.parseInt(args[0]);
        } catch(Exception e){
            System.out.println("Enter one integer argument");
            System.exit(0);
        }
        Random r = new Random();
        int seed = Integer.parseInt(args[0]);
        seed = seed*10;
        r.setSeed(seed);
        Location hotel = new Location("Hotel");
        Location diner = new Location("Diner");
        Location library = new Location("Library");
        Location coffee = new Location("Coffee");
        Location outside = new Location("Outside");
        Location starting_location, current_location;
        Location[] locations = {outside, hotel, diner, library, coffee, outside};
        for(int i =1; i<=5; i ++){
            current_location = locations[(r.nextInt(seed) % 4) + 1];
            starting_location = current_location;
            Avenue current_ave = null;
            Street current_street = null;
            while(!(current_location.getLocationName().equals("Outside City"))){
                 current_ave  = getCurrentAvenue(current_location, starting_location); 
                 current_street = new Street(getCurrentStreet(current_location), current_location, starting_location);
                if((r.nextInt(seed) %2) == 0){
                    current_location = current_street.getOtherLocation(current_location);
                    System.out.println("Driver " + i + " heading from " + starting_location.getLocationName() + " to " + current_location.getLocationName() + " via " + current_street.getStreetName() + ".");
                } else {
                    if(current_ave.getOtherLocation(current_location) == null){
                        current_location = current_street.getOtherLocation(current_location);
                        System.out.println("Driver " + i + " heading from " + starting_location.getLocationName() + " to " + current_location.getLocationName() + " via " + current_street.getStreetName() + ".");
                    }
                    else {
                        current_location = current_ave.getOtherLocation(current_location);
                        System.out.println("Driver " + i + " heading from " + starting_location.getLocationName() + " to " + current_location.getLocationName() + " via " + current_ave.getAvenueName() + ".");
                    }
                } 
                starting_location = current_location;
            }
            if(current_ave.getAvenueName().equals("Fourth Ave")){
                System.out.println("Driver " + i + " went to " + "Cleveland!");
            }
            else{
               System.out.println("Driver " + i + " went to " + "Philadelphia!");
            }
            System.out.println("----");
        }
    }   

}