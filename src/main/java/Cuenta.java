public class Cuenta {
    private String numero;
    private double saldo;

    public Cuenta(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }
}
