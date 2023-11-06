package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties; 
/**
 * 
 * @author sreepriya
 *
 */
public class PropertyUtility implements IAutoConstantsUtility {
	/**
	 * This method is developed to read data from property file.
	 * This method accepts key as  argument for which  parameter you want to fetch the value. 
	 * @param key
	 * @return value of the key.
	 */
	public String getDataFromPropertyfile(String key)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(PROPERTY_FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property.getProperty(key); 

	}
}
