package curso.demo19_crypto;

import javax.xml.bind.DatatypeConverter;

public class Demo05_Base64Truncated {

    public static void main(String[] args) {

        byte[] val = "Hola a todos".getBytes();
        String base64 = DatatypeConverter.printBase64Binary(val);
        System.out.println("BASE64: " + base64);
        byte[] parsedval = DatatypeConverter.parseBase64Binary(base64);
        String parsedString = new String(parsedval);
        System.out.println("Parsed: " + parsedString);

        System.out.println();
        System.out.println("Codifico Byte a byte:");
        StringBuilder sb = new StringBuilder();
        for (byte b : val) {
            base64 = DatatypeConverter.printBase64Binary(new byte[]{b});
            sb.append(base64);
        }
        base64 = sb.toString();
        System.out.println("BASE64: " + base64);
        parsedval = DatatypeConverter.parseBase64Binary(base64);
        System.out.println("Parsed: " + new String(parsedval));
    }
}
