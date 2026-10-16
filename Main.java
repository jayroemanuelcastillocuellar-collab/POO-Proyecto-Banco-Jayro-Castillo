/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentabancaria;

/**
 *
 * @author jayro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("--- 1. PRUEBA DE ENCAPSULAMIENTO ---");
        CuentaBancaria cuentaPrueba = new CuentaBancaria("CTA-001", "Cliente Prueba", 500.0);


        System.out.println("Acceso directo al saldo bloqueado correctamente por private.\n");

        System.out.println("--- 2. ACCESO A ATRIBUTOS PUBLICOS ---");
        System.out.println("Titular: " + cuentaPrueba.titular);
        System.out.println("Cuenta: " + cuentaPrueba.numeroCuenta);
        System.out.println("Saldo por getter: L. " + cuentaPrueba.getSaldo() + "\n");

        System.out.println("--- 3. PRUEBA CUENTA DE AHORRO ---");
        CuentaAhorro ahorro = new CuentaAhorro("AH-1001", "Jayro Castillo", 3000.0, 5.0);
        ahorro.mostrarDatos();

        System.out.println("\nRetiro 1:");
        ahorro.retirarConComision(200.0);

        System.out.println("Retiro 2:");
        ahorro.retirarConComision(200.0);

        System.out.println("Retiro 3:");
        ahorro.retirarConComision(200.0);

        System.out.println("Retiro 4:");
        ahorro.retirarConComision(200.0);

        System.out.println("Saldo tras 4 retiros: L. " + ahorro.getSaldo() + "\n");

        System.out.println("--- 4. RENDIMIENTO DE AHORRO ---");
        ahorro.aplicarInteresMensual();
        System.out.println("Saldo final con intereses: L. " + ahorro.getSaldo() + "\n");

        System.out.println("--- 5. PRUEBA CUENTA CORRIENTE ---");
        CuentaCorriente corriente = new CuentaCorriente("CC-5001", "Estela Cuellar", 1000.0, "Inversiones S. de R.L.", 5000.0);
        corriente.mostrarDatos();
        System.out.println("Empresa: " + corriente.nombreEmpresa);
        System.out.println("Limite disponible: L. " + corriente.getLimiteSobregiro());

        System.out.println("\nIntentando retirar L. 3500.0:");
        corriente.retirarConSobregiro(3500.0);

        System.out.println("Saldo en cuenta: L. " + corriente.getSaldo());
        System.out.println("Sobregiro usado: L. " + corriente.getSobregiroUtilizado() + "\n");

        System.out.println("--- 6. AMORTIZACION DE SOBREGIRO ---");
        corriente.pagarSobregiro(3000.0);

        System.out.println("Deuda restante: L. " + corriente.getSobregiroUtilizado());
        System.out.println("Saldo disponible: L. " + corriente.getSaldo());
    }
}
    
