package tabesto.testing.pageObjects.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BaseWebPage {

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(name = "_password")
    private WebElement password;
    @FindBy(name = "_submit")
    private WebElement connectButton;

    public UserPage(WebDriver webDriver) {
        //super(webDriver);
    }
    
    public void createNewUser() {
    }

    public void activateAccount() {
    }

    public void addRole(String roles) {
    }

    public void changePassword() {
    }

    public void disableAccount() {
    }
}
