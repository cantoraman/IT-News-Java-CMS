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

    @Test
    public void canSteName(){
        journalist.setFirstName("Matt");
        assertEquals("Matt", journalist.getFirstName());
    }

    @Test
    public void hasLastName(){
        assertEquals("Hill", journalist.getLastName());
    }

    @Test
    public void canSetLastName(){
        journalist.setLastName("McAllan");
        assertEquals("McAllan", journalist.getLastName());
    }
}
