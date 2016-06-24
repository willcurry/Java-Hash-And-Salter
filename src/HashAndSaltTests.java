import com.sun.codemodel.internal.ClassType;
import com.sun.tools.classfile.Type;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class HashAndSaltTests {

    @Test
    public void checkPasswordFunction() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        assertEquals(String.class, hashAndSalter.enteredPassword("test").getClass());
    }

    @Test
    public void checkSalt() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        assertEquals(true, hashAndSalter.salt().contains("salted"));
    }

    @Test
    public void checkHash() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        assertEquals("098f6bcd4621d373cade4e832627b4f6", hashAndSalter.hash("test"));
    }
}

