package linkedLists;

public class Coordinate 
{
	int x=0;
	int y=0;
	
	Coordinate(Integer x1, Integer y1)
	{
		x=x1;
		y=y1;
	}
	
	public String toString()   // overrode this method
	{
		return( " ("+x+", "+y+") ");		
	}
}
