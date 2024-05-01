package m4.wallet.services;

/***
 * Clase para validar que las transacciones se puedan realizar correctmente.
 */
public class TransactionValidator {

    /***
     *Constructor vacio para instanciar la clase
     */
    public TransactionValidator() {
    }

    /***
     * Metodo que verifica que el monto a usar en una transaccion sea valido
     * @param amount Double. Monto a verificar
     * @return INT. Codigo de Error segun el tipo de error. 0 si no hay errores.
     */
    public int validAmount(double amount){

        int isValid;

        if( amount == 0){
            isValid = 1;
        } else if (amount < 0) {
            isValid = 2;
        }else{
            isValid = 0;
        }

        return isValid;
    }

    /***
     * Metodo que imprime un mensaje segun el codigo de error del metodo validateAmount().
     * @param error Int.
     */
    public void readAmountError(int error){
        switch (error){
            case 1:
                System.out.println("La Cantidad no puede ser 0");
                System.out.println("Intente nuevamente");
                break;
            case 2:
                System.out.println("La Cantidad no puede ser menor a 0");
                System.out.println("Intente Nuevamente");
                break;
            default:
                System.out.println("Error Inesperado");
        }
    }

    /***
     * Metodo que verifica la factibilidad de realizar una Transferencia
     * @param amount Double. Monto a Transferir
     * @param balance Double. Saldo de la cuenta
     * @return int. 0 si hay saldo suficiente. 1 si no .
     */
    public int validateTransfer(double amount, double balance){

        return  balance >= amount? 0 : 1;
    }

}
