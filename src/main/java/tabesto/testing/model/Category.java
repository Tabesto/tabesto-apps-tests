package tabesto.testing.model;


import tabesto.testing.enums.FileJsonPath;
import tabesto.testing.utils.transformer.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Category {
    private String name;
    private int weight;
    private int sectionId;
    private String label;
    private String menuTypes;
    private String location;
    public List<String> products;
    public List<MealSeq> mealSeqList = null;

    public Category(){}

    public Category(String name,Boolean searchOnCategoryJson) throws IOException, InterruptedException {
        if (searchOnCategoryJson) {
            Category[] categories = JsonSerializer.toObject(FileJsonPath.CATEGORY.url, Category[].class);
            for (Category category : categories) {
                if (Objects.equals(category.getName(), name)) {
                    this.sectionId = category.getSectionId();
                }
            }
        } else {
            this.name = name;
        }
    }
    public int getSectionId() {
        return sectionId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getMenuTypes() {
        return menuTypes;
    }

    public String getLabel() {
        return label;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
