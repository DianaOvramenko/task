package core.helpers.providers;

import core.helpers.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {

    public static String getProperty(String propertyFilePath, String key) {
        return readProperties(propertyFilePath).getProperty(key);
    }

    private static Properties readProperties(String path) {
        Properties properties;
        try {
            if (new File(path).exists() == false) {
                Log.error("Cannot find '" + path + "' file.");
            }
            properties = loadProperties(path);

        } catch (Exception e) {
            throw new AssertionError("Error while reading property file '" + path + "': " + e.getMessage());
        }
        return properties;
    }

    private static Properties loadProperties(String path) {
        Properties result = new Properties();
        try {
            result.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
