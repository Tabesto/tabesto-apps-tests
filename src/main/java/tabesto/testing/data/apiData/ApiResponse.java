package tabesto.testing.data.apiData;


import com.jayway.jsonpath.JsonPath;
import tabesto.testing.config.Settings;
import tabesto.testing.enums.PathEndPoint;
import tabesto.testing.enums.TabestoApi;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tabesto.testing.utils.HelpersMethod;

import java.util.Date;
import java.util.HashMap;

public class ApiResponse {
    static HelpersMethod utils = new HelpersMethod();

    public static Response getResponseData(String EndPoint, Cookies cookies){
        Response response = GetRequestDef.get(EndPoint, cookies, TabestoApi.TABESTO_BACK);
        if (response.getStatusCode() != 200){
            utils.log().info("Failed to Fetch token From HTML,HTTP status Code: "+ response.getStatusCode());

            throw new RuntimeException("Failed to Fetch token From HTML,HTTP status Code: "+ response.getStatusCode());
        }
        return response;
    }


    public static void getAllCustomProducts(Cookies cookies) throws JSONException {
        Date now = new Date();
        String path = "src/test/resources/customProducts.json";
        Response response = GetRequestDef.get(PathEndPoint.GET_LIST_CUSTOM_PRODUCTS.url + now.getTime(),cookies, TabestoApi.TABESTO_BACK);
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to Fetch Products,HTTP status Code: "+ response.getStatusCode());
        }
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        String products = JsonPath.read(responseJSONObject,
                "$.data").toString();

        HelpersMethod.writeJsonStringToFile(path,products);
    }

    public static void getAllProducts(Cookies cookies) throws JSONException {
        Date now = new Date();
        String path = "src/test/resources/allProducts.json";
        Response response = GetRequestDef.get(PathEndPoint.GET_ALL_PRODUCTS.url+ now.getTime(),cookies, TabestoApi.TABESTO_BACK);
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to Fetch Products,HTTP status Code: "+ response.getStatusCode());
        }
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        String products = JsonPath.read(responseJSONObject.getJSONObject("data").toString(),
                "$.referencesBySelectedTypeAndMenu").toString();

        HelpersMethod.writeJsonStringToFile(path,products);
    }

    public static void getAllCategory(Cookies cookies) throws JSONException {
        Date now = new Date();
        String path = "src/test/resources/Category.json";
        Response response = GetRequestDef.get(PathEndPoint.GET_ALL_CATEGORIES.url+ now.getTime(),cookies, TabestoApi.TABESTO_BACK);
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to Fetch the Category,HTTP status Code: "+ response.getStatusCode());
        }
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        String categoryActive = JsonPath.read(responseJSONObject.getJSONObject("data").toString(),
                "$.sectionsBySelectedTypeAndMenu[?(@.label=='"+fetchWordingActiveMenu(cookies)+"')]").toString();

        HelpersMethod.writeJsonStringToFile(path,categoryActive);


    }
    public static Response getListCategories(Cookies cookies){
        Response response = GetRequestDef.get(PathEndPoint.GET_LIST_CATEGORY.url,cookies, TabestoApi.TABESTO_BACK);
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to Fetch the account,HTTP status Code: "+ response.getStatusCode());
        }
        return response;
    }
    public static Response getEditProduct(String customProductId,Cookies cookies){

        return GetRequestDef.get(PathEndPoint.EDIT_CUSTOM_PRODUCT_PARENT.url + customProductId,
                cookies, TabestoApi.TABESTO_BACK );
    }

    private static String fetchWordingActiveMenu(Cookies cookies){
        Response response = getResponseData(PathEndPoint.GET_LIST_CATEGORY.url,cookies);
        String wordingMenuActive = "";
        Elements options = Jsoup.parse(response.body().prettyPrint()).select("option");
        for (Element option :options){
            if (option.attr("value").equals(getMenuAvailability())){
                wordingMenuActive = option.text();
            }
        }
        return wordingMenuActive;
    }


    public static String OauthToOca(Cookies cookies){
        Header header = new Header("content-type","application/json; charset=UTF-8");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        HashMap<String,Object> formParamsCustom = new HashMap<>();
        formParams.put("username","2d4ecd4d-f21d-4a18-bd64-977df1df1aef");
        formParams.put("isAdmin", false);
        formParams.put("appV","1.2.0-rc.2+kiosk.qa.cf0ba350");
        formParams.put("appPackageName","com.tabesto.kiosk.debug");
        formParamsCustom.put("user",formParams);
        Response response= PosRequestDef.post(PathEndPoint.OAUTH.url,headers,cookies,formParamsCustom, TabestoApi.TABESTO_BACK);
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to Register the account,HTTP status Code: "+ response.getStatusCode());
        }
        return response.jsonPath().getString("onsite_core_api.token");
    }

    public static String getMenuAvailability(){
        Cookies cookies = new Cookies();
        Header header = new Header("authorization","Bearer "+OauthToOca(cookies));
        Headers headers = new Headers(header);
        String uri = PathEndPoint.OCA_SELLER.url + Settings.getInstance().getSellerName() + PathEndPoint.MENU_AVAILABILITY.url;
        Response response = GetRequestDef.get(uri,headers,cookies, TabestoApi.OCA);
        System.out.println(response.prettyPrint());
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to Fetch Menu AVAILABILITY,HTTP status Code: "+ response.getStatusCode());
        }
        if (response.jsonPath().getString("data.menu_availability.current_menus[0].menu_id") != null)
            return response.jsonPath().getString("data.menu_availability.current_menus[0].menu_id");
        else throw new RuntimeException("NONE MENU ACTIVATED");

    }
}
