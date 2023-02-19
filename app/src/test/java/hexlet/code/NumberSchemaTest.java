package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {

    @Test
    public void numberTestRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        Assertions.assertTrue(schema.isValid(null)); // true

        schema.required();

        Assertions.assertFalse(schema.isValid(null)); // false;
//Assertions.assertTrue(schema.positive().isValid(null)); // true
        Assertions.assertFalse(schema.isValid(null)); // false
        Assertions.assertTrue(schema.positive().isValid(10)); // true
        Assertions.assertFalse(schema.isValid("5")); // false
        Assertions.assertFalse(schema.positive().isValid(-10)); // false
//  Ноль - не положительное число
        Assertions.assertFalse(schema.positive().isValid(0)); // false
    }

    @Test
    public void numberTestRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.range(5, 10);

        Assertions.assertTrue(schema.isValid(5)); // true
        Assertions.assertTrue(schema.isValid(10)); // true
        Assertions.assertFalse(schema.isValid(4)); // false
        Assertions.assertFalse(schema.isValid(11)); // false
    }
}
