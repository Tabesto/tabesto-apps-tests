package tabesto.testing.steps.api;


import tabesto.testing.data.apiData.PosRequestDef;
import tabesto.testing.enums.PathEndPoint;
import tabesto.testing.enums.TabestoApi;
import io.cucumber.java.en.Given;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import tabesto.testing.data.apiData.ApiResponse;
import tabesto.testing.utils.transformer.HtmlToObject;
import tabesto.testing.model.DataSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisableCardSteps {
    private static final Cookies cookies = DataSet.getInstance().getCookies();
    private static Response response;

    @Given("User disable active Card")
    public void userDisableActiveCard() {
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Header header1 = new Header("x-requested-with" ,"XMLHttpRequest");
        Headers headers = new Headers(header,header1);
        HashMap<String,Object> formParams;
        List<Integer> menuTags = new ArrayList<>();
        String activeMenu = ApiResponse.getMenuAvailability();
        response = ApiResponse.getResponseData(PathEndPoint.GET_EDIT_CARD.url + activeMenu, cookies);
        formParams = HtmlToObject.fetchCardInfoFromHtmlResponseWithJsoup(ApiResponse.getResponseData(PathEndPoint.GET_LIST_MENU.url,cookies), activeMenu);
        menuTags.add(1);
        menuTags.add(2);
        formParams.put("menu[tags][]",menuTags);
        formParams.put("menu[withActivityPeriod]",1);
        formParams.put("menu[activityPeriod][type]","BASIC");
        formParams.put("productsToClone:",new ArrayList<>());
        formParams.put("menu[_token]", HtmlToObject.
                fetchTokenFoodFromHtmlResponse(response,
                        "**.findAll {it.@name=='menu[_token]'}.@value"));

        response = PosRequestDef.post(PathEndPoint.GET_EDIT_ACTIVE_CARD.url + activeMenu,headers,formParams,cookies, TabestoApi.TABESTO_BACK);

    }
}

