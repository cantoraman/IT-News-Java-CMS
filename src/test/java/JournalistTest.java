import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JournalistTest {

    Journalist journalist;

    @Before
    public void before(){
        journalist = new Journalist("Adam Hill", "Adam was born in...");
    }

    @Test
    public void hasName(){
        assertEquals("Adam Hill", journalist.getName());
    }

    @Test
    public void canSteName(){
        journalist.setName("Matt Kinley");
        assertEquals("Matt Kinley", journalist.getName());
    }

    @Test
    public void hasDescription(){
        assertEquals("Adam was born in...", journalist.getDescription());
    }

    @Test
    public void canSetDescription(){
        journalist.setDescription("His dog die in a car accident");
        assertEquals("His dog die in a car accident", journalist.getDescription());
    }
}
