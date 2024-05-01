package m4.wallet.services;

import m4.wallet.entities.Currency;
import m4.wallet.entities.User;
import m4.wallet.entities.Wallet;

import java.util.ArrayList;

/***
 * Metodos de las clases que consulten datos.
 */
public interface DataConnectorOperations {

    ArrayList<User> getUsers();
    ArrayList<Currency> getCurrencies();
    ArrayList<Wallet> getWallets();
}
