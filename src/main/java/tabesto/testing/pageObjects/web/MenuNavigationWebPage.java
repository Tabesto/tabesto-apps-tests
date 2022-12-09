package tabesto.testing.pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tabesto.testing.drivers.DriverManagerWeb.ThreadLocalWebDriver;

public class MenuNavigationWebPage extends BaseWebPage {

    private WebElement menuItem;

    public void clickOnMenu(String menu) {
        menuItem = ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.xpath("//a[normalize-space()=\"" + menu + "\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(menuItem));
        System.out.printf("Click on BUTTON!!");
        menuItem.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
