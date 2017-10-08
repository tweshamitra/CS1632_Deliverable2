import java.util.ArrayList;
import java.util.Random;
public class CitySim {
    public static void main(String[] args){
        Random r = new Random();
        Random r2 = new Random();
        int seed = Integer.parseInt(args[0]);
        r.setSeed(seed);
        // try{
        //     seed = 
        //     r.setSeed(seed);
        // }catch (Exception e){
        //     System.out.println("Enter integer");
        // }
        Location hotel = new Location("Hotel");
        Location diner = new Location("Diner");
        Location library = new Location("Library");
        Location coffee = new Location("Coffee");
        Location philadelphia = new Location("Philadelphia");
        Location cleveland = new Location("Cleveland");
        Location starting_location, current_location;
        Location[] locations = {philadelphia,hotel, diner, library, coffee, cleveland};
        Street bill_st = new Street("Bill St.", hotel, library);
        Street phil_st = new Street("Phil St.", diner, coffee);
        //Avenue fourth_ave = new Avenue("Fourth Ave", hotel, diner);
        //Avenue fifth_ave = new Avenue("Fifth Ave", coffee, library);
        //ArrayList fourth_ave = new ArrayList(4);
        //ArrayList fifth_ave = new ArrayList(4);
        //ArrayList bill_st = new ArrayList(2);
        //ArrayList phil_st = new ArrayList(2);
        //fourth_ave.add(philadelphia);
        //fourth_ave.add(hotel);
        //fourth_ave.add(diner);
        //fourth_ave.add(cleveland);
        //fifth_ave.add(cleveland);
        //fifth_ave.add(coffee);
        //fifth_ave.add(library);
        //fifth_ave.add(philadelphia);
        for(int i =1; i<=5; i ++){
            starting_location = locations[r2.nextInt(3)+1];
            Driver d = new Driver(starting_location);
            current_location = starting_location;  
            Avenue current_ave = d.getCurrentAvenue(current_location);
            Street current_street = d.getCurrentStreet(current_location);
            // System.out.println(current_location.getLocationName());
            // System.out.println(current_ave.getAvenueName());
            // System.out.println(current_street.getStreetName());
            if(current_location == philadelphia || current_location ==cleveland){
                System.out.println("outside");
            }
            while((!(current_location.getLocationName().equals("Philadelphia"))) && (!(current_location.getLocationName().equals("Cleveland")))){
                if((r.nextInt(seed) %2) == 0){
                    starting_location = current_location;
                    current_location = current_street.getOtherLocation(current_location);
                    System.out.println("Driver " + i + " heading from " + starting_location.getLocationName() + " to " + current_location.getLocationName() + " via " + current_street.getStreetName() + ".");
                } else {
                    starting_location = current_location;
                    current_location = current_ave.getOtherLocation(current_ave, current_location);
                    //System.out.println(current_location.getLocationName());
                    System.out.println("Driver " + i + " heading from " + starting_location.getLocationName() + " to " + current_location.getLocationName() + " via " + current_ave.getAvenueName() + ".");
                }
                //System.out.println(r.nextInt(seed));           
            }
            System.out.println("----");
        }
    }   
}