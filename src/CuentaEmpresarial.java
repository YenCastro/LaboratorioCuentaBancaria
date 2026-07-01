public class CuentaEmpresarial extends CuentaBancaria {

    private String nombreEmpresa;
    private String RUT;
    private double comisionRetiro = 2000;

    // Constructor
    public CuentaEmpresarial(
            String numeroCuenta,
            String titular,
            double saldoInicial,
            String nombreEmpresa,
            String RUT) {
        super(numeroCuenta, titular, saldoInicial, 1.5);
        if (saldoInicial < 100000) {
            throw new IllegalArgumentException("Saldo mínimo para abrir la cuenta empresarial es $100,000");
        }
        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
    }

    // Metodo retirar()
    @Override
    public void retirar(double monto) {
        double totalRetiro = monto + comisionRetiro;

        if (totalRetiro > saldo) {
            System.out.println("El saldo es insuficiente para realizar un retiro");
            return;
        }
        // Restar el monto del saldo
        saldo -= (monto + comisionRetiro);

        System.out.println("Retiro exitoso");
        System.out.println("Monto retirado: $" + monto);
        System.out.println("Comision por retiro: $" + comisionRetiro);
        System.out.println("Nuevo saldo: $" + saldo);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Nombre de la empresa: " + nombreEmpresa);
        System.out.println("RUT de la empresa: " + RUT
        );
        System.out.println("Tipo de cuenta: Corriente");
    }
}


