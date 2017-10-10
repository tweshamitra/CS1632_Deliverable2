import static org.junit.Assert.*;

import org.junit.*;

public class LocationTest{
    Location test_class;

    @Before
    public void setup(){
        test_class = new Location("Hotel");
    }

    //This tests the constructor for the Location class.
    //The instance test_class should not be null because 
    //it has been initialized in the setup.
    @Test 
    public void testLocationExists(){
        assertNotNull(test_class);
    }

    //This tests the getLocationName method.
    //It should return Hotel because that's the Location 
    //that was instantiated in the setup method. 
    @Test
    public void testGetLocationName(){
        assertEquals("Hotel", test_class.getLocationName());
    }
    
    //Tests an empty string. It should still print out the string since
    //an empty string is not null
    @Test
    public void testEmtpyLocation(){
        Location test_location = new Location("");
        assertEquals(test_location.getLocationName(), "");
    }

    //test null location
    @Test 
    public void testNull(){
        Location test_location = null;
        assertNull(test_location);
    }

}