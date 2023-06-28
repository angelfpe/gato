
public class Main {


    public static void main(String[] args) {
                        
        iniciarJuego();
    }

    static void iniciarJuego() {
        Tablero tablero = new Tablero();
        Jugadores jugadorX = new Jugadores("Jugador X", 'X', tablero);
        Jugadores jugadorO = new Jugadores("Jugador O", 'O', tablero);

        Thread jugadorXThread = new Thread(jugadorX);
        Thread jugadorOThread = new Thread(jugadorO);

        jugadorXThread.start();
        jugadorOThread.start();
    }
}

        
    
    

