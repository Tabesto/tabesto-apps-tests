package tabesto.testing.pageObjects.mobile.kiosk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.pageObjects.mobile.BaseMobile;
import tabesto.testing.integration.reporter.GlobalParams;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class OrderBorne extends BaseMobile {
    GlobalParams params = new GlobalParams();

    @FindAll({@FindBy (id = "android:id/text1")})
    private List<WebElement> commandCartButton;
    @FindBy(id = "textview_main_cart_order_empty_title")
    private WebElement orderTitleTextview;
    @FindBy(id = "button_main_cart_order_empty_back")
    private WebElement backCartButton;

    @FindBy(css = "tbody tr")
    private List<WebElement> allCategories;
    @FindBy(xpath = "//a[normalize-space()='Confirmer la suppression']")
    private WebElement validateDeleteButton;
    @FindBy(id = "textview_main_cart_confirm_order_title")
    private WebElement confirmPay;
    @FindBy(id = "button_main_cart_order_empty_back")
    private WebElement payChoice;

    @FindBy (id = "textview_order_line_header_item_title")
    private WebElement orderProductOnce;
    @FindAll({@FindBy (id = "textview_order_line_header_item_title")})
    private List<WebElement> orderProduct;
    @FindBy(id = "textview_dialog_send_order_subtitle")
    private WebElement messagePaymentComptoir;
    @FindAll({@FindBy (id = "layout_order_line_header_item_options")})
    private List<WebElement> orderOptions;
    @FindAll({@FindBy (id = "textview_order_line_header_item_price")})
    private List<WebElement> orderPrices;
    @FindAll({@FindBy (id = "recyclerview_order_line_item_choice_list")})
    private List<WebElement> mealSequenceLayout;
    @FindAll({@FindBy (id = "textview_order_line_item_choice_value")})
    private List<WebElement> MealSequenceProducts;
    @FindBy(id = "layout_main_cart_content")
    private WebElement orderScreen;
    @FindBy(id = "textview_price_value")
    private WebElement orderPriceTotal;
    @FindBy(id = "linearlayout_payment_method_button_content")
    private WebElement counterButton;
    @FindAll({@FindBy (id = "textview_payment_method_button_title")})
    private List<WebElement> cbButton;
    @FindBy(id = "textview_bill_print_status")
    private WebElement printStatus;
    @FindBy(id = "textview_payment_instructions")
    private WebElement paymentStatus;

    @FindBy(id = "recyclerview_main_cart_order_line_list")
    private WebElement recycleViewCart;


    public List<String> getPrices(){
        List<String> listMenu = orderPrices.stream().map(item -> item.getText()).collect(Collectors.toList());
        System.out.println(listMenu);
        return listMenu;
    }

    public OrderBorne() {

    }
    public String getStatusPrint(){
        int maxTry = 0;
        if (printStatus.isDisplayed()){
           while (!Objects.equals(printStatus.getText(), "Ticket imprimé !") || maxTry != 7){
               maxTry++;
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        }
        return printStatus.getText();
    }

    public String getStatusCB(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("payment_message"+paymentStatus.getText());
        return paymentStatus.getText().trim();
    }

    public void clickOnMaCommand() {
        commandCartButton.get(1).click();
    }

    public void clickOnLaCarte() {
        commandCartButton.get(0).click();
    }
    public void clickOnCounterPayment() {
        counterButton.click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickOnCBPayment() throws IOException {
        cbButton.get(cbButton.size() - 1).click();
        String disableWifi = "adb -s "+params.getUDID()+" shell svc wifi disable";
        Runtime.getRuntime().exec(disableWifi);
        try {
            Thread.sleep(420000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String enableWifi = "adb -s "+params.getUDID()+" shell svc wifi enable";
        Runtime.getRuntime().exec(enableWifi);

    }

    public void confirmerPayment() {
        confirmPay.click();

    }
    public String getMessageOnScreen() {
      return orderTitleTextview.getText();
    }

    public String getTitle() {
        return payChoice.getText();
    }
    public String getMessageConfirmationPayment() {
        return messagePaymentComptoir.getText();
    }

    public List<String> getProduct(){
        List<String> listMenu = orderProduct.stream().map(item -> item.getText().toLowerCase(Locale.ROOT)).collect(Collectors.toList());
        System.out.println(listMenu);
        return listMenu;
    }

    public Map<String, String> getAllProduct(){
        Map<String, String> AllProduct = new HashMap<>();
        Map<String, Object> globalOrder = new HashMap<>();
        globalOrder.put("orderPriceTotal",orderPriceTotal.getText());
        int maxScroll = 0;
        int i = 0;
        List<String> products = orderProduct.stream().map(item -> item.getText().toLowerCase(Locale.ROOT).trim()).collect(Collectors.toList());
        List<String> prices = orderPrices.stream().map(item -> item.getText().toLowerCase(Locale.ROOT).trim()).collect(Collectors.toList());
        do {
            int size = products.size();
            System.out.println("new size is "+ size);
            for (; i <= 1; i++) {
                Map<String, String> AllProduct1 = new HashMap<>();
                Map<String, String> AllProduct2 = new HashMap<>();
                System.out.println("LinearLayout"+i);

                List<WebElement> ListOfChoices = orderScreen.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout[" + (i + 1) + "]//" +
                        "android.widget.TextView[contains(@resource-id,'textview_order_line_item_choice_value')]"));

                if (!ListOfChoices.isEmpty()) {
                    for (int j = 0; j < ListOfChoices.size(); j++) {
                        List<WebElement> ListProductsOptions = orderScreen.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout[" + (i + 1) + "]" +
                                "//android.view.ViewGroup[" + (j + 1) + "]/android.widget.RelativeLayout/android.widget.TextView"));
                        WebElement Product1 = orderScreen.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout[" + (i + 1) + "]" +
                                "//android.view.ViewGroup[" + (j + 1) + "]/android.widget.TextView[contains(@resource-id,'textview_order_line_item_choice_value')]"));
                        List<String> listMenu = ListProductsOptions.stream().map(item -> item.getText().toLowerCase(Locale.ROOT).trim()).collect(Collectors.toList());
                        if (!globalOrder.containsKey(Product1.getText().toLowerCase(Locale.ROOT))){
                            AllProduct1.put("choice" + j, Product1.getText().toLowerCase(Locale.ROOT));
                            AllProduct1.put("Options" + j, String.join(",", listMenu));
                        }
                    }
                    AllProduct1.put("price", prices.get(i));
                    globalOrder.put(products.get(i).toLowerCase(Locale.ROOT), AllProduct1);
                    System.out.println("beforeUpdate"+ globalOrder);

                } else {
                    List<WebElement> ListOptions = orderScreen.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout[" + (i+1) + "]" +
                            "//android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.TextView"));
                    List<String> listMenu = ListOptions.stream().map(item -> item.getText().toLowerCase(Locale.ROOT).trim()).collect(Collectors.toList());
                    if (!globalOrder.containsKey(products.get(i).toLowerCase(Locale.ROOT))){
                        AllProduct2.put("Options", String.join(",", listMenu));
                        AllProduct2.put("price", prices.get(i));
                        globalOrder.put(products.get(i).toLowerCase(Locale.ROOT), AllProduct2);
                    }
                }
            }
            maxScroll++;

        }while (maxScroll != 3);

        return AllProduct;
    }

    public void getProductsFromCart() throws InterruptedException {
        List<String> productInfo = new ArrayList<>();

        List<WebElement> textViewInsideRecycleView = new ArrayList<>();
        for (WebElement textView:recycleViewCart.findElements(By.className("android.widget.TextView"))) {
                if (textView.getLocation().y > recycleViewCart.getLocation().y && textView.getSize().getHeight() < recycleViewCart.getSize().getHeight()){
                    textViewInsideRecycleView.add(textView);
                }
        }

            switch (orderProduct.size()) {
                case 1:
                    productInfo.addAll(textViewInsideRecycleView.stream().
                            map(item -> item.getText().toLowerCase(Locale.ROOT).trim()).collect(Collectors.toList()));
                    break;
                case 2:
                    for (WebElement text : textViewInsideRecycleView) {
                        if (text.getLocation().y > orderProduct.get(0).getLocation().y && text.getLocation().y < orderProduct.get(1).getLocation().y) {
                            productInfo.add(text.getText());

                        } else if (text.getLocation().y > orderProduct.get(1).getLocation().y) {
                            productInfo.add(text.getText());

                        }
                    }
                    break;
                case 3:
                    for (WebElement text : textViewInsideRecycleView) {

                        if (text.getLocation().y >= orderProduct.get(0).getLocation().y
                                && text.getLocation().y < orderProduct.get(1).getLocation().y) {
                            productInfo.add(text.getText());

                        } else if (text.getLocation().y >= orderProduct.get(1).getLocation().y
                                && text.getLocation().y < orderProduct.get(2).getLocation().y) {
                            productInfo.add(text.getText());

                        } else if (text.getLocation().y >= orderProduct.get(2).getLocation().y) {
                            productInfo.add(text.getText());
                        }
                    }
                    break;
                case 4:
                    for (WebElement text : textViewInsideRecycleView) {
                        if (text.getLocation().y >= orderProduct.get(0).getLocation().y
                                && text.getLocation().y < orderProduct.get(1).getLocation().y) {
                            productInfo.add(text.getText());

                        } else if (text.getLocation().y >= orderProduct.get(1).getLocation().y
                                && text.getLocation().y < orderProduct.get(2).getLocation().y) {

                            productInfo.add(text.getText());

                        } else if (text.getLocation().y >= orderProduct.get(2).getLocation().y
                                && text.getLocation().y < orderProduct.get(3).getLocation().y) {

                            productInfo.add(text.getText());

                        } else if (text.getLocation().y >= orderProduct.get(3).getLocation().y) {
                                productInfo.add(text.getText());
                        }
                    }
                    break;
            }
    }


    public boolean isDisplayedBackToCart() {
        return backCartButton.isDisplayed();
    }
}
