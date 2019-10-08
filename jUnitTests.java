import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.*;

public class jUnitTests extends TestCase {

    //1---
    @Test
    public void testTrackRollDice() {
        Track track = new Track();
        int result = track.rollDice();

        assertTrue("Error result is too high", result <= 9);
        assertTrue("Error result is too low", result >= 0);
    }
    
    @Test
    public void testTrackGenDisasterTrue() {
        Track track = new Track();

        track.genDisaster(7);
        assertTrue("Error unexpected result", track.getDisaster());
    }

    @Test
    public void testTrackGenDisasterFalse() {
        Track track = new Track();

        track.genDisaster(5);
        assertFalse("Error unexpected result", track.getDisaster());
        track.genDisaster(-1);
        assertFalse("Error unexpected result", track.getDisaster());
        track.genDisaster(10);
        assertFalse("Error unexpected result", track.getDisaster());
    }

    //2---

  
}