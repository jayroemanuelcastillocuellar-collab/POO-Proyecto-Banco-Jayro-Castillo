/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;

/**
 *
 * @author jayro
 */
public class CuentaCorriente extends CuentaBancaria {
    public String nombreEmpresa;

    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    public boolean retirarConSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: Monto invalido.");
            return false;
        }

        double saldoActual = getSaldo();

        if (saldoActual >= monto) {
            return super.retirar(monto);
        }

        double sobregiroDisponible = limiteSobregiro - sobregiroUtilizado;
        double totalDisponible = saldoActual + sobregiroDisponible;

        if (monto <= totalDisponible) {
            double diferencia = monto - saldoActual;
            double recargo = diferencia * 0.03;
            double cargoSobregiro = diferencia + recargo;

            if (saldoActual > 0) {
                super.retirar(saldoActual);
            }

            sobregiroUtilizado += cargoSobregiro;

            System.out.println("Retiro con sobregiro aplicado.");
            System.out.println("Credito tomado: L. " + diferencia);
            System.out.println("Recargo del 3%: L. " + recargo);
            System.out.println("Sobregiro total en uso: L. " + sobregiroUtilizado);
            return true;
        } else {
            System.out.println("Error: Limite de sobregiro excedido.");
            return false;
        }
    }

    public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a pagar debe ser mayor a 0.");
            return;
        }

        System.out.println("Abonando L. " + monto + " a la cuenta...");

        if (sobregiroUtilizado > 0) {
            if (monto <= sobregiroUtilizado) {
                sobregiroUtilizado -= monto;
                System.out.println("Abono a deuda completado. Deuda actual: L. " + sobregiroUtilizado);
            } else {
                double sobrante = monto - sobregiroUtilizado;
                System.out.println("Sobregiro pagado en su totalidad.");
                sobregiroUtilizado = 0.0;
                depositar(sobrante);
            }
        } else {
            System.out.println("No hay deuda pendiente. El abono pasa a saldo.");
            depositar(monto);
        }
    }
}
