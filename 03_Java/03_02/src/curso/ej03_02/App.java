
package curso.ej03_02;

import java.math.BigDecimal;


public class App {

    public static void main(String[] args) {
        
        //------------ enteros
        System.out.println();
        
        byte b;
        short s;
        int i;
        long l;
        
        b = (byte) 40000;
        System.out.println("b:" + b);
        
        s = (short) 40000;
        System.out.println("s:" + s);
        
        i = 40000;
        System.out.println("i:" + i);
        
        l = 40000;
        System.out.println("l:" + l);
               
        b = (byte) 3000000000l;
        System.out.println("b:" + b);
        
        s = (short) 3000000000l;
        System.out.println("s:" + s);
        
        i = (int) 3000000000l;
        System.out.println("i:" + i);
        
        l = (long) 3000000000l;
        System.out.println("l:" + l);
        
        
        //------ float
        System.out.println();
        
        float r1,r2;
        
        r1 = 4.95f * 100f;
        r2 = 495f;
        
        System.out.printf("r1 d= %.1f\n", 4.95);
        System.out.printf("r1 f= %.1f\n", 4.95f);
        
        System.out.println("r1= " + r1);
        System.out.println("r2= " + r2);
        
     
        System.out.println((r1==r2?"Igual":"No igual"));
        
        BigDecimal bd = new BigDecimal("4.95");
        System.out.println("bd= " + bd);
        
        //------- bool
        System.out.println();
        
        boolean bool = true;
        int i2 = 1;
        
       // i2 = (int) bool;
        //bool = (boolean) i2;
        
        
       /* System.out.println("bool= " + bool);
        System.out.println("i= " + i2);*/
        
        //-------- char
        System.out.println();
        
        char c = 'A';
        int i3 = 66;
        
        System.out.println("char= " + c);
        System.out.println("i= " + i3);
        
        c = (char) i3;
        
        System.out.println("char= " + c);
        System.out.println("i= " + i3);
        
        c = 'A';
        i3 = (int) c;
        
        System.out.println("char= " + c);
        System.out.println("i= " + i3);
        
        //---------- literals
        System.out.println();
        System.out.println("Int 35= " + 35);
        System.out.println("Hex OxFF= " + 0xFF);
        System.out.println("Oct O35= " + 035);
        System.out.println("Bin 0b100= " + 0b100);
        
        System.out.println();
        System.out.println("Dou 4.95d= " + 4.95d);
        System.out.println("Dou 4.95d= " + 4.95);
        System.out.println("Flo 4.95f= " + 4.95f);
        System.out.println("Exp 495e-2= " + 495e-2);
        
        System.out.println();
        System.out.println("'A'= " + 'A');
        System.out.println("'\\t'= " + '\t' + '.');
        System.out.println("\\u00F1 = " + '\u00F1');

             
        
    }
}
