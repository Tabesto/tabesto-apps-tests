package tabesto.testing.enums;

public enum FileJsonPath {
    CATEGORY("src/test/resources/Category.json"),
    CUSTOM_PRODUCT("src/test/resources/customProducts.json"),
    PRODUCTS("src/test/resources/allProducts.json");


    public final String url;

    FileJsonPath(String url) {
        this.url =  url;
    }

}
