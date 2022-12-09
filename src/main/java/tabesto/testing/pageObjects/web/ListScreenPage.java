package tabesto.testing.pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.drivers.DriverManagerWeb.ThreadLocalWebDriver;

public class ListScreenPage extends BaseWebPage {

    @FindBy(xpath = "//a[@href='#start']")
    private WebElement numberStartScreen;
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement addScreenButton;
    @FindBy(tagName = "tbody")
    private WebElement listScreen;
    @FindBy(id = "deleteProductText")
    private WebElement confirmDeleteButton;

    public String verifyNumberOfStartScreen() {
       return numberStartScreen.getText();
    }

    public int getCountScreen(){
      return  ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElements(By.cssSelector("tbody tr")).size();
    }
    public void deleteScreen(int index) {
        ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElements(By.cssSelector("tbody tr")).get(index).findElement(By.className("tabesto-delete-icon")).click();

        ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.xpath("//a[normalize-space()='Confirmer la suppression']")).click();
    }
    public void clickOnAddNewScreen() {
        addScreenButton.click();
    }

}
