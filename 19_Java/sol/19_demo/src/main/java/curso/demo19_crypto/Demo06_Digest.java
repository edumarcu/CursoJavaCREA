package curso.demo19_crypto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;

public class Demo06_Digest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Java");

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        printHex(md5.digest("Hola".getBytes()));
        printHex(md5.digest(new byte[]{ 33 }));

        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        printHex(sha.digest("Hola".getBytes()));
        printHex(sha.digest(new byte[]{ 33 }));

        System.out.println("Apache");
        System.out.println(DigestUtils.md5Hex("Hola"));
        System.out.println(DigestUtils.md5Hex(new byte[]{ 33 }));
        System.out.println(DigestUtils.sha1Hex("Hola"));
        System.out.println(DigestUtils.sha1Hex(new byte[]{ 33 }));
    }

    public static void printHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        String hex = String.format("%0" + (bytes.length << 1) + "X", bi);
        System.out.println(hex);
    }

}
