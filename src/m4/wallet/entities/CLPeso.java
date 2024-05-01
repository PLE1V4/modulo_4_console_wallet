package m4.wallet.entities;

/***
 * Corresponde al tipo de divisa por defecto de la Aplicacion
 */
public class CLPeso extends Currency {

    /***
     * Constructor que no recibe valores
     * Se inicializa con su simbolo correspondiente y tasa de cambio base = 1 por ser la moneda base
     */
    public CLPeso() {
        super(1,"CLP$");
    }


}
