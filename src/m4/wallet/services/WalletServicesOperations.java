package m4.wallet.services;

import m4.wallet.entities.User;
import m4.wallet.entities.Wallet;

/***
 * Interfaz con los metodos que debe tener una aplicacion
 *
 */
public interface WalletServicesOperations {

    /***
     * Metodo para obtener la billetera de un usuario indicado
     * @param user User. Propietario de la Billetera
     * @return Billetera encontrada
     */
    Wallet getWalletByUser(User user);
}
