import static org.junit.Assert.*;

import org.junit.*;

public class LocationTest{
    Location test_class;

    @Before
    public void setup(){
        test_class = new Location("Hotel");
    }

    @Test 
    public void testLocationExists(){
        assertNotNull(test_class);
    }

    @Test
    public void testGetLocationName(){
        assertEquals("Hotel", test_class.getLocationName());
    }

    @Test
    public void testEmtpyLocation(){
        Location test = new Location("");
        assertEquals(test.getLocationName(), "");
    }
}