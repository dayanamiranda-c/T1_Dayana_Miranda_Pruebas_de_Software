import java.time.LocalDate;

public class DevolucionService {
    /*public String registrar(String codDev, String codProd, String cliente, String motivo, LocalDate fCompra, LocalDate fDev) {
        return ""; // Retornamos vacío para que el test falle
    }*/
    public String registrar(String codDev, String codProd, String cliente, String motivo, LocalDate fCompra, LocalDate fDev) {
        /*if (!codDev.matches("^D\\d{4}$")) {
            return "Ingrese un código de devolución válido";
        }*/
        /*if (codProd == null || !codProd.matches("^[a-zA-Z0-9]{6}$")) {
            return "Ingrese un código de producto válido";
        }*/
        if (cliente == null || !cliente.matches("^[a-zA-Z ]{4,}$")) {
            return "El nombre del cliente debe tener al menos cuatro caracteres alfabéticos";
        }
        return "La devolución ha sido registrada correctamente";
    }
}