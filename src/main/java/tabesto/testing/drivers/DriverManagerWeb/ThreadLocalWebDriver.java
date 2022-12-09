package tabesto.testing.drivers.DriverManagerWeb;

public class ThreadLocalWebDriver {
    public static final ThreadLocal<DriverManager> webDriverThreadLocal = new ThreadLocal<>();

    public static void setThreadLocalWebDriver(DriverManager driverManager) { webDriverThreadLocal.set(driverManager);}

    public static DriverManager getThreadLocalWebDriver() {
        return webDriverThreadLocal.get();
    }


}