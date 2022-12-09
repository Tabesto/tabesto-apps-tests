package tabesto.testing.pageObjects.mobile;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tabesto.testing.drivers.DriverManagerMobile.AndroidDeviceA;

import java.time.Duration;
import java.util.List;

public class BaseMobile {

    protected AppiumDriver androidDriver;
    protected WebDriverWait wait;


    public final static Logger logger = LogManager.getLogger();

    public BaseMobile(){
        this.androidDriver = new AndroidDeviceA().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);

    }

    protected boolean verifyDisplayElement(WebElement WebElement) {
        return WebElement.isDisplayed();
    }

    protected void longPress(WebElement WebElement) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(2),
                PointerInput.Origin.viewport(),WebElement.getLocation().x, WebElement.getLocation().y));
        androidDriver.perform(List.of(dragNDrop));

    }

    public  void action_clickOnPosition(int pointA_X, int pointA_Y) throws InterruptedException {
        Thread.sleep(20000);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence clickPosition = new Sequence(finger, 0);
        clickPosition.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), pointA_X,pointA_Y));
        clickPosition.addAction(finger.createPointerDown(0));
        clickPosition.addAction(new Pause(finger, Duration.ofMillis(500)));
        clickPosition.addAction(finger.createPointerUp(0));
        androidDriver.perform(ImmutableList.of(clickPosition));
    }

    public void scroll(String directionScroll){

        Dimension size  = androidDriver.manage().window().getSize();
        Point midPoint = new Point((int)(size.width * 0.5), (int)(size.height * 0.5));
        //int top = midPoint.y - (int)((size.height * 0.3) * 0.6);
        int top = midPoint.y - (int)((size.height * 0.3) * 0.4);

        int bottom = midPoint.y + (int)((size.height * 0.3) * 0.5);

        Point start = new Point(midPoint.x, bottom);
        Point end =new Point(midPoint.x, top);

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        if (directionScroll.equals("UP")) {
            swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(new Pause(input, Duration.ofMillis(1000)));
            swipe.addAction(input.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.x, end.y));
            swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        }

        androidDriver.perform(ImmutableList.of(swipe));
    }


}
