package curso.ej19_02;

import org.apache.commons.codec.digest.DigestUtils;

public class App {

    public static void main(String[] args) {
//        // Generation
//        System.out.println(DigestUtils.md5Hex(new byte[]{75}));
//        System.out.println(DigestUtils.sha1Hex(new byte[]{82}));

        String md5 = "a5f3c6a11b03839d46af9fb43c97c188";
        String sha = "06576556d1ad802f247cad11ae748be47b70cd9c";

        byte b[] = {0};
        for (byte i = 0; i < 128; i++) {
            b[0] = i;
            String md5temp = DigestUtils.md5Hex(b);
            if (md5temp.equalsIgnoreCase(md5)) {
                System.out.println("El número md5 es: " + i);
                break;
            }
        }

        b[0] = 0;
        for (byte i = 0; i < 128; i++) {
            b[0] = i;
            String shatemp = DigestUtils.sha1Hex(b);
            if (shatemp.equalsIgnoreCase(sha)) {
                System.out.println("El número sha es: " + i);
                break;
            }
        }
    }
}
