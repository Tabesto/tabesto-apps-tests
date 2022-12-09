package tabesto.testing.pageObjects.web;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tabesto.testing.drivers.DriverManagerWeb.ThreadLocalWebDriver;

import java.util.List;

public class CartePage extends BaseWebPage {
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement createMenuButton;
    @FindBy(className = "tabesto-clone-icon")
    private WebElement cloneMenuButton;
    @FindBy(className = "tabesto-delete-icon")
    private WebElement deleteMenuButton;
    @FindBy(css = "tbody tr")
    private List<WebElement> listMenu;
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement duplicateButton;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement filterCategoryInput;
    private WebElement groupMenuCheckbox;
    @FindBy(id = "menu_label")
    private WebElement nameMenu;
    @FindBy(id = "menu_description")
    private WebElement menuDescription;
    @FindBy(xpath = "//*[@id='menu_withActivityPeriod_0']//parent::*")
    private WebElement withPersonalizeActivityPeriod;
    @FindBy(xpath = "//*[@id='menu_withActivityPeriod_1']//parent::*")
    private WebElement withAllDayActivityPeriod;
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement saveMenuButton;
    @FindBy(xpath = "//button[@data-id='menu_activityPeriod_startTime_hour']//parent::*")
    private WebElement startHour;
    @FindBy(xpath = "//button[@data-id='menu_activityPeriod_startTime_minute']//parent::*")
    private WebElement startMinute;
    @FindBy(xpath = "//button[@data-id='menu_activityPeriod_duration_hour']//parent::*")
    private WebElement durationHour;
    @FindBy(xpath = "//button[@data-id='menu_activityPeriod_duration_minute']//parent::*")
    private WebElement durationMinute;
    public void createMenu() {
        createMenuButton.click();
    }
    public void cloneMenu() {
        cloneMenuButton.click();
    }
    public void setNameMenu(String menu){
        nameMenu.clear();
        nameMenu.sendKeys(menu);
    }
    public void setMenuDescription(String description){
        menuDescription.clear();
        menuDescription.sendKeys(description);
    }
    public void activatePersonalizePeriod() {
        withPersonalizeActivityPeriod.click();
    }
    public void activateAllDayPeriod() {
        withAllDayActivityPeriod.click();
    }
    public void saveMenu() {
        saveMenuButton.click();
    }
    public void duplicateMenu() {
        duplicateButton.click();
    }
    public void deleteMenu(){
        deleteMenuButton.click();
    }
    public void selectCategory(String category) {
        groupMenuCheckbox = ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.className("group-checkbox"));
        groupMenuCheckbox.click();
    }
    public void searchCategory(String category){
        filterCategoryInput.click();
        filterCategoryInput.sendKeys(category);
    }
    public void clickOnMenu(String menu) {
        for(WebElement row :listMenu){
            wait.until(ExpectedConditions.visibilityOf(row.findElement(By.tagName("td"))));
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if(columns.get(0).getText().equals(menu)) {
                String dataPath = columns.get(4).findElement(By.className("tabesto-clone-icon")).getAttribute("data-path");
                ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().get(ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().getCurrentUrl().split("/menus/list")[0] + dataPath);
                break;
            }
        }
    }

    public void doubleClickOnMenu(String menu) {
        Actions actions = new Actions(ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver());
        actions.doubleClick().perform();
        for(WebElement row :listMenu){
            wait.until(ExpectedConditions.visibilityOf(row.findElement(By.tagName("td"))));
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if(columns.get(0).getText().equals(menu)) {
                actions.doubleClick(columns.get(0).findElement(By.tagName("a"))).perform();
                break;
            }
        }

    }

    public void setHourAndDuration(String hour, String minute, String durationMinute) {
        startHour.click();
        Select selectHour =  new Select(ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.id("menu_activityPeriod_startTime_hour")));
        selectHour.selectByValue(hour);

        startMinute.click();
        Select selectMinute =  new Select(ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.id("menu_activityPeriod_startTime_minute")));
        selectMinute.selectByValue(minute);

        durationHour.click();
        Select selectDurationHour =  new Select(ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.id("menu_activityPeriod_duration_hour")));
        selectDurationHour.selectByValue("0");
        Select selectDurationMinute =  new Select(ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.id("menu_activityPeriod_duration_minute")));
        selectDurationMinute.selectByValue(durationMinute);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
