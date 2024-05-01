package m4.wallet.services;

import m4.wallet.entities.Currency;
import m4.wallet.entities.User;
import m4.wallet.entities.Wallet;

import java.util.ArrayList;

/***
 * Clase que consulta los datos almacenados en nuestra Clase de almacenamiento (AppData)
 */
public class DataConnector implements DataConnectorOperations {

    /***
     * Constructor vacio para Instanciar la clase
     */
    public DataConnector() {
    }

    /***
     * Metodo que devuelve la lista de usuarios almacenada.
     * @return ArrayList<User>
     */
    @Override
    public ArrayList<User> getUsers()
    {
        return AppData.appUsers;
    }

    /***
     * Metodo que devuelve la lista de Divisas disponibles
     * @return ArrayList<Currency>
     */
    @Override
    public ArrayList<Currency> getCurrencies(){
        return AppData.appCurrencies;

    }

    /***
     * Metodo que retorna la lista de billeteras de la aplicacion
     * @return ArrayList<Wallet>
     */
    @Override
    public ArrayList<Wallet> getWallets(){
        return AppData.appWallets;
    }
}
