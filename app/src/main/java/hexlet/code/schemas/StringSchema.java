package hexlet.code.schemas;

public class StringSchema extends BaseSchema{
    public StringSchema() {
        addChecking(x -> x instanceof String || x == null);
    }

    public void required() {
        setRequired(true);
        addChecking(x -> x instanceof String && !x.toString().isEmpty());
    }

    public StringSchema minLength(int minLength) {
        addChecking(x -> x.toString().length() > minLength);
        return this;
    }

    public StringSchema contains(String string) {
        addChecking(x -> x.toString().contains(string));
        return this;
    }

}
