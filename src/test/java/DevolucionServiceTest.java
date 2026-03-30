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

    @Test
    void testCodigoProductoInvalido() {
        // Caso de prueba: código con solo 5 caracteres (debe tener 6)
        String resultado = service.registrar("D1234", "ABC12", "Juan Perez", "Producto defectuoso", LocalDate.now(), LocalDate.now());
        assertEquals("Ingrese un código de producto válido", resultado);
    }

    @Test
    void testNombreClienteInvalido() {
        // Caso de prueba: Nombre muy corto
        String resultado = service.registrar("D1234", "PROD01", "Ana", "Producto defectuoso", LocalDate.now(), LocalDate.now());
        assertEquals("El nombre del cliente debe tener al menos cuatro caracteres alfabéticos", resultado);
    }


}