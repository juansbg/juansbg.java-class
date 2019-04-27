package SpaceInvaders.Util;

public class Util
{
	static void wait(int segundos)
	{
		try
		{
			Thread.sleep(segundos*100);
		}
		catch(Exception e)
		{

		}
	}
}
