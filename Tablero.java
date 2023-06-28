public class Tablero {
    private final char[][] tablero;
    private boolean juegoTerminado;
    private char jugadorActual;

    public Tablero() {
        tablero = new char[3][3];
        juegoTerminado = false;
        jugadorActual = 'X';

        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public synchronized boolean marcarCasilla(int fila, int columna, char simbolo) {
        if (tablero[fila][columna] == '-') {
            tablero[fila][columna] = simbolo;
            return true;
        } else {
            System.out.println("Casilla ocupada. Inténtalo de nuevo.");
            return false;
        }
    }

    public synchronized void cambiarTurno() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    public synchronized boolean juegoTerminado() {
        return juegoTerminado;
    }

    public synchronized void verificarGanador() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
                juegoTerminado = true;
                System.out.println("¡El Jugador " + jugadorActual + " ha ganado!");
                return;
            }
        }

        // Verificar columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] != '-' && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
                juegoTerminado = true;
                System.out.println("¡El Jugador " + jugadorActual + " ha ganado!");
                return;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            juegoTerminado = true;
            System.out.println("¡El Jugador " + jugadorActual + " ha ganado!");
            return;
        }

        if (tablero[2][0] != '-' && tablero[2][0] == tablero[1][1] && tablero[2][0] == tablero[0][2]) {
            juegoTerminado = true;
            System.out.println("¡El Jugador " + jugadorActual + " ha ganado!");
            return;
        }

        // Verificar empate
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    empate = false;
                    break;
                }
            }
        }

        if (empate) {
            juegoTerminado = true;
            System.out.println("¡Empate! No hay ganador.");
        }
    }

    public synchronized void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}