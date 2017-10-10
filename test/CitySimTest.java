import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CitySimTest{
    CitySim test_city_sim = new CitySim();

    @Test 
    public void testGetCurrentStreet(){
        Location l_1 = mock(Location.class);
        Location l_2 = mock(Location.class);
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Library");
        assertEquals(test_city_sim.getCurrentStreet(l_1), "Bill St");
    }

    /* I had some trouble with this test. I know that it's not ideal to call a method 
     * on a returned object, but I had some trouble refactoring the method in CitySim.java.
     * This probably happened due to the fact that it's slight hard coded. 
     */
    @Test
    public void testGetCurrentAvenue(){
        Location l_1 = mock(Location.class);
        Location l_2 = mock(Location.class);
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_city_sim.getCurrentAvenue(l_1,l_2).getAvenueName(), "Fourth Ave");
    }
}