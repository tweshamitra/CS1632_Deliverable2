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

    @Test 
    public void testStreetExists(){
        assertNotNull(test_street);
    }
    
    @Test
    public void testGetStreetName(){
        assertEquals("Bill St.", test_street.getStreetName());
    }

    @Test
    public void testGetOtherLocationBillSt(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Library");
        assertEquals(test_street.getOtherLocation(l_1).getLocationName(), "Library");
    }

    @Test
    public void testGetOtherLocationPhilSt(){
        when(l_1.getLocationName()).thenReturn("Coffee");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_street.getOtherLocation(l_1).getLocationName(), "Diner");
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