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

    public void shape(Map<String, BaseSchema> map) {
        addChecking(x -> {
            for (Map.Entry<String, BaseSchema> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!(entry.getValue().isValid(((Map<?, ?>) x).getOrDefault(key, null)))) {
                    return false;
                }
            }
            return true;
        });
    }
}
