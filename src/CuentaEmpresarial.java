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

        // Validar que el monto sea positivo
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser mayor que cero.");
            return;
        }

        if (totalRetiro > saldo) {
            System.out.println("El saldo es insuficiente para realizar un retiro");
            return;
        }
        // Restar el monto del saldo
        saldo -= (monto + comisionRetiro);

        System.out.println("Retiro exitoso");
        System.out.println("Monto retirado: $" + String.format("%.2f", monto));
        System.out.println("Comisión por retiro: $" + String.format("%.2f", comisionRetiro));
        System.out.println("Nuevo saldo: $" + String.format("%.2f", saldo));
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Nombre de la empresa: " + nombreEmpresa);
        System.out.println("RUT de la empresa: " + RUT);
        System.out.println("Tipo de cuenta: Empresarial");
    }
}


