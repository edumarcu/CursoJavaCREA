package curso.demo08;

public class IllegalNumberValue extends Exception {

    private Number value;

    public IllegalNumberValue(String message, Number value) {
        super(message, null);
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
        return super.getMessage() + " Valor: " + this.value;
    }
}
