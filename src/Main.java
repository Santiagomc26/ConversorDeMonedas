import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ObtensionDeDatos datoObtenido = new ObtensionDeDatos();
        TasaDeCambio tasaDeCambio = datoObtenido.buscaMonedas();
        Metodo metodo = new Metodo(tasaDeCambio);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> realizarConversion(metodo, "USD", "ARS", scanner);
                case 2 -> realizarConversion(metodo, "ARS", "USD", scanner);
                case 3 -> realizarConversion(metodo, "USD", "BRL", scanner);
                case 4 -> realizarConversion(metodo, "BRL", "USD", scanner);
                case 5 -> realizarConversion(metodo, "BOB", "USD", scanner);
                case 6 -> realizarConversion(metodo, "USD", "BOB", scanner);
                case 7 -> realizarConversion(metodo, "CLP", "USD", scanner);
                case 8 -> realizarConversion(metodo, "USD", "CLP", scanner);
                case 9 -> realizarConversion(metodo, "USD", "COP", scanner);
                case 10 -> realizarConversion(metodo, "COP", "USD", scanner);
                case 11 -> {
                    salir = true;
                    System.out.println("¡Gracias por usar el conversor de monedas! ¡Hasta pronto!");
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }

        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("**********************************************");
        System.out.println("**** Bienvenido/a al conversor de monedas ****");
        System.out.println("******************* MENU *********************");
        System.out.println("* 1.- Dólar(USD) a Peso Argentino(ARS)       *");
        System.out.println("* 2.- Peso Argentino(ARS) a Dólar(USD)       *");
        System.out.println("* 3.- Dólar(USD) a Real Brasileño(BRL)       *");
        System.out.println("* 4.- Real Brasileño(BRL) a Dólar(USD)       *");
        System.out.println("* 5.- Boliviano(BOB) a Dólar(USD)            *");
        System.out.println("* 6.- Dólar(USD) a Boliviano(BOB)            *");
        System.out.println("* 7.- Peso Chileno(CLP) a Dólar(USD)         *");
        System.out.println("* 8.- Dólar(USD) a Peso Chileno(CLP)         *");
        System.out.println("* 9.- Dólar(USD) a Peso Colombiano(COP)      *");
        System.out.println("* 10.- Peso Colombiano(COP) a Dólar(USD)     *");
        System.out.println("* 11.- Salir                                 *");
        System.out.println("**********************************************");
        System.out.print("Seleccione una opción: ");
    }


    private static void realizarConversion(Metodo metodo, String monedaUno, String monedaDos, Scanner scanner) {
        System.out.print("Ingrese el monto en " + monedaUno + ": ");
        double cifra = scanner.nextDouble();

        try {
            double resultado = metodo.convertir(monedaUno, monedaDos, cifra);
            System.out.printf("Resultado: %.2f %s = %.2f %s%n", cifra, monedaUno, resultado, monedaDos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
