package genericUtilities;

import java.util.Random;
/**
 * 
 * @author sreepriya
 *
 */
public class JavaUtility {
	/**
	 * This method is developed to genarate random numbers 
	 * @param range
	 * @return one random number within the range
	 */
public int generateRandomNumber(int range)
{
	Random r=new Random();
	return r.nextInt(range) ;
	
}
}
