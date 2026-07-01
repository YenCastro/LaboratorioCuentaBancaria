public class CuentaAhorro extends CuentaBancaria {
    private String fechaApertura;

    // Constructor, sin TI porque siempre será fija por 2.5
    public CuentaAhorro(
            String numeroCuenta,
            String titular,
            double saldoInicial,
            String fechaApertura) {
        super(numeroCuenta, titular, saldoInicial, 2.5);
        // Si saldoInicial es menor a 10.000, hay error
        if (saldoInicial < 10000) {
            throw new IllegalArgumentException(
                    "El saldo mínimo para abrir una cuenta de ahorro es de $10.000."
            );
        }
        this.fechaApertura = fechaApertura;
    }

    // Metodo retirar()
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Ingrese un monto válido.");
        } else if (monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro realizado con éxito.");
            System.out.println("Monto retirado: $" + monto);
            System.out.println("Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Error: saldo insuficiente.");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fecha de apertura: " + fechaApertura);
        System.out.println("Tipo de cuenta: Ahorro");
    }
}
