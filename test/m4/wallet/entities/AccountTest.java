package m4.wallet.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Currency testCurr = new CLPeso();
    Account testAcc = new Account(1,50000,testCurr);

    @Test
    @DisplayName("Test Metodo Sumar un monto al saldo")
    void addFunds() {
        testAcc.addFunds(25000);
        assertEquals(testAcc.getBalance(),75000);
    }

    @Test
    @DisplayName("Test Metodo para restar un monto al saldo")
    void removeFunds() {
        testAcc.removeFunds(25000);
        assertEquals(testAcc.getBalance(), 25000);
    }
}