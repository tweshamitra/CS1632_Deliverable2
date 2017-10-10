import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StreetTest{
    Street test_street;
    Location l_1 = mock(Location.class);
    Location l_2 = mock(Location.class);

    @Before
    public void setup(){   
        test_street = new Street("Bill St.", l_1, l_2);
    }

    //Tests the constructor. If the constructor works correctly,
    //the object should not be null. 
    @Test 
    public void testStreetExists(){
        assertNotNull(test_street);
    }
    
    //Tests the getter for the street name.
    //This should be "Bill St" because the street that has been 
    //created in the setup is Bill St.
    @Test
    public void testGetStreetName(){
        assertEquals("Bill St.", test_street.getStreetName());
    }

    //This tests the getOtherLocation. 
    //It checks the other location that the driver can get to 
    //via the street.It should be Library in this case because
    //the driver is currenly at the Hotel.
    @Test
    public void testGetOtherLocationBillSt(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Library");
        assertEquals(test_street.getOtherLocation(l_1),l_2);
    }

    //This tests the getOtherLocation. 
    //It checks the other location that the driver can get to 
    //via the street.It should be Diner in this case because
    //the driver is currenly at the Coffee.
    @Test
    public void testGetOtherLocationPhilSt(){
        when(l_1.getLocationName()).thenReturn("Coffee");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_street.getOtherLocation(l_1), l_2);
    }

    @Test
    public void testGetOtherLocationBillStFlipped(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Library");
       assertEquals(test_street.getOtherLocation(l_1).getLocationName(), "Library");
    }

    @Test
    public void testGetOtherLocationPhilStFlipped(){
        when(l_1.getLocationName()).thenReturn("Coffee");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_street.getOtherLocation(l_2).getLocationName(), "Coffee");
    }
}