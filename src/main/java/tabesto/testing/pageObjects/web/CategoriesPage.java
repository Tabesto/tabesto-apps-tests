package tabesto.testing.pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByAll;
import tabesto.testing.drivers.DriverManagerWeb.ThreadLocalWebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriesPage extends BaseWebPage {
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement createCategoryButton;
    @FindBy(xpath = "//span[normalize-space()='Aucun produit sélectionné']")
    private WebElement selectCart;
    @FindBy(xpath = "//*[@id='category_isForMealSequences_0']//parent::*")
    private WebElement formulaSeq;
    @FindBy(xpath = "//*[@id='category_isForMealSequences_1']//parent::*")
    private WebElement noFormulaSeq;
    @FindBy(xpath = "//*[@id='category_type_1']//parent::*")
    private WebElement foodTypeCategory;
    @FindBy(xpath = "//*[@id='category_type_2']//parent::*")
    private WebElement drinkTypeCategory;
    @FindBy(xpath = "//input[@id='category_name']")
    private WebElement nameCategoryInput;
    @FindBy(xpath ="//span[contains(text(),'ic_beer_bottle')]")
    private WebElement iconCategory;
    @FindBy(xpath ="//span[normalize-space()='Direct']")
    private WebElement directSelect;
    @FindBy(xpath = "//a[normalize-space()='SAUVEGARDER']")
    private WebElement saveButton;
    @FindBy(css = "tbody tr")
    private List<WebElement> allCategories;
    @FindBy(xpath = "//a[normalize-space()='Confirmer la suppression']")
    private WebElement validateDeleteButton;
    @FindBy(xpath = "//a[@href='#drink']")
    private WebElement tabDrink;


    public void setNameCategoryInput(String name){
        nameCategoryInput.sendKeys(name);
    }
    public void setFoodAsTypeCategory(){
        foodTypeCategory.click();
    }
    public void setDrinkAsTypeCategory(){
        drinkTypeCategory.click();
    }
    public void setForFormulaSeq(){
        formulaSeq.click();
    }
    public void setNoformulaSeq() {  noFormulaSeq.click();}
    public void selectCart(String title){
        selectCart.click();
        ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.xpath("//span[normalize-space()='" + title + "']")).click();
        ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().findElement(By.xpath("//span[normalize-space()='" + title + "']")).click();
    }
    public  void createNewCategory(){
        createCategoryButton.click();
    }
    public void saveCategory() { saveButton.click();}

    public void deleteCategory(String categoryName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        allCategories.forEach(row -> {
            if (row.findElements(ByAll.tagName("td")).get(1).getText().equals(categoryName)) {
                row.findElements(ByAll.tagName("td")).get(4).findElement(By.tagName("a")).click();
            }
        });
    }

    public void validateDelete() {
        validateDeleteButton.click();
    }

    public List<String> getAllCategories() {
        return allCategories.stream().map(row -> row.findElements(ByAll.tagName("td")).get(1).getText()).collect(Collectors.toList());
    }

    public void clickOnTabDrink() {
        tabDrink.click();
    }
}
