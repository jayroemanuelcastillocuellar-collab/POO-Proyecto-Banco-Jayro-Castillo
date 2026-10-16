/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentabancaria;

/**
 *
 * @author jayro
 */
public class CuentaBancaria {
    public String numeroCuenta;
    public String titular;

    private double saldo;
    private int totalTransacciones;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldoInicial < 0.0) {
            saldo = 0.0;
        } else {
            saldo = saldoInicial;
        }
        totalTransacciones = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            totalTransacciones++;
            System.out.println("Deposito realizado: L. " + monto);
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a 0.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            totalTransacciones++;
            System.out.println("Retiro realizado: L. " + monto);
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente o monto invalido.");
            return false;
        }
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("No. Cuenta: " + numeroCuenta);
        System.out.println("Saldo: L. " + saldo);
        System.out.println("Transacciones: " + totalTransacciones);
    }
}