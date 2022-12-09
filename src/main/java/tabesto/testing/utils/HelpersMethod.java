package tabesto.testing.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpersMethod {


    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }

    public static void writeJsonStringToFile(String path, String jsonString){
        try (PrintWriter file = new PrintWriter(new FileWriter(path))) {
            file.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> matchStringWithInputRegex(String regex,String str){

        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(str);
        System.out.println(m.groupCount());
        List<String> matchedStr = new ArrayList<>();

        if (m.find()) {
            for (int index = 1;index < m.groupCount()+1;index++){
                matchedStr.add(m.group(index));
            }
        } else {
            throw new RuntimeException("Failed to Found input regex in "+ str);
        }
        return matchedStr;
    }

    public static String readOutputStream(String regex, String command) throws IOException {

        Process cmdProcess = Runtime.getRuntime().exec(command);

        cmdProcess.getOutputStream().close();
        String line;
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                cmdProcess.getInputStream()));

        while ((line = stdout.readLine()) != null) {
            Pattern r = Pattern.compile(regex);
            Matcher m = r.matcher(line);
            if (m.find()) {
                return m.group(1);
            }
        }
        stdout.close();
        BufferedReader stderr = new BufferedReader(new InputStreamReader(
                cmdProcess.getErrorStream()));
        while ((line = stderr.readLine()) != null) {
            new HelpersMethod().log().info(line);
        }
        stderr.close();

        return null;
    }


}
