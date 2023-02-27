package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public final void required() {
        addChecking(x -> x instanceof Map<?, ?>);
        setRequired(true);
    }

    public final void sizeof(int count) {
        addChecking(x -> ((Map<?, ?>) x).size() == count);
    }

    public final void shape(Map<String, BaseSchema> map) {
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
