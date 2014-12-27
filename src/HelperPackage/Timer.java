package HelperPackage;

public class Timer 
{
	private long startTime,endTime;
	
	public Timer()
	{
		startTime = System.currentTimeMillis();
	}
	
	public void getRunTime()
	{
		endTime = System.currentTimeMillis();
		System.out.println( "\n\n"+(endTime-startTime)+ "- milliseconds Runtime"  );
	}
	
	public void resetTimer()
	{
		startTime = System.currentTimeMillis();
	}
}
