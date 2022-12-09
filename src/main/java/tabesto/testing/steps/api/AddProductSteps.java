package tabesto.testing.steps.api;



import tabesto.testing.data.apiData.PosRequestDef;
import tabesto.testing.enums.PathEndPoint;
import tabesto.testing.enums.TabestoApi;
import tabesto.testing.enums.ProductType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import tabesto.testing.model.Category;
import tabesto.testing.model.Product;
import org.json.JSONException;
import org.testng.Assert;
import tabesto.testing.data.apiData.ApiResponse;
import tabesto.testing.utils.transformer.HtmlToObject;
import tabesto.testing.utils.generator.FakerData;
import tabesto.testing.model.DataSet;
import tabesto.testing.utils.HelpersMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static tabesto.testing.enums.ProductType.PRODUCT;


public class AddProductSteps {

    private static Cookies cookies = new Cookies();
    private static Response response;
    private String location;
    private String productName;
    private String optionId;
    HelpersMethod utils = new HelpersMethod();


    @Given("I perform authentication operation for {string} with body")
    public void iPerformAuthenticationOperationForWithBody(String url, DataTable table) {

        response = ApiResponse.getResponseData(PathEndPoint.LOGIN.url,cookies);
        cookies = response.getDetailedCookies();
        String token = HtmlToObject.fetchTokenFoodFromHtmlResponse(response,
                "**.findAll {it.@name=='_csrf_token'}.@value");
        List<String> myCsrfToken = new ArrayList<>();
        myCsrfToken.add(token);
        myCsrfToken.add(token);
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        formParams.put("_csrf_token",myCsrfToken);
        formParams.put("_username", table.row(1).get(0) );
        formParams.put("_password",table.row(1).get(1));
        formParams.put("_submit","Connectez-vous");
        response = PosRequestDef.post(url,headers,formParams,cookies, TabestoApi.TABESTO_BACK);
        cookies = response.getDetailedCookies();
        DataSet.getInstance().setCookies(cookies);
    }

    @Then("User is authenticated with success")
    public void userIsAuthenticatedWithSuccess() {
        Assert.assertEquals(response.getStatusCode(),302);
    }

    @When("^User create \"([^\"]*)\" new Products")
    public void userCreateANewProduct(int productsNumber, DataTable table) throws IOException, InterruptedException, JSONException {

        ApiResponse.getAllCategory(cookies);
        Category category = new Category(table.row(1).get(3),true);
        if (category.getSectionId() == 0){
            utils.log().info("Category under test not found");
            DataSet.getInstance().setErrorMessage("Category under test not found");
            throw new RuntimeException("Category under test not found");
        }

        for (int iterator = 1; iterator <= productsNumber;iterator++) {

            productName = FakerData.generateRandomFoodName() + FakerData.generateRandomNumber(2);
            Product product = new Product(productName, "description" + FakerData.generateRandomNumber(7),
                    "details" + FakerData.generateRandomNumber(7), FakerData.generateRandomNumber(2));
            DataSet.getInstance().getProductsCreated().add(productName);
            Header header = new Header("content-type", "application/x-www-form-urlencoded");
            Headers headers = new Headers(header);
            HashMap<String, Object> formParams = new HashMap<>();
            formParams.put("food[type]: 1", table.row(1).get(0).equals("FOOD") ? 1 : 0);
            formParams.put("food[isCustomProduct]", table.row(1).get(1).equals("NON") ? 0 : 1);
            formParams.put("food[menuOnly]", table.row(1).get(2).equals("NON") ? 0 : 1);
            formParams.put("food[name]", product.getName());
            formParams.put("food[sectionsDirect][]", category.getSectionId());
            formParams.put("food[description]", product.getDescription());
            formParams.put("food[details]", product.getDetails());
            formParams.put("food[allergens][]", 1);
            formParams.put("food[price]", product.getPp());
            formParams.put("secondaryPrice", product.getPp());
            if (optionId != null){
                formParams.put("food[paramType][0][paramType]", optionId);
                formParams.put("food[paramType][0][weight]", 1);
            }
            formParams.put("food[background][x]", "");
            formParams.put("food[background][y]", "");
            formParams.put("food[background][width]", "");
            formParams.put("food[background][height]", "");
            formParams.put("food[background][image]", "");
            formParams.put("food[miniature][x]", "");
            formParams.put("food[miniature][y]", "");
            formParams.put("food[miniature][width]", "");
            formParams.put("food[miniature][height]", "");
            formParams.put("food[miniature][image]", "");
            formParams.put("food[save]", "");
            formParams.put("food[_token]", HtmlToObject.
                    fetchTokenFoodFromHtmlResponse(ApiResponse.getResponseData(PathEndPoint.ADD_NEW_PRODUCT.url,cookies), "**.findAll {it.@name=='food[_token]'}.@value"));

            response = PosRequestDef.post(PathEndPoint.ADD_NEW_PRODUCT.url, headers, formParams, cookies, TabestoApi.TABESTO_BACK);
        }
    }

