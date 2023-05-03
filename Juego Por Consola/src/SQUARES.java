import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SQUARES {

    //atriburos
    private int opcion;
    private Tablero tablero;
    public String nombreJugador;


    //Colores
    private static final String cBLINK = "\033[5m"; //Blink
    private static final String cNEGRO = "\033[30m"; // BLACK
    private static final String cROJO = "\033[91m"; // RED
    private static final String cVERDE = "\033[92m"; // GREEN
    private static final String cAMARILLO = "\033[93m"; // YELLOW
    private static final String cAZUL = "\033[94m"; // BLUE
    private static final String cMORADO = "\033[95m"; // PURPLE
    private static final String cCIELO = "\033[96m"; // CYAN
    private static final String cBLANCO = "\033[97m"; // WHITE
    private static final String cRESET = "\033[0m"; // RESETAR


    //metodos
    public SQUARES() {
        this.nombreJugador = Read.leerTexto("Nombre del jugador? ");
    }

    public void iniciar() {
        printInstruccions();
        opcion = verMenuInicio();
        while (opcion != 9) {
            try {
                switch (opcion) {
                    case 1:
                        this.tablero = new Tablero(Read.leerNumero(cAMARILLO + "Cuantas filas tiene el tablero? "), //
                                Read.leerNumero("Cuantas Columnas tiene el tablero? "),
                                Read.leerNumero("Cuantos Colores tiene el tablero? " + cRESET)); //
                        System.out.println(this.tablero.showMatrixColor());
                        break;
                    case 2:
                        this.guardarArchivoTablero(Read.leerTexto(cCIELO + "Nombre del archivo: " + cRESET)); //cCIELO ++ cRESET
                        System.out.println(cAZUL + "El Tablero de juego esta guardado, todo bajo control :)" + cRESET); //cAZUL +  + cRESET
                        break;
                    case 3:
                        System.out.println(this.tablero.showMatrixColor());
                        break;
                    case 4:
                        this.tablero.play();
                        System.out.println(this.tablero.showMatrixColor());
                        break;
                    case 5:
                        this.abrirArchivoTablero(Read.leerTexto(cCIELO + "Nombre del archivo: " + cRESET)); //cCIELO +  + cRESET
                        System.out.println(cAMARILLO + "El Tablero de juego esta abierto y disponible.\nAnimate a jugar :)" + cRESET); //cAMARILLO +  + cRESET
                        break;
                }
                opcion = verMenuInicio();
            } catch (Exception e) {
                System.out.println(cROJO + "Parece que hay un error :'(\n" + e.toString() + cRESET);
            }
        }
    }
    public int verMenuInicio() {
        System.out.println(new StringBuilder().append("\n").append(cAMARILLO).append(" __^__                                      __^__").toString());
        System.out.println(new StringBuilder().append("( ___ )------------------------------------( ___ )").toString());
        System.out.println(new StringBuilder().append(" | / |                                      | \\ |").toString());
        System.out.println(new StringBuilder().append(" | / |        ").append(cROJO).append("       \uD83C\uDD82\uD83C\uDD80\uD83C\uDD84\uD83C\uDD70\uD83C\uDD81\uD83C\uDD74\uD83C\uDD82").append(cAMARILLO).append("             | \\ |").toString());
        System.out.println(new StringBuilder().append(" |___|                                      |___|").toString());
        System.out.println(new StringBuilder().append("(_____)------------------------------------(_____)").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   ------------------------------------").toString());
        System.out.println(new StringBuilder().append("\t").append("   |").append(cROJO).append(" [1]").append(cRESET).append(cCIELO).append(" Generar tablero nuevo ").append(cAMARILLO).append("       |").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   |").append(cMORADO).append(" [2]").append(cRESET).append(cVERDE).append(" Guardar juego de archivo").append(cAMARILLO).append("     |").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   |").append(cAMARILLO).append(" [3]").append(cRESET).append(cMORADO).append(" Ver tablero").append(cAMARILLO).append("                  |").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   |").append(cVERDE).append(" [4]").append(cRESET).append(cAZUL).append(" Jugar").append(cAMARILLO).append("                        |").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   |").append(cNEGRO).append(" [5]").append(cRESET).append(cROJO).append(" Abrir juego de archivo").append(cAMARILLO).append("       |").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   |").append(cCIELO).append(" [9]").append(cRESET).append(cROJO).append(" Salir del juego").append(cAMARILLO).append("              |").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   |").append(cCIELO).append("  © Juan Manuel Young Hoyos").append(cAMARILLO).append("       |").toString());
        System.out.println(new StringBuilder().append("\t").append(cAMARILLO).append("   ------------------------------------").toString());
        return Read.leerNumero(new StringBuilder().append("\n").append(cVERDE).append("Cual es tu opcion? ").append(cRESET).toString());
    }
    public void guardarArchivoTablero(String nombreArchivo) {
        try {
            ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            guardar.writeObject(this.tablero);
        } catch (Exception e) {
            System.out.println(cROJO + "Parece que hay un error :'( /n" + cRESET + e.toString()); //cROJO +  + cRESET
        }
    }
    public void abrirArchivoTablero(String nombreArchivo) {
        try {
            ObjectInputStream abrir = new ObjectInputStream(new FileInputStream(nombreArchivo));
            this.tablero = (Tablero) abrir.readObject();
        } catch (Exception e) {
            System.out.println(cROJO + "Parece que hay un error :'( /n" + cRESET + e.toString()); //cROJO +  + cRESET
        }
    }
    public void printInstruccions() { //                                                                                                                            ="
        System.out.println("\n" + cMORADO + "=====================================================================");
        System.out.println("=            " + cCIELO + "▂▃▄▅▆▇█▓▒░INSTRUCCIONES░▒▓█▇▆▅▄▃▂" + cMORADO + "          =");
        System.out.println("=====================================================================" + cRESET + "\n");
        System.out.println(cAMARILLO + "\nBienvenido a el juego SQUARES, para jugarlo debes seguir las siguientes instrucciones:\n");
        System.out.println("1. El juego consta de 30 movimientos \"Válidos\".");
        System.out.println("2. Puedes hacer moviemientos de la siguiente manera:");
        System.out.println(cROJO + "\t4,5-4,6-4,7 \t LA CADENA NO DEBE CONTENER ESPACIOS.");
        System.out.println("\tPuedes digitar Return para cancelar tu jugada.");
        System.out.println("\tPuedes digitar Save para guardar la partida.");
        System.out.println("\tPuedes digitar Exit para salir completamente del juego." + cAMARILLO);
        System.out.println("3. El puntaje está dado por el número de puntos que se retiren del tablero.");
        System.out.println("4. Para retirar puntos del tablero, el usuario escoge una secuencia de puntos del mismo color \n   que se encuentren contiguos sobre la misma fila, la misma columna o cambiando de dirección,\n   respecto a la secuencia anterior, mediante giros de 90 grados.");
        System.out.println("5. Si la secuencia de puntos forma una figura cerrada, se eliminan todos los puntos\n   del mismo color de la secuencia que se encuentren en el tablero.");
        System.out.println("\n");
    }
    }