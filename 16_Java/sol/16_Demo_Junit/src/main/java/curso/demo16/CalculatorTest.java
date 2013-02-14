package curso.demo16;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setA(3);
        calc.setB(5);
        calc.add();

        if (calc.getRes() == 8) {
            System.out.println("1 OK");
        } else {
            System.out.println("1 ERROR");
        }
    }


}
