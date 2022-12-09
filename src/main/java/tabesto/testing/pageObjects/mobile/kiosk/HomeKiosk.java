package tabesto.testing.pageObjects.mobile.kiosk;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tabesto.testing.pageObjects.mobile.BaseMobile;
import tabesto.testing.model.DataSet;
import tabesto.testing.utils.HelpersMethod;
import tabesto.testing.integration.reporter.GlobalParams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


public class HomeKiosk extends BaseMobile {
    HelpersMethod utils = new HelpersMethod();
    GlobalParams params = new GlobalParams();

    @FindBy(id = "textview_main_info_top_bar_tabesto_name")
    private WebElement tabestoTextview;
    @FindBy(id = "textview_main_info_top_bar_terminal_name")
    private WebElement terminalTextview;
    @FindBy(id = "textview_price_value")
    private WebElement priceTextview;
    @FindBy(id = "textview_main_order_top_bar_empty")
    private WebElement emptyOrderTextview;
    @FindBy(id = "textview_main_order_top_bar_location")
    private WebElement locationTextview;
    @FindBy(id = "textview_main_info_top_bar_user_name")
    private WebElement userNameTextview;
    @FindAll({ @FindBy (id = "textview_main_menu_item_title")})
    private List<WebElement> listMenuItem;
    @FindAll({ @FindBy(id = "textview_main_product_item_title")})
    private List<WebElement> listProductItem;
    @FindAll({ @FindBy(id = "imageview_main_product_header_item_arrow")})
    private List<WebElement> listTabCategory;
    @FindBy(id = "button_main_info_top_bar_exit")
    private WebElement quitButton;
    @FindBy(id = "button_dialog_simple_vertical_positive")
    private WebElement validateButton;
    @FindBy(id = "topbar_main_content_navigation")
    private WebElement barMenu;
    @FindBy(id = "layout_main_product_item_root")
    private WebElement productItem;
    //private WebElement barMenuItem;
    @FindAll({ @FindBy(id = "layout_main_menu_carousel_item")})
    private List<WebElement> listPictureItem;
    @FindBy(id = "imageview_close_button_icon")
    private WebElement quitSession;
    @FindBy(id = "button_dialog_simple_vertical_positive")
    private WebElement confirmQuitSession;
    @FindBy(id = "textview_inactivity_title")
    private WebElement textview_inactivity_wifi;


    public Boolean exitSession() {
        if (quitSession.isDisplayed())
        {
            quitSession.click();
            confirmQuitSession.click();
            return true;
        }else
        {
            return false;
        }
    }
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

        // BaseMobile.logger.info(listPictureItem.get(0).findElement(By.id("imageview_main_menu_item_picture")).toJson());
         BaseMobile.logger.info(listPictureItem.get(0).findElement(By.id("imageview_main_menu_item_picture")).getCssValue("contentDescription"));
    }
    public String getWifiError() throws IOException {
        String disableWifi = "adb -s "+params.getUDID()+" shell svc wifi disable";
        Runtime.getRuntime().exec(disableWifi);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String enableWifi = "adb -s "+params.getUDID()+" shell svc wifi enable";
        Runtime.getRuntime().exec(enableWifi);
        return textview_inactivity_wifi.getText();
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
        System.out.println(listMenu);
        int size = listMenu.size();
        boolean condition = true;
        do {
            List<String> newList = listMenuItem.stream().map(item -> item.getText()).collect(Collectors.toList());
            scroll("UP");
            List<String> afterScroll = listMenuItem.stream().map(item -> item.getText()).collect(Collectors.toList());
            System.out.println(afterScroll);
            if(newList.equals(afterScroll)){
                condition = false;
            }
            else
           listMenu.addAll(size, afterScroll.subList(afterScroll.indexOf(listMenu.get(size-1))+1, afterScroll.size()));
            System.out.println(listMenu);

        }while (condition);
        return listMenu;
    }
    public List<String> getListProductItemTitle() {
        List<String> listProduct = listProductItem.stream().map(item -> item.getText()).collect(Collectors.toList());
        int size = listProduct.size();
        int maxScroll = 0;
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
    public boolean selectCategory (String category){
        boolean condition = true;
        int maxScroll = 0;
        boolean Found = false;
        utils.log().info("Category Chosen is"+ category);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        do {
            for(WebElement menu : listMenuItem){
                if(menu.getText().equalsIgnoreCase(category)) {
                    menu.click();
                    condition = false;
                    Found = true;
                    break;
                }
            }
            new BaseMobile().scroll("UP");
            maxScroll++;

        }while (condition && maxScroll != 13);
        return Found;
    }

    public String getEmptyTextview() { return emptyOrderTextview.getText();}
    public void clickOnCancelButton() { quitButton.click();}
    public void clickOnOKButton() { validateButton.click();}
    public boolean verifyPresentBarMenu() {
        return barMenu.isDisplayed();
    }
//    public void clickOnBarMenuItem(String item){
//        barMenuItem = androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"" + item + "\"]"));
//        wait.until(ExpectedConditions.visibilityOf(barMenuItem));
//        barMenuItem.click();
//    }
    public void verifyDisplayedProduct() {
        productItem.isDisplayed();

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
