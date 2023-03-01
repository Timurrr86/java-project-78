package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public StringSchema() {
        addChecking(x -> x instanceof String || x == null);
    }

    public final StringSchema required() {
        setRequired(true);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        addChecking(x -> x.toString().length() > minLength);
        return this;
    }

    public final StringSchema contains(String string) {
        addChecking(x -> x.toString().contains(string));
        return this;
    }

}
