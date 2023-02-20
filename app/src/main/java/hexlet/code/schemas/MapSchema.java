package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema() {
        addChecking(x -> x instanceof Map<?, ?>);
    }

    public void required() {
        setRequired(true);
    }

    public void sizeof(int count) {
        addChecking(x -> ((Map<?, ?>) x).size() == count);
    }
}
