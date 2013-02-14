package curso.demo16_javadoc;

public class App {
    public static void main( String[] args ) {
        Calculator calc = new Calculator();
        calc.setA(6);
        calc.setB(3);

        calc.div();
    }
}
