
public class TestBanco {
    public static void main(String[] args) {
        CuentaAhorro cuentaAhorroAna = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");
        CuentaCorriente cuentaCorrienteLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000);
        CuentaEmpresarial cuentaEmpresarialTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000, "Tech Solutions", "123456789-0");
        CuentaAhorro cuentaAhorroMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, "2024-02-01");

        // PRIMERA IMPRESIÓN
        System.out.println("\n INFORMACIÓN DE CUENTAS ");

        System.out.println(" Cuenta de Ahorro - Ana ");
        cuentaAhorroAna.mostrarInfo();

        System.out.println("\n Cuenta Corriente - Luis ");
        cuentaCorrienteLuis.mostrarInfo();

        System.out.println("\n Cuenta Empresarial - Tech Solutions ");
        cuentaEmpresarialTech.mostrarInfo();

        System.out.println("\n Cuenta de Ahorro - María ");
        cuentaAhorroMaria.mostrarInfo();


        // SEGUNDA IMPRESIÓN
        System.out.println("\n OPERACIONES ");

        System.out.println("\nAna Perez deposita $10.000");
        cuentaAhorroAna.depositar(10000);

        System.out.println("\nLuis Gomez retira $25.000");
        cuentaCorrienteLuis.retirar(25000);

        System.out.println("\nTech Solutions retira $10.000");
        cuentaEmpresarialTech.retirar(10000);

        System.out.println("\nMaria Lopez intenta retirar $20.000");
        cuentaAhorroMaria.retirar(20000);


        // TERCERA IMPRESIÓN
        System.out.println("\n APLICAR INTERESES ");

        System.out.println("\n Cuenta de Ahorro - Ana");
        cuentaAhorroAna.aplicarInteres();

        System.out.println("\n Cuenta Corriente - Luis");
        cuentaCorrienteLuis.aplicarInteres();

        System.out.println("\n Cuenta Empresarial - Tech Solutions");
        cuentaEmpresarialTech.aplicarInteres();

        System.out.println("\n Cuenta de Ahorro - María");
        cuentaAhorroMaria.aplicarInteres();


        // CUARTA IMPRESIÓN
        System.out.println("\n  INFORMACIÓN FINAL DE LAS CUENTAS ");

        System.out.println("\n Cuenta de Ahorro - Ana");
        cuentaAhorroAna.mostrarInfo();

        System.out.println("\n Cuenta Corriente - Luis");
        cuentaCorrienteLuis.mostrarInfo();

        System.out.println("\n Cuenta Empresarial - Tech Solutions");
        cuentaEmpresarialTech.mostrarInfo();

        System.out.println("\n Cuenta de Ahorro - María");
        cuentaAhorroMaria.mostrarInfo();


        // RESUMEN FINAL
        System.out.println("\n --------------- RESUMEN FINAL --------------- \n");

        // Calculamos el total de cuentas, el saldo total y el promedio de saldo
        int totalCuentas = 4;

        double saldoTotal = cuentaAhorroAna.getSaldo()
                + cuentaCorrienteLuis.getSaldo()
                + cuentaEmpresarialTech.getSaldo()
                + cuentaAhorroMaria.getSaldo();

        double promedio = saldoTotal / totalCuentas;

        System.out.println("Total de cuentas: " + totalCuentas);
        System.out.println("Saldo total: $" + String.format("%.2f", saldoTotal));
        System.out.println("Promedio de saldo: $" + String.format("%.2f", promedio));

        // Identificamos cual tiene mayor saldo usando if independientes, empezando por Ana, y desde ahí empezando a comparar
        double mayorSaldo = cuentaAhorroAna.getSaldo();
        String numeroCuenta = cuentaAhorroAna.getNumeroCuenta();
        String titular = cuentaAhorroAna.getTitular();

        if (cuentaCorrienteLuis.getSaldo() > mayorSaldo) {
            mayorSaldo = cuentaCorrienteLuis.getSaldo();
            numeroCuenta = cuentaCorrienteLuis.getNumeroCuenta();
            titular = cuentaCorrienteLuis.getTitular();
        }

        if (cuentaEmpresarialTech.getSaldo() > mayorSaldo) {
            mayorSaldo = cuentaEmpresarialTech.getSaldo();
            numeroCuenta = cuentaEmpresarialTech.getNumeroCuenta();
            titular = cuentaEmpresarialTech.getTitular();
        }

        if (cuentaAhorroMaria.getSaldo() > mayorSaldo) {
            mayorSaldo = cuentaAhorroMaria.getSaldo();
            numeroCuenta = cuentaAhorroMaria.getNumeroCuenta();
            titular = cuentaAhorroMaria.getTitular();
        }

        System.out.println("Cuenta con mayor saldo:");
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: $" + String.format("%.2f", mayorSaldo));
    }
}