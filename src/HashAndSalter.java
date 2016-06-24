import java.math.BigInteger;
import java.security.DigestException;
import java.security.MessageDigest;
import java.util.Random;
import java.security.*;

public class HashAndSalter {

    public static String hash(String pw) {
        MessageDigest m = null;
        String hashtext = null;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(pw.getBytes());
            BigInteger bigInt = new BigInteger(1, m.digest());
            hashtext = bigInt.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
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
        saltedText += "salted";
        return saltedText;
    }


    public static int randomPick(String[] characters) {
        Random rand = new Random();
        return rand.nextInt(characters.length);
    }

    public static String enteredPassword(String pw) {
        return hash(pw + salt());
    }
}
