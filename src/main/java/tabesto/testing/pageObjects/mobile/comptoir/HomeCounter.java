package tabesto.testing.pageObjects.mobile.comptoir;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tabesto.testing.pageObjects.mobile.BaseMobile;
import tabesto.testing.model.DataSet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


public class HomeCounter extends BaseMobile {
    @AndroidFindBy(id = "textview_main_info_top_bar_tabesto_name")
    private WebElement tabestoTextview;
    @AndroidFindBy(id = "textview_main_info_top_bar_terminal_name")
    private WebElement terminalTextview;
    @AndroidFindBy(id = "textview_price_value")
    private WebElement priceTextview;
    @AndroidFindBy(id = "textview_main_order_top_bar_empty")
    private WebElement emptyOrderTextview;
    @AndroidFindBy(id = "textview_main_order_top_bar_location")
    private WebElement locationTextview;
    @AndroidFindBy(id = "textview_main_info_top_bar_user_name")
    private WebElement userNameTextview;
    @AndroidFindAll(value = { @AndroidBy(id = "textview_main_menu_item_title")}, priority = 0)
    private List<WebElement> listMenuItem;
    @AndroidFindAll(value = { @AndroidBy(id = "textview_main_product_item_title")}, priority = 0)
    private List<WebElement> listProductItem;
    @AndroidFindAll(value = { @AndroidBy(id = "imageview_main_product_header_item_arrow")}, priority = 0)
    private List<WebElement> listTabCategory;
    @AndroidFindBy(id = "button_main_info_top_bar_exit")
    private WebElement quitButton;
    @AndroidFindBy(id = "button_dialog_simple_vertical_positive")
    private WebElement validateButton;
    @AndroidFindBy(id = "topbar_main_content_navigation")
    private WebElement barMenu;
    @AndroidFindBy(id = "layout_main_product_item_root")
    private WebElement productItem;
    private WebElement barMenuItem;

    @AndroidFindAll(value = { @AndroidBy(id = "layout_main_menu_carousel_item")}, priority = 0)
    private List<WebElement> listPictureItem;

    public void getListPicture() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file = new File(System.getProperty("C:\\Users\\rabaaa\\Downloads\\screen\\etudiant.png"));
        Path path = file.toPath();

        try {
            androidDriver.findElement(MobileBy.image(Base64.getEncoder().encodeToString(Files.readAllBytes(path)))).click();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //driver.getImagesSimilarity()
        BaseMobile.logger.info(listPictureItem.get(0).findElement(By.id("imageview_main_menu_item_picture")).getCssValue("srcCompat"));
        BaseMobile.logger.info(listPictureItem.get(0).findElement(By.id("imageview_main_menu_item_picture")).getCssValue("contentDescription"));
    }

    public String getTabestoName() {
        return tabestoTextview.getText();
    }
    public String getTerminalName() {
        return terminalTextview.getText();
    }
    public String getLocation() {
        return locationTextview.getText();
    }
    public String getUserName(){ return userNameTextview.getText(); }
    public String getPrice() {
        return priceTextview.getText();
    }
    public List<WebElement> getListMenuItem() {
        return listMenuItem;
    }
    public List<String> getListMenuItemTitle() {
        List<String> listMenu = listMenuItem.stream().map(item -> item.getText()).collect(Collectors.toList());
        int size = listMenu.size();
        boolean condition = true;
        do {
            List<String> newList = listMenuItem.stream().map(item -> item.getText()).collect(Collectors.toList());
            scroll("UP");
            List<String> afterScroll = listMenuItem.stream().map(item -> item.getText()).collect(Collectors.toList());
            if(newList.equals(afterScroll)){
                condition = false;
            }
            else
           listMenu.addAll(size, afterScroll.subList(afterScroll.indexOf(listMenu.get(size-1))+1, afterScroll.size()));

        }while (condition);
        return listMenu;
    }
    public List<String> getListProductItemTitle() {
        List<String> listProduct = listProductItem.stream().map(item -> item.getText()).collect(Collectors.toList());
        int size = listProduct.size();
        boolean condition = true;
        do {
            List<String> newList = listProductItem.stream().map(item -> item.getText()).collect(Collectors.toList());
            scroll("UP");
            List<String> afterScroll = listProductItem.stream().map(item -> item.getText()).collect(Collectors.toList());
            if(newList.equals(afterScroll)){
                condition = false;
            }
            else
                listProduct.addAll(size, afterScroll.subList(afterScroll.indexOf(listProduct.get(size-1))+1, afterScroll.size()));

        }while (condition);
        return listProduct;
    }

    public boolean isExistInListProductItemTitle(String product) {
        List<String> listCategory = listProductItem.stream().map(item -> item.getText()).collect(Collectors.toList());
        int size = listCategory.size();
        boolean result = false;
        while (!result){
            if(listCategory.indexOf(product) == -1){
                scroll("UP");
                listCategory = listProductItem.stream().map(item -> item.getText()).collect(Collectors.toList());
            } else {
                result = true;
            }
        }
        return result;
    }
    public void selectCategory (String category){
        boolean condition = true;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        do {
            for(WebElement menu : listMenuItem){
                if(menu.getText().equals(category)) {
                    menu.click();
                    condition = false;
                    break;
                }
            }
            scroll("UP");

        }while (condition);
    }
    public String getEmptyTextview() { return emptyOrderTextview.getText();}
    public void clickOnCancelButton() { quitButton.click();}
    public void clickOnOKButton() { validateButton.click();}
    public boolean verifyPresentBarMenu() {
        return barMenu.isDisplayed();
    }
    public void clickOnBarMenuItem(String item){
        barMenuItem = androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"" + item + "\"]"));
        wait.until(ExpectedConditions.visibilityOf(barMenuItem));
        barMenuItem.click();
    }
    public void verifyDisplayedProduct() {
        productItem.isDisplayed();

    }

    public HomeCounter(AndroidDriver driver) {
        //super(driver);
    }

    public boolean verifyNotVisibleMenuItem() {
        try {
            return ! androidDriver.findElement(By.id("textview_main_product_header_item_title")).isDisplayed();
        } catch (NoSuchElementException e){
            return true;
        }
    }

    public boolean verifyVisibleCategory(String category) {
        List <String> listCategory = androidDriver.findElements(By.id("textview_main_product_header_item_title")).stream().map(item -> item.getText()).collect(Collectors.toList());
        return listCategory.indexOf(category) > -1;
    }

    public void closeAllTab() {
        wait.until(ExpectedConditions.visibilityOf(listTabCategory.get(0)));
        int nbreCategory = 0;
        while (nbreCategory < DataSet.getInstance().listCategories.size()){
            for (int i=0; i<DataSet.getInstance().listCategories.size(); i++) {
                listTabCategory.get(i).click();
                nbreCategory++;
                BaseMobile.logger.info("i: " + listTabCategory.size());
            }

        }
    }
}
