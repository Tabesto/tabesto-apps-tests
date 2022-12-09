package tabesto.testing.config;


import tabesto.testing.enums.Environment;

import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private String COMMON_CONFIG = "src/test/resources/application.properties";
    private String STG_CONFIG = "src/test/resources/stg_config.properties";
    private String UAT_CONFIG = "src/test/resources/uat_config.properties";

    public ConfigReader(){
        String env = System.getProperty("env", String.valueOf(Environment.UAT));
        switch (Environment.valueOf(env)) {
            case STAGE -> properties = PropertyManager.getProperties(STG_CONFIG);
            case UAT -> properties = PropertyManager.getProperties(UAT_CONFIG);
            default -> throw new IllegalStateException("Invalid env type: "+ env);
        }
        Properties properties1 = PropertyManager.getProperties(COMMON_CONFIG);
        properties.putAll(properties1);
    }

    public String getStringValueConfig(String key) {
        return properties.getProperty(key);
    }


    public boolean getBooleanValueConfig(String key) {
        String value = properties.getProperty(key);
        return Boolean.parseBoolean(value);
    }

}
