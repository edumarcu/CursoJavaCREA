package curso.demo04;

import static java.lang.System.out;

public class Demo07 {

    public static void main(String[] args) {
        System.out.println("Toma de Decisión");

        out.println("");
        out.println(" if, else if, else ");
        int a = 3;
        if (a > 2) {
            out.println("a > 2");
        }

        // ¡Ojo!
        a = 1;
        if (a > 2)
            out.println("a > 2"); // Sólo la 1ª Instucción
            out.println("afterif"); // Se ejecuta siempre

        a = 1;
        if (a > 2) {
            out.println("a > 2");
        } else {
            out.println("else a <= 2");
        }

        a = 1;
        if (a > 2) {
            out.println("a > 2");
        } else if (a == 2) {
            out.println("a == 2");
        } else {
            out.println("else a < 2");
        }

        out.println("");
        out.println(" Operador ternario ");
        String b = (a > 2) ? "a > 2" : " a <= 2";
        out.println(b);

        // Java > 1.7 ?
        // Point p = null;
        // p = p ?: new Point(3,5);
        // out.println("p = " + p);


        out.println("");
        out.println(" switch ");
        int day = 4;
        switch(day) {
            case 1:
                out.println("Lunes");
                break;
            case 2:
                out.println("Martes");
                break;
            case 3:
                out.println("Miércoles");
                break;
            case 4:
                out.println("Jueves");
                break;
            case 5:
                out.println("Viernes");
                break;
            case 6:
                out.println("Sábado");
                break;
            case 7:
                out.println("Domingo");
                break;
            default:
                out.println("No es un día de la semana");
                break;
        }
        switch(day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                out.println("Entre Semana");
                break;
            case 6:
            case 7:
                out.println("Fin de Semana");
                break;
            default:
                out.println("No es un día de la semana");
                break;
        }

        // Sólo java 7
        String foo = "YES";
        switch (foo) {
            case "YES":
                out.println("Sí");
                break;
            default:
                out.println("No");
        }
    }

}
