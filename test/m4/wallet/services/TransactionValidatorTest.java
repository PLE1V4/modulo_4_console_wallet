package m4.wallet.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionValidatorTest {

    TransactionValidator testTv = new TransactionValidator();

    @Test
    @DisplayName("Validar Cantidad: Exito")
    void validAmountSucess() {
        int result = testTv.validAmount(50);
        assertEquals(result,0);
    }

    @Test
    @DisplayName("Validar Cantidad: Valor 0")
    void validAmount0() {
        int result = testTv.validAmount(0);
        assertEquals(result,1);
    }

    @Test
    @DisplayName("Validar Cantidad: Valor Menor a 0")
    void validAmountNegative() {
        int result = testTv.validAmount(-1);
        assertEquals(result,2);
    }

    @Test
    @DisplayName("Valida Transferencia: Exito")
    void validateTransferSuccess() {

        int result = testTv.validateTransfer(50,100);
        assertEquals(result,0);
    }
    @Test
    @DisplayName("Valida Transferencia: Saldo insuficiente")
    void validateTransferFail() {

        int result = testTv.validateTransfer(500,100);
        assertEquals(result,1);
    }
}