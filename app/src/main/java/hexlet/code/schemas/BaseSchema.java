package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private final List<Predicate<Object>> checkings = new ArrayList<>();
    private boolean isRequired = false;

    public boolean isRequired() {
        return isRequired;
    }

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    public final void addChecking(Predicate<Object> checking) {
        checkings.add(checking);
    }

    public final boolean isValid(Object object) {
        if (object == null || object == "") {
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
