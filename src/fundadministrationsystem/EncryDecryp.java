package fundadministrationsystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryDecryp {

    public static String encrypt(String passWord) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();

        byte[] buf = passWord.getBytes();
        md.update(buf);
        byte[] digest = md.digest();

        String hexStr = "";

        for (int i = 0; i < digest.length; i++) {
            hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);

        }
        return hexStr;







    }
}