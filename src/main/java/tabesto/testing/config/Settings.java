package tabesto.testing.config;

public class Settings {
    private static Settings settings;
    private ConfigReader configReader;
    private String baseUrl;
    private String ocaUrl;
    private String sellerName;
    private boolean videoEnable;
    private boolean dataDrivenLocal;
    private String pathString;
    private String testDataResourcesPath;
    private String androidAppPackage;
    private String androidAppActivity;
    private String androidAutomationName;

    public Settings() {
        configReader = new ConfigReader();
        baseUrl = configReader.getStringValueConfig("baseUrl");
        ocaUrl = configReader.getStringValueConfig("ocaUrl");
        sellerName = configReader.getStringValueConfig("sellerName");
        videoEnable = configReader.getBooleanValueConfig("videoEnable");
        dataDrivenLocal = configReader.getBooleanValueConfig("dataDrivenLocal");
        testDataResourcesPath = configReader.getStringValueConfig("testDataResourcesPath");
        pathString = configReader.getStringValueConfig("pathString");
        androidAppPackage = configReader.getStringValueConfig("androidAppPackage");
        androidAppActivity = configReader.getStringValueConfig("androidAppActivity");
        androidAutomationName = configReader.getStringValueConfig("androidAutomationName");
    }

    public static Settings getInstance(){
        if(settings == null){
            settings = new Settings();
        }
        return settings;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getOcaUrl() {
        return ocaUrl;
    }

    public String getSellerName() {
        return sellerName;
    }

    public boolean isVideoEnable() {
        return videoEnable;
    }

    public boolean isDataDrivenLocal() {
        return dataDrivenLocal;
    }

    public String getPathString() {
        return pathString;
    }

    public String getTestDataResourcesPath() {
        return testDataResourcesPath;
    }

    public String getAndroidAppPackage() {
        return androidAppPackage;
    }

    public String getAndroidAppActivity() {
        return androidAppActivity;
    }

    public String getAndroidAutomationName() {
        return androidAutomationName;
    }
}
