package selenium.configuration;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Configuration {
	private static final String BUNDLE_NAME = "config";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private Configuration() {}
	
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		}catch(MissingResourceException mre) {
			return "ERROR:"+key;
		}
	}

}
