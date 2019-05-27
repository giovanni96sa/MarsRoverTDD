
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestPlanet {
	
Planet  x ;

	@Before
	public void SetUp() throws PlanetException
	{
		 x = new Planet(100, 100);
	}
	
	@Test
	public void createAPlanet() throws PlanetException
	{
		
	   boolean[][] planet = x.getPlanet();
	   assertEquals(200, (planet.length + planet[1].length));
	}
	
	@Test (expected = PlanetException.class)
	public void createAWrongPlanet() throws PlanetException
	{
		
	   new Planet(100, 120);
	   
	}
	
	@Test
	public void createAnObstacle() throws PlanetException
	{
		
	   x.setObstacle(45, 67);
       assertTrue(x.isObstacle(45, 67));
	}
	@Test
	public void createAnObstacle2() throws PlanetException
	{
		
	   x.setObstacle(99, 99);
       assertTrue(x.isObstacle(99, 99));
	}
	@Test
	public void createAnObstacle3() throws PlanetException
	{
		
	   x.setObstacle(0, 0);
       assertTrue(x.isObstacle(0, 0));
	}
	
	@Test (expected = PlanetException.class)
	public void createAnObstacleInWrongPosition() throws PlanetException
	{
		
	   x.setObstacle(100, 67);
	}
	@Test
	public void getNotAnObstacle() throws PlanetException
	{
		
       assertFalse(x.isObstacle(5, 67));
	}
	@Test
	public void getNotAnObstacleWrongPosition() throws PlanetException
	{
		
       assertFalse(x.isObstacle(100, 67));
	}
		
}
