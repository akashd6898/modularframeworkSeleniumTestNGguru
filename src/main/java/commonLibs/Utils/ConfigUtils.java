package commonLibs.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    public static Properties readProperties(String filename) throws IOException {
        filename = filename.trim();

        InputStream fileReader = new FileInputStream(filename); //FileInputStream is used to read data from a file.

        Properties property = new Properties(); //Properties is a class in Java used to store key-value pairs
        property.load(fileReader); // loads the properties from the fileReader into the property object
        return property;
    }
}
