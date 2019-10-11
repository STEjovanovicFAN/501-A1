import junit.framework.TestCase;
import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;


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
        GameControllerDisplayAndInputs gc = new GameControllerDisplayAndInputs();

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
    //4--- 
    @Test
    public void testDesertCarDisplay(){
        GameControllerDisplayAndInputs dis = new GameControllerDisplayAndInputs();
        String outOne = "WARNING: EXTREME CONDITIONS ON ROAD" + 
         "\n" + "Sportscar driving options" + 
         "\n" + "(d)rive normally" + 
         "\n" + "(q)uit simulation" + 
         "\n" + "Enter selection: ";

        String outTwo = "Sportscar driving options" + 
        "\n" + "(d)rive normally" + 
        "\n" + "(q)uit simulation" + 
        "\n" + "Enter selection: ";
    
        assertEquals(outOne, dis.carDisplay('S', true, true));
        assertEquals(outOne, dis.carDisplay('S', false, true));
        assertEquals(outOne, dis.carDisplay('S', true, false));
        assertEquals(outTwo, dis.carDisplay('S', false, false));
    } 
 
    @Test
    public void testArcticCarDisplay(){
        GameControllerDisplayAndInputs dis = new GameControllerDisplayAndInputs();
        String outOne = "WARNING: EXTREME CONDITIONS ON ROAD" + 
         "\n" + "SUV driving options" + 
         "\n" + "(a)ll wheel drive mode" + 
         "\n" + "(d)rive normally" + 
         "\n" + "(q)uit simulation" + 
         "\n" + "Enter selection: ";

        String outTwo ="SUV driving options" + 
        "\n" + "(a)ll wheel drive mode" + 
        "\n" + "(d)rive normally" + 
        "\n" + "(q)uit simulation" + 
        "\n" + "Enter selection: ";
    
        assertEquals(outOne, dis.carDisplay('V', true, true));
        assertEquals(outOne, dis.carDisplay('V', false, true));
        assertEquals(outOne, dis.carDisplay('V', true, false));
        assertEquals(outTwo, dis.carDisplay('V', false, false));
    } 
 
    @Test
    public void testInputs(){
        GameControllerDisplayAndInputs dis = new GameControllerDisplayAndInputs();

        String input = "ABAA";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals('A', dis.getInput());
    }
    
}