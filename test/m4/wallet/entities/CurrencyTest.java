package m4.wallet.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    public Currency testCurr = new USDolar(0.0011);

    @Test
    void currecyExchange() {
        assertEquals(testCurr.currecyExchange(5000),5.5);
    }
}