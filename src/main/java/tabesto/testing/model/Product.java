package tabesto.testing.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tabesto.testing.enums.ProductType;
import tabesto.testing.enums.FileJsonPath;
import tabesto.testing.utils.transformer.JsonSerializer;

import java.io.IOException;
import java.util.Objects;

public class Product {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String choicesCount;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String menuLabel;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String name;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String description;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String referenceId;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String miniature;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String mapped;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String pp;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String label;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String sp;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String isCustomProduct;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String menuOnly;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String sections;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String details;


    public  Product(){}

    public Product(String name, ProductType productType) throws IOException {

        Product[] products;
        switch (productType){
            case CUSTOMPRODUCT->{
                products = JsonSerializer.toObject(FileJsonPath.CUSTOM_PRODUCT.url, Product[].class);
            }
            case PRODUCT ->{
                products = JsonSerializer.toObject(FileJsonPath.PRODUCTS.url, Product[].class);
            }
            default -> throw new IllegalStateException("Unexpected value: " + productType);
        }

        for (Product product :products) {
            if(Objects.equals(product.getName(), name)){
                this.referenceId = product.getReferenceId();
                this.name = name;
            }

        }
    }

    public Product(String name,String description,String details,String price){
        this.name = name;
        this.description = description;
        this.pp = price;
        this.details = details;

    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getMiniature() {
        return miniature;
    }

    public void setMiniature(String miniature) {
        this.miniature = miniature;
    }

    public String getMapped() {
        return mapped;
    }

    public void setMapped(String mapped) {
        this.mapped = mapped;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getIsCustomProduct() {
        return isCustomProduct;
    }

    public void setIsCustomProduct(String isCustomProduct) {
        this.isCustomProduct = isCustomProduct;
    }

    public String getMenuOnly() {
        return menuOnly;
    }

    public void setMenuOnly(String menuOnly) {
        this.menuOnly = menuOnly;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public String getChoicesCount() {
        return choicesCount;
    }

    public void setChoicesCount(String choicesCount) {
        this.choicesCount = choicesCount;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }


}
