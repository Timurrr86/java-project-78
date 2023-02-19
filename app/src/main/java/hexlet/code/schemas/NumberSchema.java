package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
            addChecking(x -> x instanceof Integer);
    }

    public void required() {
        setRequired(true);
    }

    public NumberSchema positive() {
        addChecking(x -> (int) x > 0);
        return this;
    }

    public void range(int lowRange, int hiRange) {
        addChecking(x -> (int) x >= lowRange && (int) x <= hiRange);
    }

}
