import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AvenueTest{
    Location l_1 = mock(Location.class);
    Location l_2 = mock(Location.class);
    Avenue test_avenue;//  = new Avenue("Fourth Ave", l_1, l_2);

  
    @Before
    public void setUp(){
        test_avenue = new Avenue("Fourth Ave", l_1, l_2);
    }

    //Tests whether the constructor for Avenue works and makes an object.
    //The object should not be null.
    @Test 
    public void testAvenueExists(){
        assertNotNull(test_avenue);
    }

    //Tests the getAvenueName method for the Avenue class.
    //For this instance of the class, the method should return 
    //"Fourth Ave" because that's what it is initialized to in the constructor.
    @Test
    public void testGetAvenueName(){
        assertEquals("Fourth Ave", test_avenue.getAvenueName());
    }

    //Tests the first location of the avenue since this is a one way avenue.
    //In this instance, the location should be hotel because 4th avenue 
    //goes from Hotel to Diner. 
    @Test
    public void testStartLocation(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        assertEquals(test_avenue.getStart(), "Hotel");
    }

    //Test the second location of the avenue. 
    //In this instance, it should be diner since that's what it is initialized to.
    @Test
    public void testEndLocation(){
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_avenue.getEnd(), "Diner");
    }

    //This test makes sure that if the driver is at the Hotel,
    //the only place the driver can get to is Diner from the Hotel 
    //via fourth avenue.
    @Test
    public void testGetOtherLocationFourthAve(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_avenue.getOtherLocation(l_1), l_2);
    }

    //This test makes sure that if the driver is at the Coffee,
    //the only place the driver can get to is Diner from the Library 
    //via fifth avenue. It should be equal to the second location. 
    @Test
    public void testGetOtherLocationFifthAve(){
        when(l_1.getLocationName()).thenReturn("Coffee");
        when(l_2.getLocationName()).thenReturn("Library");
        assertEquals(test_avenue.getOtherLocation(l_1), l_2);
    }

    //This tests what happens when the driver goes to outside city 
    //if the driver is on an avenue. In this test, the driver should go 
    //outside because the driver is at the diner and and fourth ave is a 
    //one way avenue.
    @Test
    public void testGetOtherLocationFourthAveFlipped(){
        when(l_1.getLocationName()).thenReturn("Diner");
        when(l_2.getLocationName()).thenReturn("Outside");
        assertEquals(test_avenue.getOtherLocation(l_1), l_2);
    }

}