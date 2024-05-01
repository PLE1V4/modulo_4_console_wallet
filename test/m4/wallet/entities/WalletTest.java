package m4.wallet.entities;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    Currency testCurr = new USDolar(0.0011);
    Currency clp = new CLPeso();
    User testUser = new User(1,"demo","user","demo@wallet.cl","123456");
    Account testAccount = new Account(1,5000.0,clp);
    Wallet testWallet = new Wallet(testUser,testAccount);


    @Test
    void showAsNewCurrency() {

       assertEquals(testWallet.showAsNewCurrency(testCurr), 5.5);
    }
}