package curso.demo08;

public class App {
    public static void main( String[] args ) throws ApplicationException {
        double number = -1;

        try {
            double result = raiz(number);
            System.out.print(result);
        } catch (IllegalNumberValue e) {
            throw new ApplicationException("Error de Número en la applicación.", e);
        } catch (ApplicationException e) {
            throw new ApplicationException("Error de Aplicación en la applicación.", e);
        } catch (Exception e) {
            throw new ApplicationException("Error Genérico en la applicación.", e);
        } finally {
            System.out.println("Fin de la ejecución");
        }
    }

    // Exception
    public static double raiz(double number) throws Exception {
        try {
            if (true) {
                throw new ApplicationException("Este hardware no soporta esta operación.", null);
            }
            if (number < 0) {
                throw new IllegalNumberValue("Number es menor que 0.", number);
            }
            return Math.sqrt(number);
        } finally {
            System.out.println("Termino de ejecutar raiz");
        }
    }

    /*
    //Asertos
    public static double raiz(double number) {
        assert (number >= 0);
        return Math.sqrt(number);
    }
    */
}
