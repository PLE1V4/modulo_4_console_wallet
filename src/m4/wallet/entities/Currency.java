package m4.wallet.entities;

/***
 * Clase abstracta base para todas las divisas
 */
public abstract class Currency {
    protected double exchangeRate;
    protected String symbol;

    /***
     * Constructor base para todas las divisas
     * @param exchangeRate tipo Double. Corresponde al multiplicador para convertir la divisa base en esta moneda
     * @param symbol tipo String. Corresponde al simbolo de la moneda
     */
    public Currency(double exchangeRate, String symbol) {
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /***
     * Metodo que convierte un monto en la divisa de la moneda.
     * ACTUALMENTE NO SE USA
     * @param amount Monto a convertir
     * @return Double con el valor convertido.
     */
    public double currecyExchange(double amount){
        return amount * this.getExchangeRate();
    }
}
