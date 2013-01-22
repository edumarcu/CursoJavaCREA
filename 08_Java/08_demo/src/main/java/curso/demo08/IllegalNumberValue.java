package curso.demo08;

/**
 * Excepcion para valores ilegales
 * @author EM
 */
public class IllegalNumberValue extends Exception {
    
    private Number value;

    public IllegalNumberValue(String message, Number value) {
        super(message);
        this.value = value;
    }
    
    public IllegalNumberValue(String message, Number value, Throwable cause) {
        super(message, cause);
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + ". Valor: " + this.value;
    }
}
