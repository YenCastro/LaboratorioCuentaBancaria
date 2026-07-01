public class CuentaCorriente extends CuentaBancaria {

    private double limiteSobregiro;
    private double porcentajeComisionSobregiro;

    // Constructor, sin TI porque siempre será fija por 0.0
    public CuentaCorriente(
            String numeroCuenta,
            String titular,
            double saldoInicial,
            double limiteSobregiro,
            double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;

    }

    // Segundo constructor
    public CuentaCorriente(
            String numeroCuenta,
            String titular,
            double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000, 5.0);

    }


    // Metodo retirar()
    @Override
    public void retirar(double monto) {
        if (monto > saldo + limiteSobregiro) {
            System.out.println("Error: supera el límite de sobregiro.");
        }
        // Se realiza el retiro
        saldo -= monto;

        if (saldo < 0) {
            double montoSobregirado = -saldo;
            double comision = (montoSobregirado * porcentajeComisionSobregiro) / 100;
            saldo -= comision;

            System.out.println("La cuenta entró en sobregiro.");
            System.out.println("Monto sobregirado: $" + montoSobregirado);
            System.out.println("Comisión por sobregiro: $" + comision);

        }

        System.out.println("Retiro realizado con éxito.");
        System.out.println("Monto retirado: $" + monto);
        System.out.println("Nuevo saldo: $" + saldo);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Límite de sobregiro: " + limiteSobregiro);
        System.out.println("Tipo de cuenta: Corriente");
    }
}

