package m4.wallet.services;

/***
 * Clase para la validacion de Datos y Procesamiento de los Mensajes de Error
 */
public class DataValidator {

    /***
     * Constructor vacio para instanciar la clase
     */
    public DataValidator() {
    }

    /***
     * Metodo para validar que un valor ingresado en input de texto corresponda a un numero
     * @param number String. String a verificar
     * @return Int. Codigo de Error. 0 si no hay errores
     */
    public int validateNumber(String number){

        int isValid = 0;
        Double num;

        if (number.isBlank()){
            isValid = 1;
        }else{

            try{
                num = Double.parseDouble(number);

            }catch(NumberFormatException e){
                isValid = 2;
            }
        }

        return isValid;
    }

    /***
     * Metodo que imprime un mensaje dependiendo del codigo de error indicado
     * @param error INT. Codigo de Error. Se obtiene del metodo validateNumber().
     */
    public void errorValidator(int error){

        switch (error){

            case 1:
                System.out.println("No se ingreso ningun valor.");
                System.out.println("Intente nuevamente...");
                break;
            case 2:
                System.out.println("El valor ingresado no es un numero.");
                System.out.println("Intente nuevamente...");
                break;
            default:
                System.out.println("Error Inesperado");
        }
    }



}
