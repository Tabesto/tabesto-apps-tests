package tabesto.testing.data.jsonData;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import tabesto.testing.config.Settings;
import tabesto.testing.model.Menu;

public class JsonDataReader {
    private final String dataResourcesPath = Settings.getInstance().getTestDataResourcesPath();
    private final List<Menu>  menuList;

    public JsonDataReader(){
        menuList = getData();
    }

    public List<Menu> getData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(dataResourcesPath));
            Menu[] menu = gson.fromJson(bufferReader, Menu[].class);
            return Arrays.asList(menu);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + dataResourcesPath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

}