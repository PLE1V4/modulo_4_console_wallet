package m4.wallet.entities;

/***
 * Clase cuenta que representa una cantidad de dinero y el tipo de divisa
 */
public class Account {
    private int accountNumber;
    private double balance;
    private Currency currency;

    /***
     * Contructor de la cuenta
     * @param accountNumber Tipo INT , identificador de la cuenta
     * @param balance Tipo Double, corresponde al saldo
     * @param currency Tipo Currency, corresponde al tipo de divisa
     */
    public Account(int accountNumber, double balance, Currency currency) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    /***
     * Metodo que suma un monto al saldo de la cuenta
     * @param amount tipo Double. Corresponde al Monto a agregar
     */
    public void addFunds(double amount){
        this.setBalance(this.getBalance() + amount);
    }

    /***
     * Metodo que descuenta un monto al saldo de la cuenta
     * @param amount tipo Double. Corresponde al Monto a descontar
     */
    public void removeFunds(double amount){
        this.balance -= amount;
    }
}
