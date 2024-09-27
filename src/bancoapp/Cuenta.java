package bancoapp;

public class Cuenta {
    private String tipoCuenta;
    private double saldo;

    public Cuenta(String tipoCuenta, double saldo) {
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(double cantidad) {
        this.saldo -= cantidad;
    }

    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }
}
