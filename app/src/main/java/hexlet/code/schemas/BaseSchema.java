package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private final List<Predicate<Object>> checkings = new ArrayList<>();
    private boolean isRequired = false;

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public void addChecking(Predicate<Object> checking) {
        checkings.add(checking);
    }

    public boolean isValid(Object object) {
        if (object == null) {
            return !isRequired;
        }
        for (Predicate<Object> predicate : checkings) {
            if (!predicate.test(object)) {
                return false;
            }
        }
        return true;
    }

}
