package curso.demo32.client;

public class CalculatorClient {
    public static void main(String[] args) {
        CalculatorWebService_Service service = new CalculatorWebService_Service();
        CalculatorWebService calculator = service.getCalculatorWebServicePort();

        String message = calculator.hello("Class");

        System.out.println("Received: " + message);
    }
}
