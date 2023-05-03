import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Tablero {

    //atributos
    String move;
    private int[][] tablero;
    Scanner entry = new Scanner(System.in);
    int pX, pY;
    ArrayList < String > movements = new ArrayList < > ();
    ArrayList < Integer > moveX = new ArrayList < > ();
    ArrayList < Integer > moveY = new ArrayList < > ();

    //List<List<Integer>> movements = new List<List<Integer>>();

    //Colores
    public static final String cROJO = "\033[1;101m"; // RED
    public static final String cVERDE = "\033[1;102m"; // GREEN
    public static final String cAMARILLO = "\033[1;103m"; // YELLOW
    public static final String cAZUL = "\033[1;104m"; // BLUE
    public static final String cMORADO = "\033[1;105m"; // PURPLE
    public static final String cRESET = "\033[1;0m"; // BLACK

    //metodos

    public Tablero(int filas, int cols, int nColores) {
        this.tablero = new int[filas][cols];
        if (nColores < 0)
            nColores = 3; // Por defecto tres cololes
        if (nColores > 8)
            nColores = 8; // Maximo de colores

        for (int y = 0; y < tablero.length; y++) { // Ciclo filas
            for (int x = 0; x < tablero[y].length; x++) { // Ciclo columnas de cada fila

                tablero[y][x] = ThreadLocalRandom.current().nextInt(1, 6); // Crea numeros aleatorios
            }
        }
    }

    public String showMatrixColor() {
        StringBuilder m = new StringBuilder("   ");

        for (int y = 0; y < tablero[0].length; y++) { // Imprime guia tablero de las columnas.
            m.append(" [").append(y).append("]  ");
        }

        m.append("\n");

        for (int y = 0; y < tablero.length; y++) { // Imprime guia tablero de las filas.
            m.append("[").append(y).append("]");

            for (int x = 0; x < tablero[y].length; x++) { // Ciclo columnas de cada fila.
                switch (tablero[y][x]) { // Imprime el tablero de la columna con colores.

                    case 1:
                        m.append(cVERDE).append("     ").append(cRESET).append(" "); // Añade los colores.
                        break;
                    case 2:
                        m.append(cAMARILLO).append("     ").append(cRESET).append(" ");
                        break;
                    case 3:
                        m.append(cMORADO).append("     ").append(cRESET).append(" ");
                        break;
                    case 4:
                        m.append(cROJO).append("     ").append(cRESET).append(" ");
                        break;
                    case 5:
                        m.append(cAZUL).append("     ").append(cRESET).append(" ");
                        break;
                }
            }
            m.append("\n");
            m.append("\n");
        }
        m.append("\n");
        return m.toString();
    }

    public void recibir() {
        int countCor;
        //try {
        //System.out.println("¿Cuántas coordenadas desea ingresar?");
        //countCor = entry.nextInt();

        //for (int y = 0; y < countCor; y++) {

        System.out.println("Digite las coordenadas:");
        move = entry.nextLine();
        String[] arrMove = move.split(" ");
        pX = Integer.parseInt(arrMove[0]);
        pY = Integer.parseInt(arrMove[1]);
        if (verify(pX, pY) == false) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tWARNING\nDigita Bien las coordenadas por favor");
            //continue;
        } else {
            moveX.add(pX);
            moveY.add(pY);
            movements.add(move);
            delete(pX, pY);
            //down();
            fill();
        }
        //}
        //} catch (Exception e) {
        // System.out.println("\t\t\t\t\t\t\t\t\t\t\tWARNING\nDigita Bien las coordenadas por favor");
        //}
        showMatrixColor();
    }

    public boolean verify(int x, int y) { // Verifica que el número sea mayor o igual a cero y menor que seis.
        return (x < 6 && x >= 0) && (y < 6 && y >= 0);
    }

    public void delete(int x, int y) {
        tablero[x][y] = 0;
    }

    public void fill() {
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                if (tablero[x][y] == 0) {
                    tablero[x][y] = ThreadLocalRandom.current().nextInt(1, 6); // Crea numeros aleatorios.
                }
            }
        }
    }

    public void down() { // Baja los cuadros que estén vacios.
        int aux;
        for (int x = tablero.length - 1; x > -1; x--) {
            for (int y = tablero[x].length; y > -1; y--) {
                if (tablero[x + 1][y] == 0) {
                    aux = tablero[x][y];
                    tablero[x][y] = tablero[x + 1][y];
                    tablero[x + 1][y] = aux;
                }
            }
        }
    }


}