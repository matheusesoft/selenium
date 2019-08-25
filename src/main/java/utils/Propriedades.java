package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("serial")
public class Propriedades extends Properties{
	
	private static Propriedades prop;
	
	private Propriedades() {
		super();
	}
	
	public static Propriedades getInstance()
	{
		if(prop == null)
		{
			try {
				prop = new Propriedades();
				FileInputStream input = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config.properties");
				prop.load(input);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

}