public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;
    private double tasaInteres;


    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        // Validamos que el saldo inicial no sea negativo.
        // Si lo es, se lanza una IllegalArgumentException para impedir la creación de la cuenta.
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }

        this.saldo = saldoInicial;

        // Validamos que la tasa de interés sea positiva antes de crear la cuenta.
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }

        this.tasaInteres = tasaInteres;
    }

    // Getters para los 4 atributos
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    // Metodo depositar()
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Se han depositado exitosamente: $" + String.format("%.2f", monto));
            System.out.println("Su nuevo saldo es de: $" + String.format("%.2f", saldo));
        } else {
            System.out.println("Por favor, ingrese un monto válido");
        }
    }

    // Metodo retirar() al ser abstract obliga a todas las clases hijas a implementar este metodo. Cada tipo de cuenta implementa su propia lógica de retiro, por eso no se define aquí.
    public abstract void retirar(double monto);

    // Metodo aplicarInteres()
    public void aplicarInteres() {
        double interes = (saldo * tasaInteres) / 100;
        saldo += interes;

        System.out.println("Se ha generado un interés de: $" + String.format("%.2f", interes));
        System.out.println("Su nuevo saldo es de: $" + String.format("%.2f", saldo));
    }

    // Metodo mostrarInfo()
    public void mostrarInfo() {
        System.out.println("Datos de la cuenta");
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Nombre del titular: " + titular);
        System.out.println("Saldo: $" + String.format("%.2f", saldo));
        System.out.println("Tasa de interés: " + tasaInteres + "%");
    }

}
