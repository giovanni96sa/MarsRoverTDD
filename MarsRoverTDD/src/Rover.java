
public class Rover {

	private int x;
	private int y;
	private char orientation;
    private Planet planet;
    
	Rover(Planet planetExplored)
	{
		this.planet = planetExplored;
		this.setX(0);
		this.setY(0);
		this.setOrientation('N');
	}
	
	public String commandToRover() {
	// TODO Auto-generated method stub
	this.setOrientation('N');
    return  "("+this.getX()+','+this.getY()+','+this.getOrientation()+')';
	
	}
	
	public String commandToRover(String direction) throws RoverException {	
		// TODO Auto-generated method stub	
		String storage="";
		int i = 0;
		for(i = 0; i < direction.length() - 1; i++)
		{

			switch(direction.charAt(i)) {
			
			case 'l':
				commandToRover(direction.charAt(i));
				break;
			case 'r':
				commandToRover(direction.charAt(i));
				break;
			case ' ':
				this.commandToRover();
				break;
			case 'f':
				String tmp = this.moveRoverForward();

				if((tmp != null) && (!(this.checkDuplicate(storage,tmp))))
				storage = storage + tmp;
	            break;
			
			case 'b':
				String tmp1 = this.moveRoverBackward();
				if((tmp1 != null) && (!(this.checkDuplicate(storage,tmp1))))
				storage = storage + tmp1;
	            break;
			    /*end implementation 5.*/	    
			default: 
				throw new RoverException();
				
			}
		} 
		switch(direction.charAt(i)) {
		
		case 'l':
			    return  commandToRover(direction.charAt(i)) + storage;
		case ' ':
			return this.commandToRover() + storage;
		case 'r':
				return	commandToRover(direction.charAt(i)) + storage;
			
		case 'f': 
			String tmp = this.moveRoverForward();
			if((tmp != null) && (!(this.checkDuplicate(storage,tmp))))
				storage = storage + tmp;
			
					return "("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + storage;

		case 'b':
			String tmp1 = this.moveRoverBackward();
			if((tmp1 != null) && (!(this.checkDuplicate(storage,tmp1))))
				storage = storage + tmp1; 
			
				return	"("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + storage;
		default: 
			throw new RoverException();
			
		}
	}
	
	public boolean checkDuplicate(String storage, String path)
	{
		// TODO Auto-generated method stub
	   int z = 0;
	   for(int i = 0; i < storage.length(); i++)
	   {
		   if(path.charAt(z) == storage.charAt(i))
			   z++;
		   if(z == 5)
			   return true;
		   if(z > 5)
			   z = 0;
	   }
	   return false;
	}
	
	public String commandToRover(char direction) throws RoverException {	
		// TODO Auto-generated method stub
	switch(direction) {
	
	case 'l':
		this.setDirection(direction);
	    return  "("+this.getX()+','+this.getY()+','+this.getOrientation()+')';
	case 'r':
		this.setDirection(direction);
	    return  "("+this.getX()+','+this.getY()+','+this.getOrientation()+')';
	case 'f':
		String tmp = this.moveRoverForward();
		
		return  (tmp == null) ? 
			    "("+this.getX()+','+this.getY()+','+this.getOrientation()+')'
				: 
				"("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + tmp;
	case 'b':
		String tmp1= this.moveRoverBackward();
		return  (tmp1 == null) ? 
			    "("+this.getX()+','+this.getY()+','+this.getOrientation()+')'
				: 
				"("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + tmp1;   
	default: 
		throw new RoverException();
		
	}

	}
	
	private void setDirection(char direction) throws RoverException
	{
		char d = this.getOrientation();
		
			switch(d) {
			case 'N':
				if(direction == 'l')
				this.setOrientation('W');
				if(direction == 'r')
	            this.setOrientation('E');
				break;
			case 'E':
				if(direction == 'l')
					this.setOrientation('N');
					if(direction == 'r')
		            this.setOrientation('S');
					break;
			case 'S':
				if(direction == 'l')
					this.setOrientation('E');
					if(direction == 'r')
		            this.setOrientation('W');
					break;
			case 'W':
				if(direction == 'l')
					this.setOrientation('S');
					if(direction == 'r')
		            this.setOrientation('N');
				break;
		    default :
			throw new RoverException();
		}
			
	}
	
	private String moveRoverForward() throws RoverException
	{
		switch(this.getOrientation()) {
		case 'N':
		if(!(isThereAnyObstacle(x, this.getY() + 1)))
		{
			this.setY(this.getY() + 1);
			return null;
		}
		else
			return "(" + this.getX() + ',' + (this.checkEdgeOfPlanet(this.getY() + 1)) + ')';
		
		case 'W':
			if(!(isThereAnyObstacle(this.getX() - 1, y)))
			{
				this.setX(this.getX() - 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() - 1)) + ',' + this.getY() + ')';
		case 'S':
			if(!(isThereAnyObstacle(this.getY() - 1, y)))
			{

				this.setY(this.getY() - 1);

				return null;
			}
			else
				return "(" + this.getX() + ',' +(this.checkEdgeOfPlanet(this.getX() - 1))+ ')';
		case 'E':
			if(!(isThereAnyObstacle(this.getX() + 1, y)))
			{
				this.setX(this.getX() + 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() + 1)) + ',' + this.getY() + ')';
		}
		
		throw new RoverException();

	}

	private String moveRoverBackward() throws RoverException
	{
	
		switch(this.getOrientation()) {
		case 'N':
		if(!(isThereAnyObstacle(x, this.getY() - 1)))
		{
			this.setY(this.getY() - 1);
			return null;
		}
		else
			return "(" + this.getX() + ',' + (this.checkEdgeOfPlanet(this.getY() - 1)) + ')';
		
		case 'W':
			if(!(isThereAnyObstacle(this.getX() + 1, y)))
			{
				this.setX(this.getX() + 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() + 1)) + ',' + this.getY() + ')';
		case 'S':
			if(!(isThereAnyObstacle(this.getY() + 1, y)))
			{
				this.setY(this.getY() + 1);
				return null;
			}
			else
				return "(" + this.getX() + ',' +(this.checkEdgeOfPlanet(this.getX() + 1))+ ')';
		case 'E':
			if(!(isThereAnyObstacle(this.getX() - 1, y)))
			{
				this.setX(this.getX() - 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() - 1)) + ',' + this.getY() + ')';
		}
		
		throw new RoverException();

	}
	
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = this.checkEdgeOfPlanet(x);
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = this.checkEdgeOfPlanet(y);
	}
		
	public Planet getPlanetExplored()
	{
		// TODO Auto-generated method stub
	return this.planet;	
	}

	public char getOrientation() {
		// TODO Auto-generated method stub
		return orientation;
	}

	private void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	
	private int checkEdgeOfPlanet(int value)
	{
		boolean[][] planet = this.getPlanetExplored().getPlanet();
		//matrix square
		if(planet.length <= value)
			return 0;
		else if (value < 0)
			return planet.length - 1;
		else
			return value;
	}
	
	private boolean isThereAnyObstacle(int x, int y) {
     	return this.getPlanetExplored().getPlanet()[this.checkEdgeOfPlanet(x)][this.checkEdgeOfPlanet(y)];
	}

	
}