    @Then("Product is created with success")
    public void productIsCreatedWithSuccess() throws JSONException, InterruptedException {
        Assert.assertEquals(response.getStatusCode(),302);
        ApiResponse.getAllProducts(cookies);
        Thread.sleep(20000);

    }

    @And("User create a new custom Product Parent")
    public void userCreateANewCustomProductParent(DataTable table) throws IOException, InterruptedException {

        Category category = new Category(table.row(1).get(1),true);
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        formParams.put("custom_product[type]", table.row(1).get(0).equals("FOOD") ? 1 : 0);
        formParams.put("custom_product[name]", "PAC"+ FakerData.generateRandomNumber(2));
        formParams.put("custom_product[sectionsDirect][]", category.getSectionId());
        formParams.put("custom_product[choiceTitle]","choiceTitle");
        formParams.put("custom_product[description]","test_description");
        formParams.put("custom_product[details]","test_details");
        formParams.put("custom_product[background][x]","");
        formParams.put("custom_product[background][y]","");
        formParams.put("custom_product[background][width]","");
        formParams.put("custom_product[background][height]","");
        formParams.put("custom_product[background][image]","");
        formParams.put("custom_product[miniature][x]","");
        formParams.put("custom_product[miniature][y]","");
        formParams.put("custom_product[miniature][width]","");
        formParams.put("custom_product[miniature][height]","");
        formParams.put("custom_product[miniature][image]","");
        formParams.put("custom_product[isCustomProduct]",1);
        formParams.put("custom_product[save]","");
        formParams.put("custom_product[isCustomProductParent]",1);
        formParams.put("custom_product[_token]", HtmlToObject.
                fetchTokenFoodFromHtmlResponse(ApiResponse.getResponseData(PathEndPoint.ADD_CUSTOM_PRODUCT_PARENT.url,cookies),
                        "**.findAll {it.@name=='custom_product[_token]'}.@value"));
        response = PosRequestDef.post(PathEndPoint.ADD_CUSTOM_PRODUCT_PARENT.url,headers,formParams,cookies, TabestoApi.TABESTO_BACK);
        this.location = response.getHeader("location");
    }

    @Then("Custom Product is created with success")
    public void customProductIsCreatedWithSuccess() {
        Assert.assertEquals(response.getStatusCode(),302);
    }

    @And("User add customs Products Child to custom Product Parent")
    public void userAddCustomProductChildToCustomProductParent() throws IOException {

        String customProductId;
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        customProductId = HelpersMethod.matchStringWithInputRegex("(\\d+)",location).get(0);
        int stepIndex = 0;
        for (String productCreated: DataSet.getInstance().getProductsCreated()) {
            Product product = new Product(productCreated,PRODUCT);
            formParams.put("custom_product_menu_choice_collection[formMenuWithStep]["+stepIndex+"][fromFood]",customProductId);
            formParams.put("custom_product_menu_choice_collection[formMenuWithStep]["+stepIndex+"][toFood]", product.getReferenceId());
            formParams.put("custom_product_menu_choice_collection[formMenuWithStep]["+stepIndex+"][extraPrice]","");
            formParams.put("custom_product_menu_choice_collection[formMenuWithStep]["+stepIndex+"][step]",0);
            formParams.put("custom_product_menu_choice_collection[formMenuWithStep]["+stepIndex+"][weight]",stepIndex);
            formParams.put("custom_product_menu_choice_collection[submit]","");
            formParams.put("custom_product_menu_choice_collection[_token]", HtmlToObject.
                    fetchTokenFoodFromHtmlResponse(ApiResponse.getEditProduct(customProductId,cookies),
                            "**.findAll {it.@name=='custom_product_menu_choice_collection[_token]'}.@value"));
            String url = location.substring(0,location.lastIndexOf("?"));
            response = PosRequestDef.post(url,headers,formParams,cookies, TabestoApi.TABESTO_BACK);
            stepIndex++;

        }

    }

