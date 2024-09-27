package bancoapp;

import java.util.Scanner;

public class BancoApp {

    private static Cliente cliente;
    private static Cuenta cuenta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el tipo de cuenta (Corriente/Ahorro): ");
        String tipoCuenta = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial disponible: ");
        double saldo = scanner.nextDouble();

        // Inicializar objetos
        cliente = new Cliente(nombre);
        cuenta = new Cuenta(tipoCuenta, saldo);

        int opcion;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirarDinero(scanner);
                    break;
                case 3:
                    depositarDinero(scanner);
                    break;
                case 9:
                    System.out.println("Gracias por utilizar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("************************************");
        System.out.println("Nombre del cliente: " + cliente.getNombre());
        System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
        System.out.println("Saldo disponible: " + "Lps " + cuenta.getSaldo());
        System.out.println("************************************");
        System.out.println("** Escriba el número de la opción deseada **");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Retirar");
        System.out.println("3 - Depositar");
        System.out.println("9 - Salir");
        System.out.println("************************************");
    }

    private static void consultarSaldo() {
        System.out.println("Saldo disponible: " + "Lps " + cuenta.getSaldo());
    }

    private static void retirarDinero(Scanner scanner) {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();

        if (cantidad > cuenta.getSaldo()) {
            System.out.println("Fondos insuficientes.");
        } else {
            cuenta.retirar(cantidad);
            System.out.println("Retiro exitoso. Saldo disponible: " + "Lps " + cuenta.getSaldo());
        }
    }

    private static void depositarDinero(Scanner scanner) {
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scanner.nextDouble();

        cuenta.depositar(cantidad);
        System.out.println("Depósito exitoso. Saldo disponible: " + "Lps " + cuenta.getSaldo());
    }
}
