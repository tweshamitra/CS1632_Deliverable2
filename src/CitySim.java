import java.util.ArrayList;
import java.util.Random;
public class CitySim {
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
            Driver d = new Driver(current_location);
            Avenue current_ave = d.getCurrentAvenue(current_location);;
            Street current_street = d.getCurrentStreet(current_location);
            while(!(current_location.getLocationName().equals("Outside City"))){
                starting_location = current_location;
                current_ave = d.getCurrentAvenue(current_location);
                current_street = d.getCurrentStreet(current_location);
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