package tabesto.testing.integration.reporter;


import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import tabesto.testing.model.DataSet;
import static java.util.stream.Collectors.toList;

public class InfluxDBListener implements ITestListener {

    public void onTestSuccess(ITestResult iTestResult) {
        try {
            this.postTestMethodStatus(iTestResult, 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult iTestResult) {
        try {
            this.postTestMethodStatus(iTestResult, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {
        try {
            this.postTestMethodStatus(iTestResult, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
    }
    public void onFinish(ITestContext iTestContext) {
    }
    private void postTestMethodStatus(ITestResult iTestResult, int status) throws IOException {

        String scenarioName = Hooks.getScenarioName();
        String kpi_test = (status==1) ? "kpi_test_OK" : "kpi_test_KO";
        Point point = Point.measurement("testmethod").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("context_scenario_id", Arrays.stream(scenarioName.split("-")).collect(toList()).get(0).trim())
                .tag("context_scenario_name", Arrays.stream(scenarioName.split("-")).collect(toList()).get(2).trim())
                .tag("context_scenario_family", Arrays.stream(scenarioName.split("-")).collect(toList()).get(1).trim())
                .tag("deviceName",iTestResult.getTestContext().getName())
                .tag("context_app_version", DataSet.getInstance().getAppVersion())
                .addField("kpi_test_success", status)
                .tag("context_os_version", DataSet.getInstance().getVersionOs())
                .addField(kpi_test,1)
                .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis()))
                .addField("measureRunUuid",Hooks.getUuid())
                .addField("kpi_error_msg",DataSet.getInstance().getErrorMessage())
                .build();
        UpdatesResults.post(point);

    }


}