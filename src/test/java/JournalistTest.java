import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JournalistTest {

    Journalist journalist;

    @Before
    public void before(){
        journalist = new Journalist("Adam", "Hill");
    }

    @Test
    public void hasName(){
        assertEquals("Adam", journalist.getFirstName());
    }
}
