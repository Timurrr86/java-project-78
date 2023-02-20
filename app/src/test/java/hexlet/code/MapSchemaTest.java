package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {

    @Test
    public void mapTestRequired() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        Assertions.assertTrue(schema.isValid(null)); // true

        schema.required();

        Assertions.assertFalse(schema.isValid(null)); // false
        Assertions.assertTrue(schema.isValid(new HashMap())); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Assertions.assertTrue(schema.isValid(data)); // true

        schema.sizeof(2);

        Assertions.assertFalse(schema.isValid(data));  // false
        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data)); // true
    }
}
