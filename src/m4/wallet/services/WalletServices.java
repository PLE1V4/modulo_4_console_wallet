package m4.wallet.services;

import m4.wallet.entities.User;
import m4.wallet.entities.Wallet;

import java.util.Objects;

/***
 * Clase para consultas a las Billeteras de la aplicacion.
 */
public class WalletServices implements WalletServicesOperations{

    DataConnector dc = new DataConnector();

    /***
     * Constructor vacio para instanciar la clase
     */
    public WalletServices() {
    }

    /***
     * Implementacion de metodo para obtener la billetera de un usuario indicado
     * @param user User. Usuario al cual pertenece la billetera
     * @return Waller. Billetera encontrada
     */
    @Override
    public Wallet getWalletByUser(User user) {

        Wallet wallet = null;

        for(Wallet w : dc.getWallets())
        {
            if(Objects.equals(w.getUser(),user))
            {
                wallet = w;
                break;
            }
        }

        return wallet;
    }
}
