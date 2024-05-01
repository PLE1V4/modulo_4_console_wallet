package m4.wallet.entities;

/***
 * Interfaz que define los metodos que debe tener una billetera.
 */
public interface WalletOperations {

    /***
     * Metodo para transferir a otro usuario
     * @param receiver tipo User. Destinatario de la transferencia
     * @param amount tipo Double. Monto a transferir
     */
    void transfer(User receiver, Double amount );

    /***
     * Metodo para agregar dinero a una cuenta
     * @param amount tipo Doble. Monto a agregar
     */
    void deposit(Double amount);

    /***
     * Metodo para mostrar el saldo de una cuenta en otra divisa
     * @param newCurrency tipo Currency. Divisa en la que se quiere mostrar el saldo.
     * @return tipo Double. Monto en la nueva divisa.
     */
    double showAsNewCurrency(Currency newCurrency);
}
