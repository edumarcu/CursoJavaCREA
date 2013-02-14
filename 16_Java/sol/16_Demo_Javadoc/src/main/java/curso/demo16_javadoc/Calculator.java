package curso.demo16_javadoc;

/**
 * A class that performs simple calculations.
 *
 * @author Víctor Jiménez Cerrada
 * @author Foolanito Stuffer
 *
 * @version 1.1
 * @since 1.0
 */
public class Calculator {

    private int a,b,res;

    // Operations

    public void add(){
        res = a + b;
    }

    public void del(){
        res = a - b;
    }

    public void mul(){
        res = a * b;
    }

    /**
     * Divides a by b.
     *
     * a and b must be loaded before execution.
     * Result of operation can be retrieved with {@link Calculator#getRes()}.
     * <pre>
     *  Calculator calc = new Calculator();
     *  calc.setA(6);
     *  calc.setB(2);
     *  System.out.prinln(calc.getRes()); // Outputs 3
     * </pre>
     *
     * @throws java.lang.ArithmeticException If property b is set to 0, causing
     *  a division by zero exception.
     *
     * @see Calculator#setA(int)
     * @see Calculator#setB(int)
     * @see Calculator#getRes()
     *
     */
    public void div(){
        res = a / b;
    }

    // Getters and Setters

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    /**
     * Sets the value for the second operator.
     *
     * If this value is zero, the {@link Calculator#div()} method will raise
     * an Exception.
     *
     * @param b The new value for the second operator.
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     *
     * @return The result of the last operation.
     */
    public int getRes() {
        return res;
    }
}
