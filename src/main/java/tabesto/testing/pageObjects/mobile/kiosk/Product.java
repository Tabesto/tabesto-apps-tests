package tabesto.testing.pageObjects.mobile.kiosk;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.config.Settings;
import tabesto.testing.pageObjects.mobile.BaseMobile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tabesto.testing.config.ConfigReader;
import tabesto.testing.utils.transformer.JsonSerializer;
import tabesto.testing.utils.HelpersMethod;
import tabesto.testing.utils.generator.FakerData;

import static java.util.stream.Collectors.toList;


public class Product extends BaseMobile {
    HelpersMethod utils = new HelpersMethod();

    @FindAll({ @FindBy(id = "layout_main_product_item_root")})
    private List<WebElement> listProduct;
    @FindBy(id = "textview_main_product_item_price")
    private WebElement priceProductTextview;
    @FindAll({ @FindBy(id = "textview_main_product_item_title")})
    private List<WebElement> titleProductTextview;
    @FindBy(id = "edittext_quantity_view_quantity")
    private WebElement quantityTextview;
    @FindBy(id="button_detail_bottom_bar_add")
    private WebElement addButton;
    @FindBy(id="button_detail_bottom_bar_back")
    private WebElement returnButton;
    @FindAll({ @FindBy(id = "textview_product_option_multiple_item_title")})
    private List<WebElement> listOptionsMultiple;
    @FindAll({ @FindBy(id = "textview_product_option_multiple_item_supplement")})
    private List<WebElement> priceOptions;
    @FindAll({ @FindBy(id = "button_suggestion_conversion_alright")})
    private List<WebElement>  nonMerciButton;
    @FindBy(id="textview_main_product_detail_info_title")
    private WebElement titleProduct;
    @FindAll({ @FindBy(id = "layout_order_line_header_item_options")})
    private List<WebElement> optionsMealSequence;
    @FindAll({@FindBy (id="textview_order_line_header_item_title")})
    private List<WebElement>  choicesMealSequence;
    @FindAll({@FindBy (id="layout_main_product_item_root")})
    private List<WebElement> layoutMealSequence;
    @FindAll({@FindBy (id="textview_product_option_unique_item_title")})
    private List<WebElement> listOptionsUnique;
    @FindAll({@FindBy (id="view_product_option_comment_item_header_title")})
    private List<WebElement> comment;
    @FindAll({@FindBy (id="textview_snack_bar_message")})
    private List<WebElement> snackBar;
    @FindAll({@FindBy (id="textview_main_product_item_unavailable_tag")})
    private List<WebElement> unavailableText;
    @FindAll({@FindBy (id="layout_product_option_quantity_item_quantity")})
    private List<WebElement> quantitiveOptions;
    @FindBy (id="recyclerview_main_product_list")
    private WebElement recycleViewAllProducts;
    @FindBy(id = "layout_main_product_detail_info_content")
    private WebElement productScreen;
    @FindBy(id = "textview_dialog_simple_vertical_message")
    private WebElement popinUpdateAvailability;
    @FindBy(id = "button_dialog_simple_vertical_positive")
    private WebElement buttonOKForPopinUpdateAvailability;



    public List<WebElement> getListProduct() {
        return listProduct;
    }
    public List<WebElement> getListOptions() {
        return listOptionsMultiple;
    }

    public Product addProduct() {
        addButton.click();
        return this;
    }
    public String getQuantity() {
        return quantityTextview.getText();
    }
    public String getNameOfProduct() {
        return titleProduct.getText();
    }



    public HashMap<String, Object> selectProduct(String productTitle, boolean Meal, boolean search) throws InterruptedException {
        HashMap<String,Object> productInfo = new HashMap<>();

        List<WebElement> list = Meal ? layoutMealSequence:listProduct;
        productInfo.put("FOUND", false);

        int maxScroll = 0;
        do {
            for(WebElement product : list){
                if (product.getSize().getHeight() > 200) {
                    if (product.findElement(By.id("textview_main_product_item_title")).getText().
                            equalsIgnoreCase(productTitle)) {
                        if (!search){
                            product.click();
                        }else {
                            productInfo.put("PRODUCT",product.getLocation().y);
                        }
                        productInfo.put("FOUND", true);
                        return productInfo;
                    }
                }
            }
            scroll("UP");
            maxScroll++;
            Thread.sleep(3000);

        }while (maxScroll != 7);

        return productInfo;
    }


