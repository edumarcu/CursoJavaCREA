package curso.demo08;

/**
 * Excepciones, tratamiento errores
 * Assert solo para cuando quiera para la ejecucion, algo muy grave (o debug)
 * Objeto Exception tiene info de clase, linea codigo, etc.
 * @author EM
 */
public class App {
    public static void main(String[] args) throws ApplicationException {
        
        double number = -1;
       
        //System.out.println("Raiz de -1 " + raiz(number));
        
        
        // entrara en el tipo de Exception correcto, aunque throws Excption, 
        // que es la madre, aunqeu si ponemos el catch de la madre la 1ª solo
        // entrar en ella (aunque este compilador da error, pq es codigo inutil)
        try {
            double result = raiz(number);
            System.out.println(result);
        } catch (IllegalNumberValue e) {
            throw new ApplicationException("Error de Numero en la Aplicacion.", e);
            //System.err.println("Exception: " + e.getMessage());
            //e.printStackTrace(); --> es lo que saca la VM si no lo tratamos
        } catch (ApplicationException e) {
            throw new ApplicationException("Error de Aplicacion en la Aplicacion.", e);
        } catch (Exception e) { // hace falta ponerlo, por si hay de otro tipo
            throw new ApplicationException("Error Generico en la Aplicacion.", e);
        } finally { // se ejecutara siempre
            System.out.println("Fin de la ejecucion");            
        }
    }
    

    // Excepcion
    public static double raiz(double number) throws Exception {
        try {
            if (true) {
                throw new ApplicationException("Este HW no soporta esta operacion", null);
            }
            if (number < 0) {

                throw new IllegalNumberValue("Number < 0", number);
            }
            return Math.sqrt(number);
        } finally {
            System.out.println("Termino de ejecutar raiz");
        }   
    }
    
/*  //Assert
    public static double raiz(double number) {
        assert number >= 0;
        return Math.sqrt(number);
    }
*/
}
