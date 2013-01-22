package curso.ejercicio1;

public class Figuras {

    public static void main(String[] args) {
        System.out.println("Figuras");
        System.out.println("#######");

        System.out.println("Alumno: Víctor Jiménez Cerrada <vjimenez@rootnode.es>");

        Figura[] figuras = {
            new Rectangulo(10, 5),
            new Cuadrado(5),
            new Triangulo(3, 4),
            new Circulo(10)
        };

        for (Figura figura : figuras) {
            pintaFigura(figura);
        }
    }

    public static void pintaFigura(Figura figura) {
        System.out.println("");
        System.out.println(figura);
        System.out.println("Área: " + figura.getArea());
        figura.pinta(System.out);
    }

}
