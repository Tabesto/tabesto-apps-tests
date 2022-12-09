package tabesto.testing.data.apiData;


import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import tabesto.testing.enums.TabestoApi;

import static io.restassured.RestAssured.given;
import static tabesto.testing.data.apiData.ResponseSpecificationBuilder.getResponseSpec;

public class GetRequestDef extends RequestSpecificationBuilder {

    public static Response get(String endPoint, Cookies cookies, TabestoApi env){
        return given(getRequestSpec(env)).
                cookies(cookies).
                when().
                get(endPoint).

                then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response get(String endPoint, Headers headers, Cookies cookies, TabestoApi env){

        return given(getRequestSpec(env))
                .headers(headers).cookies(cookies).
                when().
                get(endPoint).
                then().spec(getResponseSpec())
                .extract().response();
    }
}
