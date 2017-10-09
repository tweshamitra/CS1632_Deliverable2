import static org.junit.Assert.*;

import org.junit.*;

public class AvenueTest{
    Avenue test_avenue;
    Location l_1;

    @Before
    public void setup(){
        test_avenue = new Avenue("Fourth Ave");
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
    public void testGetOtherLocationNull(){
        l_1  = null;
        assertNull(test_avenue.getOtherLocation(l_1));
    }
}