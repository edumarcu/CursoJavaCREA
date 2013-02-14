package curso.demo19_crypto;

import javax.xml.bind.DatatypeConverter;

public class Demo01_Base64 {

    public static void main(String[] args) {

        byte[] val = "Hola a todos".getBytes();
        String base64 = DatatypeConverter.printBase64Binary(val);

        System.out.println("BASE64: " + base64);

        byte[] parsedval = DatatypeConverter.parseBase64Binary(base64);
        String parsedString = new String(parsedval);

        System.out.println("Parsed: " + parsedString);
    }
}
