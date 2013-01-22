/*
 *                            Cuadrado --- Circulo
 *  Figura --- Rectangulo --- Triangulo
 * 
 */

package curso.ejercicio1;

public class App {
    public static void main(String[] args) {
        
        /* --- Intro --- */
        System.out.println("Figuras");
        System.out.println("#######");
        System.out.println("Alumno: Eduardo Marcuello Portoles " +
                "<edumarcu@gmail.com>");
        System.out.println();
        
        /* --- Rectangulo --- */
        int base = 10;
        int altura = 5;
        
        Figura r = new Rectangulo(base, altura);
        
        System.out.println(r);
        r.print();
        
        /* --- Cuadrado --- */
        int lado = 5;
        Figura c = new Cuadrado(lado);
 
        System.out.println(c);
        c.print();
                
        /* --- Triangulo --- */
        int ancho = 3;
        int alto = 4;
        
        Figura t = new Triangulo(ancho, alto);
        Triangulo t1 = new Triangulo();
                
        System.out.println(t);
        t.print();
     
        /* --- Circulo --- */
        int radio = 10;
        
        Figura cir = new Circulo(radio);
        
        System.out.println(cir);
        cir.print();
        
        /* --- Arrays --- */
        Figura v[] = {r, c, t, cir};
        System.out.println("HashCodes");
        for (Figura f:v) {
            System.out.println(f);
            System.out.println("Hash: " + f.hashCode());
            System.out.println();
        }
    }
}
