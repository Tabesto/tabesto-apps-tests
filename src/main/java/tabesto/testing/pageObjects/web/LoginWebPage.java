package tabesto.testing.pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWebPage extends BaseWebPage {

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(name = "_password")
    private WebElement password;
    @FindBy(name = "_submit")
    private WebElement connectButton;

    public void setUsername(String username) {
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.connectButton.click();
    }


    public void logout() {
    }
}