    @And("^User create an option with many choices with max allowed \"([^\"]*)\"")
    public void userCreateOptionWithChoices(String maxAllowedPerOptionChoice,DataTable table) {

        List<String> maxOptionsChoices= Stream.of(maxAllowedPerOptionChoice.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        formParams.put("ParamTypeType[type]:", table.row(1).get(0).equals("FOOD") ? 1 : 0);
        formParams.put("ParamTypeType[name]", "Option" + FakerData.generateRandomNumber(6));
        formParams.put("ParamTypeType[description]", "Description" + FakerData.generateRandomNumber(2));
        formParams.put("ParamTypeType[maxAllowed]",table.row(1).get(1));
        formParams.put("ParamTypeType[multiple]",table.row(1).get(2).equals("OUI") ? 1 : 0);
        formParams.put("ParamTypeType[required]",table.row(1).get(3).equals("OUI") ? 1 : 0);
        formParams.put("ParamTypeType[quantitative]",table.row(1).get(4).equals("OUI") ? 1 : 0);
        formParams.put("ParamTypeType[extraPriceFormat]",0);
        formParams.put("ParamTypeType[withImages]",table.row(1).get(5).equals("OUI") ? 1 : 0);
        formParams.put("ParamTypeType[_token]", HtmlToObject.
                fetchTokenFoodFromHtmlResponse(ApiResponse.getResponseData(PathEndPoint.GET_OPTION.url,cookies),
                        "**.findAll {it.@name=='ParamTypeType[_token]'}.@value"));
        int stepIndex = 0;

        for (String param:maxOptionsChoices) {
            formParams.put("ParamTypeType[params]["+stepIndex+"][name]", FakerData.generateRandomOptionName() + FakerData.generateRandomNumber(2));
            formParams.put("ParamTypeType[params]["+stepIndex+"][price]", FakerData.generateRandomNumber(1));
            formParams.put("ParamTypeType[params]["+stepIndex+"][secondaryPrice]",0);
            if (table.row(1).get(2).equals("OUI")){
                formParams.put("ParamTypeType[params]["+stepIndex+"][maxAllowed]",param);
            }
            formParams.put("ParamTypeType[params]["+stepIndex+"][croppedImageVariant]","");
            formParams.put("ParamTypeType[params]["+stepIndex+"][weight]",0);
            formParams.put("ParamTypeType[params]["+stepIndex+"][imageVariant][x]","");
            formParams.put("ParamTypeType[params]["+stepIndex+"][imageVariant][y]","");
            formParams.put("ParamTypeType[params]["+stepIndex+"][imageVariant][width]","");
            formParams.put("ParamTypeType[params]["+stepIndex+"][imageVariant][height]","");
            formParams.put("ParamTypeType[params]["+stepIndex+"][imageVariant][image]","");
            stepIndex++;
        }
        response = PosRequestDef.post(PathEndPoint.GET_OPTION.url, headers,formParams,cookies, TabestoApi.TABESTO_BACK);
        optionId = response.jsonPath().getString("id");

    }


    @And("^User modify disponibility for \"([^\"]*)\" Products")
    public void userModifyDisponibilityForNewProduct(int productsNumber,DataTable table) throws IOException, JSONException, InterruptedException {
        ApiResponse.getAllProducts(cookies);
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        int it = 0;
        Product product;
        for (int stepIndex = 1 ; stepIndex < productsNumber + 1; stepIndex++){
            if (Objects.equals(table.row(stepIndex).get(0), "NewProduct")){
                product = new Product(DataSet.getInstance().getProductsCreated().get(stepIndex-1), ProductType.valueOf(table.row(stepIndex).get(2)));
            } else {
                product = new Product(table.row(stepIndex).get(0), ProductType.valueOf(table.row(stepIndex).get(2)));
            }
            if (product.getReferenceId() == null){
                throw new RuntimeException("Product "+ table.row(stepIndex).get(0) + " not found");
            }
            formParams.put("map[food]["+it+"][food]", product.getReferenceId());
            formParams.put("map[food]["+it+"][availability]", table.row(stepIndex).get(1));
            it++;
        }
        Response response = PosRequestDef.post(PathEndPoint.EDIT_AVAILABILITY.url, headers,formParams,cookies, TabestoApi.TABESTO_BACK);
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to Change Availability,HTTP status Code: "+ response.getStatusCode());
        }
        Thread.sleep(5000);
   }
}
