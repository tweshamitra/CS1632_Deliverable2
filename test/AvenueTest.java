import static org.junit.Assert.*;

import org.junit.*;

public class AvenueTest{
    Avenue test_avenue;

    @Before
    public void setup(){
        test_avenue = new Avenue("Fourth Ave");
    }

    @Test 
    public void testAvenueExists(){
        assertNotNull(test_avenue);
    }

    @Test
    public void testGetAvenue(){
        assertEquals("Fourth Ave", test_avenue.getAvenue());
    }
}