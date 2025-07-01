package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Suma Kondapaneni
 * @created 29 Jun 2025
 */
public class ConfigReader {
	private static Properties prop;

	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
		}
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}
}