package curso.demo16;

/**
 * Test de Unidad
 * @author EM
 */
public class CalculadoraTest {

    public static void main( String[] args ) {
        Calculadora calc = new Calculadora();

        calc.setA(3);
        calc.setB(5);
        calc.add();

        if (calc.getRes() == 8) {
            System.out.println("1 OK");
        } else {
            System.out.println( "1 ERROR" );
        }
    }
}
