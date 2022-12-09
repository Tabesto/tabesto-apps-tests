package tabesto.testing.utils;

import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import tabesto.testing.drivers.DriverManagerMobile.AndroidDeviceA;
import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class VideoRecorder {
    static String video_url;

    public static String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        VideoRecorder.video_url = video_url;
    }

    public void startRecording() {
        ((CanRecordScreen) new AndroidDeviceA().getDriver()).startRecordingScreen(new AndroidStartScreenRecordingOptions()
                .withTimeLimit(Duration.ofMinutes(14)));
    }

    public void stopRecording(String scenario, String uUid) {
        String  video = ((CanRecordScreen) new AndroidDeviceA().getDriver()).stopRecordingScreen();
        File videoDir = new File("AppiumLogs/videos/");
        synchronized (videoDir) {
            if(!videoDir.exists()) {
                videoDir.mkdirs();
            }
        }
        FileOutputStream stream = null;
        try {
            setVideo_url(videoDir + File.separator + uUid+".mp4");
            stream = new FileOutputStream( videoDir + File.separator + uUid+".mp4");
            stream.write(Base64.decodeBase64(video));
            stream.close();

        } catch (Exception e){
        }finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
