package tabesto.testing.data.apiData;

import tabesto.testing.config.Settings;
import tabesto.testing.enums.TabestoApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {

    public static RequestSpecification getRequestSpec(TabestoApi env){
        String uri;
        switch (env){
            case OCA -> { uri = Settings.getInstance().getOcaUrl();}
            case TABESTO_BACK -> {uri = Settings.getInstance().getBaseUrl();}
            default -> throw new IllegalStateException("Unexpected value: " + env);
        }
        return new io.restassured.builder.RequestSpecBuilder().
                setBaseUri(uri).
                log(LogDetail.ALL).build();

    }

}

