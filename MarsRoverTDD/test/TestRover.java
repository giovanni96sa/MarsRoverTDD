import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestRover {
	
private Rover x;

	@Before
	public void SetUp() throws PlanetException
	{
		x = new Rover(new Planet(4,4));
	}

	@Test
	public void roverStartStatus() throws PlanetException
	{
		
	   assertEquals("(0,0,N)",x.commandToRover());
	}
	
	@Test
	public void getPlanetExplored() throws PlanetException
	{
		assertNotNull(x.getPlanetExplored());
	   
	}

	@Test
	public void roverStatusAfterLeft() throws PlanetException, RoverException
	{
		   assertEquals("(0,0,W)",x.commandToRover('l'));
	}
	
	@Test
	public void roverStatusAfterRight() throws PlanetException, RoverException
	{
		
	   assertEquals("(0,0,E)",x.commandToRover('r'));
	}
	@Test
	public void roverStatusAfterRightTurningAround() throws PlanetException, RoverException
	{
		x.commandToRover('r');
		x.commandToRover('r');
		x.commandToRover('r');
	   assertEquals("(0,0,N)",x.commandToRover('r'));
	}
	@Test
	public void roverStatusAfterLeftTurningAround() throws PlanetException, RoverException
	{
		x.commandToRover('l');
		x.commandToRover('l');
		x.commandToRover('l');
	   assertEquals("(0,0,N)",x.commandToRover('l'));
	}
	
	@Test
	public void roverStatusAfterRightToLeft() throws PlanetException, RoverException
	{
		x.commandToRover('r');
		x.commandToRover();
	    assertEquals("(0,0,W)", x.commandToRover('l'));
	}
	
	@Test
	public void roverStatusAfterLeftTToRight() throws PlanetException, RoverException
	{
		x.commandToRover('l');
		x.commandToRover();
	    assertEquals("(0,0,E)", x.commandToRover('r'));
	}
	
	@Test (expected = RoverException.class)
	public void roverWrongCommandRight() throws PlanetException, RoverException
	{
		x.commandToRover('a');
		x.commandToRover('r');
	}
	
	@Test
	public void roverMoveForward() throws RoverException 
	{
		assertEquals("(0,1,N)", x.commandToRover('f'));	
	}
	@Test
	public void roverMoveForwardLeft() throws RoverException 
	{
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('l');
		assertEquals("(3,2,W)", x.commandToRover('f'));	
	}
	
	@Test
	public void roverMoveForwardRight() throws RoverException 
	{
		x.commandToRover('r');

		assertEquals("(1,0,E)", x.commandToRover('f'));	
	}
	@Test
	public void roverMoveForward1() throws RoverException 
	{
		
		x.commandToRover('f');
		x.commandToRover('f');
		assertEquals("(0,3,N)", x.commandToRover('f'));	
	}
  
	@Test
	public void roverMoveBackward() throws RoverException 
	{
		assertEquals("(0,3,N)", x.commandToRover('b'));	
	}
	@Test
	public void roverMoveBackwardLeft() throws RoverException 
	{
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover('l');
		assertEquals("(1,2,W)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverMoveBackwardRight() throws RoverException 
	{
		x.commandToRover('r');

		assertEquals("(3,0,E)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverMoveBackward1() throws RoverException 
	{
		
		x.commandToRover('b');
		x.commandToRover('b');
		assertEquals("(0,1,N)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverMoveCombined() throws RoverException 
	{

		assertEquals("(2,2,E)",x.commandToRover("ffrff"));	
	}
	@Test
	public void roverMovseCombined1() throws RoverException 
	{

		assertEquals("(2,2,N)",x.commandToRover("ffrff "));	
	}
	@Test
	public void roverMovseCombined2() throws RoverException 
	{

		assertEquals("(2,3,N)",x.commandToRover("ffrff f"));	
	}
	
	@Test
	public void roverMoveForwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('f');
		x.commandToRover('f');
				
		
		assertEquals("(0,3,N)", x.commandToRover('f'));	
	}
	
	@Test
	public void roverMoveForwardUntilTheEndPlusOne() throws RoverException 
	{		
		
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		assertEquals("(0,0,N)", x.commandToRover('f'));	

	}
	@Test
	public void roverMoveLeftForwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover();
		x.commandToRover('l');
		x.commandToRover('f');
		x.commandToRover('f');
		
		assertEquals("(0,0,W)", x.commandToRover('f'));	
	}
	
	@Test
	public void roverMoveLeftForwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('l');

		assertEquals("(3,0,W)", x.commandToRover('f'));	

	}
	
	@Test
	public void roverMoveRightForwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		
		assertEquals("(3,0,E)", x.commandToRover('f'));	
	}
	
    @Test
	public void roverMoveRightForwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');

		assertEquals("(0,0,E)", x.commandToRover('f'));	

	}
	
	@Test
	public void roverBackwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('b');
		x.commandToRover('b');

		assertEquals("(0,0,N)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverBackwardUntilTheEndPlusOne() throws RoverException 
	{		
		
	
		assertEquals("(0,3,N)", x.commandToRover('b'));	

	}
	
	@Test
	public void roverMoveRightBackwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover();
		x.commandToRover('l');
		x.commandToRover('b');
		x.commandToRover('b');
		
		assertEquals("(0,0,W)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverMoveRightBackwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('r');

		assertEquals("(3,0,E)", x.commandToRover('b'));	

	}
	
	@Test
	public void roverMoveLeftBackwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('l');
		x.commandToRover('b');
		x.commandToRover('b');
		
		assertEquals("(3,0,W)", x.commandToRover('b'));	
	}
	
    @Test
	public void roverMoveLeftBackwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('l');
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover('b');

		assertEquals("(0,0,W)", x.commandToRover('b'));	

	}
    
    @Test
	public void roverMoveRightForwardAndForwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		
		x.commandToRover();
		
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		
		assertEquals("(0,0,N)", x.commandToRover('f'));	

	}

    @Test
	public void roverObstacleDiscover() throws RoverException, PlanetException 
	{		
		Planet planet = x.getPlanetExplored();
		planet.setObstacle(0, 3);
		x.commandToRover('f');
		x.commandToRover('f');	
		assertEquals("(0,2,N)(0,3)", x.commandToRover('f'));
	}
    
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame() throws RoverException, PlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setObstacle(0, 3);
   		x.commandToRover('f');
   		x.commandToRover('f');	
   		x.commandToRover('f');	
   		assertEquals("(0,2,N)(0,3)", x.commandToRover('f'));
   	}
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame2() throws RoverException, PlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setObstacle(0, 3);
   		x.commandToRover('f');
   		x.commandToRover('f');	
   		x.commandToRover('f');	
   		x.commandToRover('f');
   		assertEquals("(0,2,N)(0,3)", x.commandToRover('f'));
   	}
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame3() throws RoverException, PlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setObstacle(0, 3);
   		x.commandToRover('b');
   		x.commandToRover('b');	
   		x.commandToRover('b');	
   		assertEquals("(0,0,N)(0,3)", x.commandToRover('b'));
   	}
	 // There is one obstacle on coordinates (2,2) of the planet. 
	 // The rover executes “ffrfff” and returns the string “(1,2,E)(2,2)”.
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame4() throws RoverException, PlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setObstacle(2, 2);
   		assertEquals("(1,2,E)(2,2)", x.commandToRover("ffrfff"));
   	}
   
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame5() throws RoverException, PlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setObstacle(2, 2);
   		planet.setObstacle(2, 1);
   		assertEquals("(1,1,E)(2,2)(2,1)", x.commandToRover("ffrfffrflf"));
   	}
    
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame6() throws RoverException, PlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setObstacle(0, 3);
   		assertEquals("(0,0,N)(0,3)", x.commandToRover("b"));
   	}
    
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame7() throws RoverException, PlanetException 
   	{	
    	
    	x = new Rover(new Planet(6,6));
   		Planet planet = x.getPlanetExplored();
   		planet.setObstacle(2, 2);
   		planet.setObstacle(0, 5);
   		planet.setObstacle(5, 0);
   		assertEquals("(0,0,N)(2,2)(0,5)(5,0)", x.commandToRover("ffrfffrbbblllfrfrbbl"));
   	}
   
}
