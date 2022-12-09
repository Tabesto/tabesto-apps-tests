package tabesto.testing.data.apiData;


import tabesto.testing.enums.TabestoApi;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static tabesto.testing.data.apiData.ResponseSpecificationBuilder.getResponseSpec;

public class PosRequestDef extends RequestSpecificationBuilder {


    public static Response post(String endPoint, Headers headers,
                                HashMap<String,Object> formParams, Cookies cookies, TabestoApi env){

        return given(getRequestSpec(env)).
                headers(headers).
                formParams(formParams).
                cookies(cookies).

                when().

                post(endPoint).

                then().spec(getResponseSpec()).
                extract().response();
    }

    public static Response post(String endPoint, Headers headers
            , Cookies cookies, HashMap<String,Object> body, TabestoApi env){

        return given(getRequestSpec(env)).
                headers(headers)
                .body(body).
                cookies(cookies).
                when().
                post(endPoint).
                then().spec(getResponseSpec()).
                extract().response();
    }
}
