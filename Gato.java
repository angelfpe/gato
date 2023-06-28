public class Gato {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugadores jugadorX = new Jugadores("Jugador X", 'X', tablero);
        Jugadores jugadorO = new Jugadores("Jugador O", 'O', tablero);

        Thread jugadorXThread = new Thread(jugadorX);
        Thread jugadorOThread = new Thread(jugadorO);

        jugadorXThread.start();
        jugadorOThread.start();
    }

    static void iniciarJuego() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}