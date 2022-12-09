package tabesto.testing.utils.transformer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import tabesto.testing.utils.HelpersMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HtmlToObject {
    static HelpersMethod utils = new HelpersMethod();

    public static void fetchAllProductsFromFoodList(WebDriver driver){
        String path = "src/test/resources/allProducts.json";

        String str = driver.getPageSource();
        Document document = Jsoup.parse(str);
        Element table = document.select("table").get(0);
        Elements rows = table.select("tr");

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode productObject = mapper.createObjectNode();
        ArrayNode allProducts = mapper.createArrayNode();

        for (Element row : rows) {
            Elements td = row.getAllElements();
            if (!row.attr("id").equals("")) {
                productObject.put("id", row.attr("id"));
                productObject.put("name", td.get(1).text());
                allProducts.add(productObject);
            }
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(String.valueOf(allProducts));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static HashMap<String, Object> fetchCardInfoFromHtmlResponseWithJsoup(Response response, String activeMenu){
        Document doc = Jsoup.parse(response.asString());
        List<String> payload = Arrays.asList("menu[label]", "menu[description]","menu[activityPeriod][startTime][hour]"
                ,"menu[activityPeriod][startTime][minute]","menu[activityPeriod][duration][hour]","menu[activityPeriod][duration][minute]");

        List<String> params = new ArrayList<>();
        HashMap<String, Object> paramsCard = new HashMap<>();
        String breakCondition = "";
        for (Element tableOfCard : doc.select("#dataTables")) {
            for (Element row : tableOfCard.select("tr")) {
                for (Element cardRows : row.select("td")) {
                    Elements links = cardRows.select("a[href]");
                    for (Element link : links) {
                        if (link.attr("href").contains(activeMenu) && !link.text().equals("")) {
                            params.add(link.text());
                            breakCondition = link.text();
                        }
                    }
                    if (breakCondition.contains("Heure")){
                        List<String> activityDurationOfCard = HelpersMethod.matchStringWithInputRegex("(\\d+):(\\d+).*?(\\d+)H:(\\d+)M",params.get(params.size()-1));
                        params.remove(params.size()-1);
                        params.addAll(activityDurationOfCard);
                        for(int i = 0; i < payload.size(); i++) paramsCard.put(payload.get(i), params.get(i));
                        break;
                    }
                }
            }
        }

        return paramsCard;
    }
    public static String fetchTokenFoodFromHtmlResponse(Response response,String pattern){
        List<String> foodToken = response.htmlPath().getList(pattern);
        if (foodToken.size() != 0) {
            return foodToken.get(0);
        }else {
            throw new RuntimeException("NONE FOOD TOKEN FOUND");
        }
    }
}

