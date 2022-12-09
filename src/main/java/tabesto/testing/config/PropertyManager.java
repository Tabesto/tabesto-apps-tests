package tabesto.testing.config;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    public static Properties getProperties(String filePath){
        Properties properties = new Properties();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            }catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(("Failed to load properties file "+filePath));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("properties file not found at "+ filePath);
        }
        finally {
            try { if(reader != null) reader.close(); }
            catch (IOException ignore) {}
        }
        return properties;
    }
}