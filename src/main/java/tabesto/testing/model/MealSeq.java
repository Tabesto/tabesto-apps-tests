package tabesto.testing.model;

import java.util.List;

public class MealSeq {
    public List<String> getChoice_id(int choice) {
        switch (choice) {
            case (1):
                return choice_id_1;
            case (2):
                return choice_id_2;
            case (3):
                return choice_id_3;
            default:
                return null;
        }
    }



    public String name;
    public List<String> choice_id_1 = null;
    public List<String> choice_id_2 = null;
    public List<String> choice_id_3 = null;
    public int choicesNumber;
}
