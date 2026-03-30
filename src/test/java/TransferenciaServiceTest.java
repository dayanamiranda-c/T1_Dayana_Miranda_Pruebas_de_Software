import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

public class TransferenciaServiceTest {
    @Test
    void testSaldoInsuficiente(){
        CuentaRepository repository = mock(CuentaRepository.class);
        TransferenciaService service = new TransferenciaService(repository);

        when(repository.buscarPorNumero("123")).thenReturn(new Cuenta("123",100.0));

        String resultado = service.transferir("123", "456", 500.0);
        assertEquals("Saldo insuficiente", resultado);
    }

    @Test
    void testTransferenciaMontoSospechoso() {
        CuentaRepository repository = mock(CuentaRepository.class);
        TransferenciaService service = new TransferenciaService(repository);

        when(repository.buscarPorNumero("123")).thenReturn(new Cuenta("123", 5000.0));

        String resultado = service.transferir("123", "456", 4000.0);

        assertEquals("Validación adicional (OTP) requerida", resultado);
    }
}