    public void selectOptions(String choices,List<WebElement> list){
        list.forEach( option -> {
            if(choices.toLowerCase(Locale.ROOT).contains(option.getText().toLowerCase(Locale.ROOT))){
                option.click();
            }
        });

    }
    public void fetchAllOptions(String choices){
        selectOptions(choices,listOptionsUnique);
        selectOptions(choices,listOptionsMultiple);
    }

    public Boolean searchProductInfoOnListCategory(String productToFind) throws InterruptedException {
        int minY = 90;
        int maxY = 200;
        HashMap<String,Object> productsInfo = selectProduct(productToFind, false,true);
        int productFoundIsHeight = 0;
        if (((Boolean) productsInfo.get("FOUND")))
            productFoundIsHeight = (int) productsInfo.get("PRODUCT");

        else return false;

        for (WebElement tagUnavailable : unavailableText) {
            int diffHeight = tagUnavailable.getLocation().y - productFoundIsHeight;
            if (diffHeight >= minY && diffHeight < maxY){
                return true;
            }
        }
        return false;

    }

    public void selectOptions() throws InterruptedException {
        int maxScroll = 0;
        int minHeight = 250;
        List<String> optionsFound = new ArrayList<>();
        boolean condition = true;

        do {
            scroll("UP");
            Thread.sleep(5000);
            List<WebElement> optionsChoicesNumber = productScreen.findElements(By.xpath("//android.widget.LinearLayout//androidx.recyclerview.widget.RecyclerView" +
                    "//android.widget.LinearLayout[not(contains(@resource-id,'view_product_option_header_title'))]"));

            if (!comment.isEmpty()) {
                optionsChoicesNumber = optionsChoicesNumber.subList(0,(optionsChoicesNumber.size())-2);
                condition = false;
            }

            List<WebElement> randomOptions= new ArrayList<>();

            for (int i = 0; i < optionsChoicesNumber.size(); i++) {

                if(optionsChoicesNumber.get(i).getSize().height > minHeight){

                    List<WebElement> optionsChoices = productScreen.findElements(By.xpath("//android.widget.LinearLayout//androidx.recyclerview.widget.RecyclerView" +
                            "//android.widget.LinearLayout["+ (i + 1)+"]" +
                            "//android.view.ViewGroup//android.widget.TextView[contains(@resource-id,'textview_product_option_unique_item_title') " +
                            "or contains(@resource-id,'textview_product_option_multiple_item_title') " +
                            "or contains(@resource-id,'textview_product_option_quantity_item_title')]"));

                    List<String> listOptions = optionsChoices.stream().map(item -> item.getText().toLowerCase(Locale.ROOT).trim()).collect(Collectors.toList());
                    List<String> diffOptions = listOptions.stream()
                            .filter(item -> ! optionsFound.contains(item))
                            .collect(Collectors.toList());


                    for (WebElement option:optionsChoices) {
                        if (!optionsFound.contains(option.getText().toLowerCase(Locale.ROOT)))
                            randomOptions.add(option);
                    }
                    optionsFound.addAll(diffOptions);

                    if (randomOptions.size() != 0){
                        Random rand = new Random();
                        int randomIndex = rand.nextInt(randomOptions.size());
                        List<WebElement> addOptions = productScreen.findElements(By.xpath("//android.widget.LinearLayout//androidx.recyclerview.widget.RecyclerView" +
                                "//android.widget.LinearLayout["+ (i + 1)+"]" +
                                "//android.view.ViewGroup//android.widget.ImageView[contains(@resource-id,'imageview_quantity_view_add')]"));
                        if (!addOptions.isEmpty() && addOptions.size() >= 3){
                            for (WebElement option: FakerData.pickRandom(addOptions,3)) {
                                option.click();
                            }
                        }
                        else if(randomOptions.size() >= 3) {
                            for (WebElement option: FakerData.pickRandom(randomOptions,3)) {
                                option.click();
                            }
                        }
                        else {
                            randomOptions.get(randomIndex).click();
                        }

                    }
                    randomOptions.clear();
                }

            }
            maxScroll++;

        } while (maxScroll != 9 && condition);
    }


