/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrover;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Praveer
 */
public class MarsRoverTest {
    
    public MarsRoverTest() {
    }

    /**
     * Test of getPosition method, of class MarsRover.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPosition() throws Exception {
        System.out.println("getPosition");
        MarsRover instance = new MarsRover(10,10,0,0,'N');
        String expResult = "0 0 N";
        String result = instance.getPosition();
        assertEquals("The test case - getPosition after initiallization failed.", expResult, result);
    }

    /**
     * Test of explore method, of class MarsRover.
     * @throws java.lang.Exception
     */
    @Test
    public void testExplore() throws Exception {
        System.out.println("explore");
        String instructions = "L";
        MarsRover instance = new MarsRover(10,10,0,0,'N');
        String expResult = "0 0 W";
        instance.explore(instructions);
        String result = instance.getPosition();
        assertEquals("The test case - explore from N to W using left instruction failed.", expResult, result);
    }
    
}
