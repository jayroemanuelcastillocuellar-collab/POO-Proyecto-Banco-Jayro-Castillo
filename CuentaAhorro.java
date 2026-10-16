/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;

/**
 *
 * @author jayro
 */
public class CuentaAhorro extends CuentaBancaria {
    public double tasaInteresAnual;

    private int retirosRealizadosMes;
    private double comisionPorExceso = 20.0;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        retirosRealizadosMes = 0;
    }

    public boolean retirarConComision(double monto) {
        if (monto <= 0) {
            System.out.println("Error: Monto invalido.");
            return false;
        }

        if (retirosRealizadosMes >= 3) {
            double montoTotal = monto + comisionPorExceso;
            System.out.println("Se supero el limite de retiros gratis. Se cobran L. " + comisionPorExceso + " de comision.");
            if (super.retirar(montoTotal)) {
                retirosRealizadosMes++;
                return true;
            } else {
                return false;
            }
        } else {
            if (super.retirar(monto)) {
                retirosRealizadosMes++;
                return true;
            } else {
                return false;
            }
        }
    }

    public void aplicarInteresMensual() {
        double interesMensual = (getSaldo() * (tasaInteresAnual / 100.0)) / 12.0;
        System.out.println("Interes mensual generado: L. " + interesMensual);
        depositar(interesMensual);
    }
}
