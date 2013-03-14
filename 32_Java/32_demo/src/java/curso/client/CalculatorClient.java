package curso.client;

/**
 * WebServiceClient
 * @author EM
 */
public class CalculatorClient {
    public static void main(String[] args) {
        CalculatorWebService_Service webService = new CalculatorWebService_Service();
        CalculatorWebService calculator = webService.getCalculatorWebServicePort();

        String webServiceMessage = calculator.hello("JOtaele");

        System.out.println("Received: " + webServiceMessage);
    }
}
