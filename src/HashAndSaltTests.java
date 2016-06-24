import com.sun.codemodel.internal.ClassType;
import com.sun.tools.classfile.Type;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class HashAndSaltTests {

    public static String hash(String pw) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.reset();
        m.update(pw.getBytes());
        BigInteger bigInt = new BigInteger(1, m.digest());
        String hashtext = bigInt.toString(16);

        while(hashtext.length() < 32 ){
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    @Test
    public void checkPasswordFunction() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        assertEquals("".getClass(), hashAndSalter.enteredPassword("test").getClass());
    }

    @Test
    public void checkSalt() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        assertEquals(true, hashAndSalter.salt().contains("salted"));
    }

    @Test
    public void checkHash() {
        HashAndSalter hashAndSalter = new HashAndSalter();
        assertEquals(hash("test"), hashAndSalter.hash("test"));
    }
}

