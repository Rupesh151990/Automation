package propertyConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {

	Properties prop;

	public Properties getProperty() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/java/configuration/config.properties");
			prop.load(ip);
			System.out.println("Loading the Properties file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
