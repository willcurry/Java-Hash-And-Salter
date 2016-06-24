import java.math.BigInteger;
import java.security.DigestException;
import java.security.MessageDigest;
import java.util.Random;
import java.security.*;

public class HashAndSalter {
    public static String hash(String pw) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.reset();
        m.update(pw.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);

        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }

    public static String salt() {
        String[] characters = {"dj3", "jeii2", "2374", "xn32974", "3883", "duui3", "ccc", "lkoi", "2923", "mcnwiud", "1sd1f"};
        String saltedText = "";
        for (int i = 0; i < 10; i++) {
            int index = randomPick(characters);
            saltedText += characters[index];
        }
        return saltedText;
    }


    public static int randomPick(String[] characters) {
        Random rand = new Random();
        int index = rand.nextInt(characters.length);
        return index;
    }

    public static String enteredPassword(String pw) {
        String password = pw;
        String hashSaltedPassword = hash(pw + salt());
        return hashSaltedPassword;
    }
}
