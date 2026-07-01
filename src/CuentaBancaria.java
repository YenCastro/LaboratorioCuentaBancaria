public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;
    private double tasaInteres;


    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        // Validar saldo, usamos throw IllegalArgumentException para para indicar que el usuario pasó un argumento en especifico inválido
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }

        this.saldo = saldoInicial;

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
            System.out.println("Se han depositado exitosamente: " + monto);
            System.out.println("Su nuevo saldo es de: $" + saldo);
        } else {
            System.out.println("Por favor, ingrese un monto válido");
        }
    }

    // Metodo retirar()
    public void retirar(double monto) {
        System.out.println("Cada tipo de cuenta implementa su propia lógica de retiro en las clases hijas");
    }

    // Metodo aplicarInteres()
    public void aplicarInteres() {
        double interes = (saldo * tasaInteres) / 100;
        saldo += interes;

        System.out.println(" Se ha generado un interes de: $" + interes);
        System.out.println(" Su nuevo saldo es de: $" + saldo);
    }

    // Metodo mostrarInfo()
    public void mostrarInfo() {
        System.out.println("Datos de la cuenta");
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Nombre del titular: " + titular);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Tasa de interés: " + tasaInteres + "%");
    }

}
