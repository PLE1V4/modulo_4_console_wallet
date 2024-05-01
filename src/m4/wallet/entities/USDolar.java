package m4.wallet.entities;

/***
 * Clase que representa la divisa tipo Dolar
 */
public class USDolar extends Currency {

    public USDolar(double exchangeRate ) {
        super(exchangeRate, "USD$");
    }

}
