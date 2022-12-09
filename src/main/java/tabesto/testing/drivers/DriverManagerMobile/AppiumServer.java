package tabesto.testing.drivers.DriverManagerMobile;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import tabesto.testing.integration.reporter.GlobalParams;
import tabesto.testing.utils.HelpersMethod;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class AppiumServer {

    private static final ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    HelpersMethod utils = new HelpersMethod();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();

        if(server == null || !server.isRunning()){
            utils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        AppiumServer.server.set(server);
        utils.log().info("Appium server started");

    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    public AppiumDriverLocalService WindowsGetAppiumService() {
        GlobalParams params = new GlobalParams();

        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withTimeout(Duration.ofSeconds(120))
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + getDateTime()+".log")));
    }



















//    public AppiumDriverLocalService WindowsGetAppiumService() {
//        GlobalParams params = new GlobalParams();
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("C:\\Program Files (x86)\\nodejs\\node.exe"))
//                .withAppiumJS(new File("C:\\Users\\ziedk\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName() + File.separator + "Server.log")));
//    }

}
