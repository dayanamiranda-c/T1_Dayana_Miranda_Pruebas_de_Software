import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class DevolucionServiceTest {
    private final DevolucionService service = new DevolucionService();

    @Test
    void testCodigoDevolucionInvalido() {
        // Escenario: Enviamos un código que no empieza con D
        String resultado = service.registrar("A1234", "PROD01", "Juan Perez", "Producto defectuoso", LocalDate.now(), LocalDate.now());

        // Verificación: Debe retornar el mensaje de error específico del examen
        assertEquals("Ingrese un código de devolución válido", resultado);
    }
}