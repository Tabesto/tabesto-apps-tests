package tabesto.testing.integration.reporter;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class UpdatesResults {
    private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
    private static final String DB_NAME = "tabesto_auto_tests";
    static {
        INFLXUDB.setDatabase(DB_NAME);
    }
    public static void post(final Point point) {
        INFLXUDB.write(point);
    }

}
