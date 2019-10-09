import junit.framework.TestCase;
import static org.junit.Assert.*;

import java.beans.Transient;

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
    @Test
    public void testTrackNotFinishedRace(){
        Sports car = new Sports();
        Track track = new Track();

        track.setLocation(car, 0);
        assertFalse("Error expected false, got true", track.finisedTrack());
    }
  
    @Test
    public void testTrackFinishedRace(){
        Sports car = new Sports();
        Track track = new Track();

        track.setLocation(car, 24);
        assertTrue("Error expected false, got true", track.finisedTrack());
    }

    //3---
    @Test
    public void testReasonWhyGameEnded(){
        GameController gc = new GameController();

        Sports car1 = new Sports();
        Track track1 = new Track();
        track1.setLocation(car1, 0);

        Sports car2 = new Sports();
        Track track2 = new Track();
        track2.setLocation(car2,24);

        assertEquals("The SUV won!", gc.checkWhyLoopFinished(track2, track1));
        assertEquals("The sports car won!", gc.checkWhyLoopFinished(track1, track2));
        assertEquals("User (through input 'q') decided to quit the program!", gc.checkWhyLoopFinished(track1, track1));
    }
}