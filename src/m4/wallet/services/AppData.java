package m4.wallet.services;

import m4.wallet.entities.*;

import java.util.ArrayList;

/***
 * Clase para almacenar la informacion de la App
 * (A falta de Base de datos)
 */
public class AppData {

    public static ArrayList<Currency> appCurrencies = new ArrayList<>();
    public static ArrayList<User> appUsers = new ArrayList<>();
    public static ArrayList<Wallet> appWallets = new ArrayList<>();
    public static ArrayList<Account> appAccounts = new ArrayList<>();


    /***
     *Metodo que ejecuta todos los metodos de carga de datos iniciales de la aplicacion
     *
     */
    public static void initializeData(){

        loadCurrencies();
        loadUsers();
        loadAccounts();
        loadWallets();
    }

    /***
     * Metodo que configura los valores iniciales de las Monedas de la aplicacion
     */

    public static void loadCurrencies(){
        Currency clp = new CLPeso();
        Currency usd = new USDolar(0.0011);

        appCurrencies.add(clp);
        appCurrencies.add(usd);
    }

    /***
     * Metodo que configura los valores iniciales de los Usuarios de la Aplicacion
     */
    public static void loadUsers(){
        User newUser1 = new User(1,"George","Bluth","george.bluth@wallet.cl","123456");
        User newUser2 = new User(2,"Janet","Weaver","janet.weaver@wallet.cl","123456");
        User newUser3 = new User(3,"Emma","Wong","emma.wong@wallet.cl","123456");
        User newUser4 = new User(4,"Eve","Holt","eve.holt@wallet.cl","123456");
        User newUser5 = new User(5,"Charles","Morris","charles.morris@wallet.cl","123456");
        User newUser6 = new User(6,"Tracey","Ramos","tracey.ramos@wallet.cl","123456");

        appUsers.add(newUser1);
        appUsers.add(newUser2);
        appUsers.add(newUser3);
        appUsers.add(newUser4);
        appUsers.add(newUser5);
        appUsers.add(newUser6);

    }

    /***
     * Metodo  que configura las cuentas iniciales de la apicacion
     */
    public static void loadAccounts(){

        Account newAcc1 = new Account(1,100000,AppData.appCurrencies.getFirst());
        Account newAcc2 = new Account(2,200000,AppData.appCurrencies.getFirst());
        Account newAcc3 = new Account(3,300000,AppData.appCurrencies.getFirst());
        Account newAcc4 = new Account(4,400000,AppData.appCurrencies.getFirst());
        Account newAcc5 = new Account(5,500000,AppData.appCurrencies.getFirst());
        Account newAcc6 = new Account(6,600000,AppData.appCurrencies.getFirst());
        appAccounts.add(newAcc1);
        appAccounts.add(newAcc2);
        appAccounts.add(newAcc3);
        appAccounts.add(newAcc4);
        appAccounts.add(newAcc5);
        appAccounts.add(newAcc6);

    }

    /***
     *Metodo que configura las billeteras iniciales de la aplicacion
     *
     */
    public static void loadWallets(){
        Wallet newWallet1 = new Wallet(appUsers.get(0),appAccounts.get(0));
        Wallet newWallet2 = new Wallet(appUsers.get(1),appAccounts.get(1));
        Wallet newWallet3 = new Wallet(appUsers.get(2),appAccounts.get(2));
        Wallet newWallet4 = new Wallet(appUsers.get(3),appAccounts.get(3));
        Wallet newWallet5 = new Wallet(appUsers.get(4),appAccounts.get(4));
        Wallet newWallet6 = new Wallet(appUsers.get(5),appAccounts.get(5));

        appWallets.add(newWallet1);
        appWallets.add(newWallet2);
        appWallets.add(newWallet3);
        appWallets.add(newWallet4);
        appWallets.add(newWallet5);
        appWallets.add(newWallet6);
    }

}
