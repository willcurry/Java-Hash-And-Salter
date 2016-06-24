import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashAndSaltTests {
    @Test
    public void returnsString() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        hashAndSalter.salt();
    }

    @Test
    public void checkPasswordFunction() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        hashAndSalter.enteredPassword("test");
    }

}
