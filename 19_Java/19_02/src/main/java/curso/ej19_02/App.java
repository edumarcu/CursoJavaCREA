package curso.ej19_02;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Decoding MD2, SHA-1
 * @author EM
 */
public class App {
    public static void main( String[] args ) throws NoSuchAlgorithmException {
        String md5String = "a5f3c6a11b03839d46af9fb43c97c188";
        System.out.println("MD5: " + md5String);

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] b = md5.digest(md5String.getBytes());
        System.out.println("Dec:" + b[0]);

        String shaString = "06576556d1ad802f247cad11ae748be47b70cd9c";
        System.out.println("SHA-1: " + shaString);

        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] b1 = sha.digest(shaString.getBytes());
        System.out.println("Dec:" + b1[0]);
    }
}
