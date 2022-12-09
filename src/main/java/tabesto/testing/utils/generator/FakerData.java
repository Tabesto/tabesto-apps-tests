package tabesto.testing.utils.generator;


import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FakerData {
    public static String generateRandomNumber(int numberOfDigits){
        Faker faker = new Faker();
        return String.valueOf(faker.number().randomNumber(numberOfDigits,true));
    }
    public static String generateRandomUserName(){
        Faker faker = new Faker();
        return String.valueOf(faker.name().firstName());
    }
    public static String generateRandomFoodName(){
        Faker faker = new Faker();
        return String.valueOf(faker.food().dish());
    }
    public static String generateRandomOptionName(){
        Faker faker = new Faker();
        return String.valueOf(faker.food().dish());
    }

    public static List<WebElement> pickRandom(List<WebElement> list, int n) {
        Random random = new Random();
        return IntStream
                .generate(() -> random.nextInt(list.size()))
                .distinct()
                .limit(n)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}