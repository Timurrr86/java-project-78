package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        addChecking(x -> x instanceof Integer);
    }

    public final void required() {
        setRequired(true);
    }

    public final NumberSchema positive() {
        addChecking(x -> (int) x > 0);
        return this;
    }

    public final void range(int lowRange, int hiRange) {
        addChecking(x -> (int) x >= lowRange && (int) x <= hiRange);
    }

}
