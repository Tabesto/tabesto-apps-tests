package tabesto.testing.utils.transformer;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JsonSerializer {

    public static <T> T toObject(String fileName , Class <T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileInputStream input = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(input));

        return objectMapper.readValue(br,clazz);
    }
}

