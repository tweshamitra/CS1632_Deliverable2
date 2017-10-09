import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AvenueTest{
    Avenue test_avenue;
    Location l_1 = mock(Location.class);
    Location l_2 = mock(Location.class);
    @Before
    public void setup(){
        test_avenue = new Avenue("Fourth Ave", l_1, l_2);
    }

    @Test 
    public void testAvenueExists(){
        assertNotNull(test_avenue);
    }

    @Test
    public void testGetAvenueName(){
        assertEquals("Fourth Ave", test_avenue.getAvenueName());
    }

    @Test
    public void testStartLocation(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        assertEquals(test_avenue.getStart(), "Hotel");
    }

    @Test
    public void testEndLocation(){
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_avenue.getEnd(), "Diner");
    }

    @Test
    public void testGetOtherLocationFourthAve(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_avenue.getOtherLocation(l_1).getLocationName(), "Diner" );
    }

    @Test
    public void testGetOtherLocationFourthAveFlipped(){
        when(l_1.getLocationName()).thenReturn("Hotel");
        when(l_2.getLocationName()).thenReturn("Diner");
        assertEquals(test_avenue.getOtherLocation(l_2).getLocationName(), "Outside City" );
    }

}