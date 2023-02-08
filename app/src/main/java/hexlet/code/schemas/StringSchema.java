package hexlet.code.schemas;

public class StringSchema {
    private boolean isRequired = false;
    private String containsString;
    private int minLength;

    public void required() {
        isRequired = true;
    }

    public StringSchema minLength(int count) {
        minLength = count;
        return this;
    }

    public StringSchema contains(String string) {
        containsString = string;
        return this;
    }

    public boolean isValid(Object obj) {
        if (minLength != 0) {
            return obj.toString().length() > minLength;
        }
        if (containsString != null) {
            return obj.toString().contains(containsString);
        }
        if (!isRequired) {
            return (obj instanceof String) || (obj == null);
        } else {
            return ((obj instanceof String) && (!((String) obj).isEmpty()));
        }

    }
}
