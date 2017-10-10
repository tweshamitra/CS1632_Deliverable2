import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CitySimTest{
    CitySim test_city_sim = new CitySim();
    
    //This test the getCurrentStreet and makes sure that it returns
    //the correct street that the driver is at, based on the driver's location.
    //It should equals Bill St because the driver is at Hotel.
    @Test 
    public void testGetCurrentStreet(){
        Location l_1 = mock(Location.class);
        when(l_1.getLocationName()).thenReturn("Hotel");
        assertEquals(test_city_sim.getCurrentStreet(l_1), "Bill St");
    }
    
    //This test the getCurrentStreet and makes sure that it returns
    //the correct street that the driver is at, based on the driver's location.
    //It should equals Phil St because the driver is at  diner
    @Test 
    public void testGetCurrentStreetDiner(){
        Location l_1 = mock(Location.class);
        when(l_1.getLocationName()).thenReturn("Diner");
        assertEquals(test_city_sim.getCurrentStreet(l_1), "Phil St");
    }

    //This test the getCurrentStreet and makes sure that it returns
    //the correct street that the driver is at, based on the driver's location.
    //It should equal Phil St because the driver is at coffee.
    @Test 
    public void testGetCurrentStreetCoffee(){
        Location l_1 = mock(Location.class);
        when(l_1.getLocationName()).thenReturn("Coffee");
        assertEquals(test_city_sim.getCurrentStreet(l_1), "Phil St");
    }

    //This test the getCurrentStreet and makes sure that it returns
    //the correct street that the driver is at, based on the driver's location.
    //It should equals bill St because the driver is at the library
    @Test 
    public void testGetCurrentStreetLibrary(){
        Location l_1 = mock(Location.class);
        when(l_1.getLocationName()).thenReturn("Library");
        assertEquals(test_city_sim.getCurrentStreet(l_1), "Bill St");
    }

    //I had some trouble with this test. I know that it's not ideal to call a method 
    //on a returned object, but I had some trouble refactoring the method in CitySim.java.
    //This probably happened due to the fact that it's slight hard coded. 
    @Test
    public void testGetCurrentAvenue(){
        Location l_1 = mock(Location.class);
        Location l_2 = mock(Location.class);
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_city_sim.getCurrentAvenue(l_1,l_2).getAvenueName(), "Fourth Ave");
    }
}