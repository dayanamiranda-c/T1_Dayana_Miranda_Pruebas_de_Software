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

    @Test
    void testMotivoInvalido() {
        // Caso de prueba: Motivo de solo 5 caracteres
        String resultado = service.registrar("D1234", "PROD01", "Juan Perez", "Error", LocalDate.now(), LocalDate.now());
        assertEquals("El motivo de la devolución debe tener al menos diez caracteres", resultado);
    }

    @Test
    void testFechaInvalida() {
        LocalDate fechaCompra = LocalDate.now();
        LocalDate fechaDevolucion = fechaCompra.minusDays(5); // Fecha inválida (anterior a la compra)

        String resultado = service.registrar("D1234", "PROD01", "Juan Perez", "Producto fallado de fábrica", fechaCompra, fechaDevolucion);
        assertEquals("Ingrese una fecha de devolución válida", resultado);
    }

    @Test
    void testRegistroExitoso() {
        String resultado = service.registrar("D1234", "ABC123", "Juan Perez", "Producto fallado de fábrica", LocalDate.now(), LocalDate.now());
        assertEquals("La devolución ha sido registrada correctamente", resultado);
    }
}