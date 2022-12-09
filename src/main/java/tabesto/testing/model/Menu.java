package tabesto.testing.model;

import java.util.List;

public class Menu {
    public List<Category> category;
    public String sellerName;
    public List<Product> product;
    public List<Option> options;
    public List<MealSequence> mealSequences;
    public List<EventSuggestion> eventSuggestion;
    public List<MealSeq> mealSeqList;

    public List<Category> getCategory() {
        return category;
    }

}
