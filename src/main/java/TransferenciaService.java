public class TransferenciaService {
    private CuentaRepository repository;

    public TransferenciaService(CuentaRepository repository) {
        this.repository = repository;
    }

    public String transferir(String origen, String destino, double monto) {
        Cuenta cuentaOrigen = repository.buscarPorNumero(origen);

        if (cuentaOrigen == null) return "Cuenta no existe";
        if (cuentaOrigen.getSaldo() < monto) return "Saldo insuficiente";
        if (monto > 3000) return "Validación adicional (OTP) requerida";

        return "Transferencia exitosa";
    }
}