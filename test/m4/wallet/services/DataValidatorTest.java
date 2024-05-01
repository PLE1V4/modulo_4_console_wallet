package m4.wallet.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {

    DataValidator testValidator = new DataValidator();

    @Test
    @DisplayName("Test Validar Numero: Exito")
    void validateNumberSuccess() {
        int result = testValidator.validateNumber("5");
        assertEquals(result,0);
    }

    @Test
    @DisplayName("Test Validar Numero: Valor en blanco")
    void validateNumberBlank() {
        int result = testValidator.validateNumber("");
        assertEquals(result,1);
    }

    @Test
    @DisplayName("Test Validar Numero: Valor No Numerico")
    void validateNumber() {
        int result = testValidator.validateNumber("hola");
        assertEquals(result,2);
    }

}