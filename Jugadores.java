import java.util.Scanner;

public class Jugadores implements Runnable {
    private final String nombre;
    private final char simbolo;
    private final Tablero tablero;

    public Jugadores(String nombre, char simbolo, Tablero tablero) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.tablero = tablero;
    }

    @Override
    public void run() {
        while (!tablero.juegoTerminado()) {
            System.out.println(nombre + ", es tu turno.");
            System.out.println("Tablero:");
            tablero.imprimirTablero();

            int fila, columna;
            do {
                fila = obtenerEntrada("Ingrese la fila (0-2): ");
                columna = obtenerEntrada("Ingrese la columna (0-2): ");
            } while (!tablero.marcarCasilla(fila, columna, simbolo));

            tablero.verificarGanador();
            tablero.cambiarTurno();
        }
    }

    private int obtenerEntrada(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int entrada;

        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                entrada = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Debes ingresar un número entero.");
                scanner.next(); // Descartar la entrada no válida
            }
        }

        return entrada;
    }
}
