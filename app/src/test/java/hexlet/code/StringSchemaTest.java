package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {

    @Test
    public void schemaTestRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        Assertions.assertTrue(schema.isValid("")); // true
// Пока на вызван метод required(), null считается валидным
        Assertions.assertTrue(schema.isValid(null)); // true

        schema.required();

        Assertions.assertTrue(schema.isValid("what does the fox say")); // true
        Assertions.assertTrue(schema.isValid("hexlet")); // true
        Assertions.assertFalse(schema.isValid(null)); // false
        Assertions.assertFalse(schema.isValid(5)); // false
        Assertions.assertFalse(schema.isValid("")); // false
    }

    @Test
    public void schemaTestContains() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        Assertions.assertTrue(schema.contains("wh").isValid("what does the fox say")); // true
        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say")); // true
        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say")); // false

        Assertions.assertFalse(schema.isValid("what does the fox say")); // false
    }

    @Test
    public void schemaTestMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        Assertions.assertTrue(schema.minLength(5).isValid("what does the fox say"));
        Assertions.assertFalse(schema.minLength(5).isValid("what"));
    }
}
