

public class Planet {
	
	
	private boolean[][] planet;
	
	public Planet(int x, int y) throws PlanetException {
		// TODO Auto-generated method stub     
		if(x != y) {
			throw new PlanetException();
		}
		planet = new boolean[x][y];
	
	}

	public boolean[][] getPlanet() {
		// TODO Auto-generated method stub
		return planet;
	}

	public void setObstacle(int x, int y) throws PlanetException {
		// TODO Auto-generated method stub
		if(x < planet.length  && y < planet[1].length ) {
			planet[x][y] = true;
		}
		else {
			throw new PlanetException();	
		}
		
	}

	public boolean isObstacle(int x, int y) {
		// TODO Auto-generated method stub
		if(x < planet.length && y < planet[1].length) {
			return (planet[x][y] == true) ? true : false;
		}
		return false;
	}

}
