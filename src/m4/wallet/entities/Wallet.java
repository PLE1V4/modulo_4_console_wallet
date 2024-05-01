package m4.wallet.entities;

import m4.wallet.services.DataConnector;
import m4.wallet.services.TransactionValidator;
import m4.wallet.services.WalletServices;


/***
 * Clase que representa la billetera electronica de los usuarios.
 * Tiene un usuario y una cuenta asociada,
 * si como una lista de contactos opcional.
 */
public class Wallet implements WalletOperations {

    private User user;
    private Account account;
    private ContactList contacts = new ContactList();

    /***
     * Constructor de la billetera. Por defecto no tiene una lista d contactos
     * @param user tipo User. Corresponde al usuario dueño de la billetera
     * @param account tipo Account. Corresponde a la cuenta financiera del usuario, asociada a la billetera.
     */
    public Wallet(User user, Account account) {
        this.user = user;
        this.account = account;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ContactList getContacts() {
        return contacts;
    }

    public void setContacts(ContactList contacts) {
        this.contacts = contacts;
    }

    /***
     * Metodo que setea la lista de Contactos de la wallet, haciendo uso del metodo propio de la lista de contactos
     * y la lista de usuarios del sistema.
     */
    public void loadContacts(){
        DataConnector dc = new DataConnector();
        this.setContacts(this.getContacts().fillContacts(this.getUser(),dc.getUsers()));
    }

    /***
     * Implementacion del metodo transferencia de dnero a un usuario.
     * Recibe un monto y un destinatario y descuente el saldo de la cuenta de origen
     * y lo agrega a la cuenta del destinatario.
     * @param receiver tipo User. Usuario al que se le realiza la transferencia
     * @param amount tipo Double. Monto a transferir.
     */
    @Override
    public void transfer(User receiver, Double amount) {

        TransactionValidator tv = new TransactionValidator();
        WalletServices ws = new WalletServices();

        if(tv.validAmount(amount) == 0)
        {
            if(tv.validateTransfer(amount,this.getAccount().getBalance()) == 0){
                //this.getAccount().removeFunds(amount);
                this.getAccount().removeFunds(amount);
                ws.getWalletByUser(user).getAccount().addFunds(amount);
                System.out.println("Transferencia Exitosa");
            }else {
                System.out.println("Saldo insuficiente");
            }
        }else{
            tv.readAmountError(tv.validAmount(amount));
        }
    }

    /***
     * Implementacion de metodo para agregar fondos a la cuenta asoaciada la wallet
     * @param amount tipo Double. Monto a agregar.
     */
    @Override
    public void deposit(Double amount) {

        TransactionValidator tv = new TransactionValidator();

        int validation = tv.validAmount(amount);

        if(validation == 0){
            this.getAccount().addFunds(amount);
            System.out.println("Saldo Agregad Crrectamente");
        }else{
            tv.readAmountError(validation);
        }

    }

    /***
     * Implementacion de metodo que muestra el saldo actual como  el monto en otra divisa. sin modificarlo.
     * @param newCurrency tipo Currency. Divisa en la que se desea mostrar el saldo
     * @return tipo Double. Valor del saldo en la nuev divisa.
     */
    @Override
    public double showAsNewCurrency(Currency newCurrency) {

        return this.getAccount().getBalance() * newCurrency.getExchangeRate();
    }
}
