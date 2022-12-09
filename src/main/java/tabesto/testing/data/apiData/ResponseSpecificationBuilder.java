package tabesto.testing.data.apiData;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;


public class ResponseSpecificationBuilder {

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                log(LogDetail.METHOD).
                log(LogDetail.URI).
                log(LogDetail.PARAMS).
                log(LogDetail.STATUS).
                log(LogDetail.HEADERS).
                log(LogDetail.COOKIES).
                build();
    }
}