    public void isDisplayedNonMerci() {
        while (!nonMerciButton.isEmpty()) {
            nonMerciButton.get(0).click();
        }
    }

    public List<String> getAllOptions() {

        List<String> OptionsFound = new ArrayList<String>();
        int maxScroll = 0;

        do {
            scroll("UP");
            List<WebElement> newList = Stream.concat(listOptionsMultiple.stream(), listOptionsUnique.stream())
                    .collect(Collectors.toList());
            maxScroll++;
            for(WebElement option : newList){
                OptionsFound.add(option.getText());
                System.out.println(option.getAccessibleName());

            }

        }while (maxScroll != 3);

        return OptionsFound;
    }


    public boolean selectOptions1(String choices) {

        String[] choicesList = choices.split(",");
        List<String> listOfOptions = Arrays.stream(choicesList).collect(toList());
        List<String> OptionsFound = new ArrayList<String>();
        boolean Found = false;
        int maxScroll = 0;
        int optionsFound = 0;

        do {
            scroll("UP");
            List<WebElement> newList = Stream.concat(listOptionsMultiple.stream(), listOptionsUnique.stream())
                    .collect(Collectors.toList());
            maxScroll++;
            for(WebElement option : newList){
                if(choices.toLowerCase(Locale.ROOT).contains(option.getText().toLowerCase(Locale.ROOT)) && !OptionsFound.contains(option.getText())) {
                    option.click();
                    optionsFound++;
                    OptionsFound.add(option.getText());
                    if (optionsFound == listOfOptions.size()){
                        System.out.println("All options Found");
                        Found = true;
                    }
                }
            }

        }while (optionsFound != listOfOptions.size() && maxScroll != 11);

        return Found;
    }


    public Map<String, String> getListOptionsItemTitle() {

        List<String> newList = listOptionsMultiple.stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(newList);
        List<String> listPrices = priceOptions.stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(listPrices);
        Map<String, String> product = new HashMap<>();
        product.put("Product", getNameOfProduct());
        for (int iterator=0;iterator < newList.size(); iterator++){
            if (TextUtils.isEmpty(listPrices.get(iterator))){ product.put(newList.get(iterator), "0");
            } else {product.put(newList.get(iterator), listPrices.get(iterator));}
        }
        System.out.println(product);
        return product;
    }
    public void retourButton() {
        if (returnButton.isDisplayed()) {
            returnButton.click();
        }
    }
    public Map<String, String> checkProductAndOptionsOnAllChoice(){
        Map<String, String> listOptionsMealSequence = new HashMap<>();
        List<String>listOptionsMealSequence1;
        if (optionsMealSequence.size() > 0) {
            int i = 0;
            for (WebElement webElement : optionsMealSequence) {
                List<WebElement> List = webElement.findElements(By.xpath("//android.widget.RelativeLayout/android.widget.TextView"));
                listOptionsMealSequence1 = List.stream().map(item -> item.getText().toLowerCase(Locale.ROOT)).collect(Collectors.toList());
                String joined = String.join(",", listOptionsMealSequence1);
                listOptionsMealSequence.put(choicesMealSequence.get(i).getText().toLowerCase(Locale.ROOT),joined);
                i++;
            }
        }
        return listOptionsMealSequence;

    }
    public Boolean verifyDisplayOfPopinAndCheckAvailabilityOfProduct() throws IOException, InterruptedException {

        Map strings = JsonSerializer.toObject(Settings.getInstance().getPathString(), Map.class);
        if (!popinUpdateAvailability.isDisplayed()) return false;
        else if (!popinUpdateAvailability.getText().contains(strings.get("popinUpdateAvailability").toString())) return false;
        buttonOKForPopinUpdateAvailability.click();
        if (!unavailableText.get(0).getText().contains(strings.get("wordingTextUnavailable").toString())) return false;
        return !addButton.isSelected();
    }
}
