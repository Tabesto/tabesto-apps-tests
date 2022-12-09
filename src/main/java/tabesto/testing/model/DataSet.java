package tabesto.testing.model;

import io.restassured.http.Cookies;

import java.util.*;

public class DataSet {
    public static DataSet instance = null;
    public List<String> listCategories;
    public  String siteName;
    public Date today;
    public Cookies cookies;
    private List<String> productsCreated = new ArrayList<>();
    private String versionOs;
    private String appVersion;
    private String errorMessage;
    private static final ThreadLocal<String> numTable = new ThreadLocal<String>();

    public String getErrorMessage() {
        return "";
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getVersionOs() {
        return versionOs;
    }

    public void setVersionOs(String versionOs) {
        this.versionOs = versionOs;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }


    public List<String> getProductsCreated() {
        return productsCreated;
    }

    public void setProductsCreated(List<String> productsCreated) {
        this.productsCreated = productsCreated;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }
    public HashMap<String, String> map = new HashMap<>();

    public static DataSet getInstance() {
        if (instance == null) {
            instance = new DataSet();
        }
        return instance;
    }
    public DataSet() {
        listCategories = new ArrayList<>();
    }

    public List<String> getListCategories() {
        return listCategories;
    }
    public void setListCategories(List<String> listCategories) {
        this.listCategories = listCategories;
    }

    public Date getToday() {
        return today;
    }
    public void setToday(Date today) {
        this.today = today;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }


    public static void setInstance(DataSet instance) {
        DataSet.instance = instance;
    }

    public HashMap<String, String> getMap() {return map;}

    public void setMap(HashMap<String, String> map) {this.map = map;}

    public void setNumTable(String numTable1) {
        numTable.set(numTable1);
    }

    public String getNumTable() {
        return numTable.get();
    }

}
