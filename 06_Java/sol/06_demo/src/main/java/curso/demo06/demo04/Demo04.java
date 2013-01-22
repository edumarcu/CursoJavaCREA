package curso.demo06.demo04;

import java.util.Arrays;

public class Demo04 {

    public static void main(String[] args) throws CloneNotSupportedException {

        Coche c1 = new Coche();
        c1.bastidor = "abcde";
        c1.matricula = "0000 AA";
        c1.modelo = "Delorean";

        Coche c2 = new Coche();
        c2.bastidor = "abcde";
        c2.matricula = "0000 FF";
        c2.modelo = "Delorean";

        if (c1 instanceof Object) {
            System.out.println("c es un Objeto.");
        }

//        printString((String) c1); -> MAL
        printString(c1.toString());
        printString("" + c1);

        if (c1 == c2){
            System.out.println("c1 y c2 son la misma instancia.");
        } else {
            System.out.println("c1 y c2 son diferente instancia.");
        }

        if (c1.equals(c2)){
            System.out.println("c1 y c2 son el mismo coche.");
        } else {
            System.out.println("c1 y c2 son diferentes coches.");
        }

        //
        System.out.println("Copiando..");
        Coche c3 = (Coche) c1.clone();

        c3.matricula = "0001 BB";
        printString("" + c1);
        printString("" + c3);
     }

    public static void printString(String str) {
        System.out.println("c: " + str);
    }

}

class Coche /* extends Object */ implements Cloneable {

    public String bastidor;

    public String matricula;

    public String modelo;

    @Override
    public String toString() {
        return "Coche " + bastidor + " matrícula " + matricula + " modelo " + modelo;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coche)) {
            return false;
        }

        if (obj == null) {
            return false;
        }

        // Campos propios
        Coche coche = (Coche) obj;
        if (bastidor == null || coche.bastidor == null) {
            return false;
        }
        if (!bastidor.equals(coche.bastidor)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return ( "coche:" + bastidor ).hashCode();
    }


/*
    @Override
    public Object clone() {
        Coche c = new Coche();
        c.bastidor = this.bastidor;
        c.matricula = this.matricula;
        c.modelo = this.modelo;
        return c;
    }
*/

    @Override
    public Coche clone() throws CloneNotSupportedException {
        return (Coche) super.clone();
    }


}