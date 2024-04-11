package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try {
            InputStream input = new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Configuration properties file cannot be found");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
