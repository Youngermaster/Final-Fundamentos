import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Tablero implements Serializable {

    //atributos
    private SQUARES squares;
    private boolean executeCondition = true;
    private int[][] tablero;
    private int pX, pY, pX2, pY2, pX3, pY3, counter = 30, points = 0;
    private ArrayList < String > moveX = new ArrayList < > ();
    private ArrayList < String > moveY = new ArrayList < > ();
    private String[] spl, spl2;

    // Colores
    private static final String cNEGRO = "\033[30m"; // BLACK
    private static final String RED = "\033[91m"; // RED
    private static final String YELLOW = "\033[93m"; // YELLOW
    private static final String PURPLE = "\033[95m"; // PURPLE
    private static final String CYAN = "\033[96m"; // CYAN


    // Fondos
    private static final String cROJO = "\033[1;101m"; // RED
    private static final String cVERDE = "\033[1;102m"; // GREEN
    private static final String cAMARILLO = "\033[1;103m"; // YELLOW
    private static final String cAZUL = "\033[1;104m"; // BLUE
    private static final String cMORADO = "\033[1;105m"; // PURPLE
    private static final String cRESET = "\033[1;0m"; // BLACK
    private static final String cCIELO = "\033[96;106m"; // CYAN
    private static final String cBLANCO = "\033[97;107m"; // WHITE

    //metodos

    public Tablero(int filas, int cols, int nColores) {
        this.tablero = new int[filas][cols];
        if (nColores < 0)
            nColores = 3; // Por defecto tres cololes
        if (nColores > 8)
            nColores = 8; // Maximo de colores

        for (int y = 0; y < this.tablero.length; y++) { // Ciclo filas
            for (int x = 0; x < this.tablero[y].length; x++) { // Ciclo columnas de cada fila
                this.tablero[y][x] = ThreadLocalRandom.current().nextInt(1, (nColores + 1)); // Crea numeros aleatorios
            }
        }
    }
    public String showMatrixColor() {
        StringBuilder m = new StringBuilder("   ");

        for (int y = 0; y < this.tablero[0].length; y++) { // Imprime guia tablero de las columnas.
            m.append("   [").append(y).append("]");
        }

        m.append("\n");

        for (int y = 0; y < this.tablero.length; y++) { // Imprime guia tablero de las filas.
            m.append(" [").append(y).append("] ");

            for (int x = 0; x < this.tablero[y].length; x++) { // Ciclo columnas de cada fila.
                switch (this.tablero[y][x]) { // Imprime el tablero de la columna con colores.

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
                    case 6:
                        m.append(cCIELO).append("     ").append(cRESET).append(" ").toString();
                        break;
                    case 7:
                        m.append(cBLANCO).append("     ").append(cRESET).append(" ").toString();
                        break;
                    case 8:
                        m.append(cNEGRO).append("     ").append(cRESET).append(" ").toString();
                        break;
                    default:
                        m.append(cRESET).append(" ").append(this.tablero[y][x]).append(" ").append(cRESET).append(" ").toString();
                        break;
                }
            }
            m.append("\n");
            m.append("\n");
        }
        m.append("\n");
        return m.toString();
    }
    public void play() {
        for (int c = 30; c > 0; c--) {
            try {
                System.out.println(YELLOW + "Tienes " + c + " movimientos y " + points + " puntos." + cRESET);
                String move = Read.leerTexto("Digite la jugada, por favor.");
                if ((move.contains("Return")) || (move.contains("return"))) {
                    counter++;
                    c++;
                    continue;
                }
                if ((move.contains("Exit")) || (move.contains("exit"))) {
                    break;
                }
                if ((move.contains("Save")) || (move.contains("save"))) {
                    squares.guardarArchivoTablero(Read.leerTexto("Digite el nombre del archivo, por favor. "));
                }
                split(move);
                if (!verifySizeArrayListSame(moveX, moveY)) {
                    System.out.println("Arralist same");
                    counter++;
                    c++;
                    flush();
                    continue;
                }
                if (moreThanOneMovementInX()) {
                    System.out.println("More Than one movement X");
                    counter++;
                    c++;
                    flush();
                    continue;
                }
                if (moreThanOneMovementInY()) {
                    counter++;
                    c++;
                    flush();
                    System.out.println("More Than one movement X");
                    continue;
                }
                for (int z = 1; z < moveX.size(); z++) {
                    pX2 = Integer.parseInt(moveX.get(z - 1));
                    pY2 = Integer.parseInt(moveY.get(z - 1));
                    pX3 = Integer.parseInt(moveX.get(z));
                    pY3 = Integer.parseInt(moveY.get(z));
                    if (verifyRangeNumber(pX, pY) == false) {
                        System.out.println("Verify Range number");
                        executeCondition = false;
                        flush();
                        break;
                    } else {
                        executeCondition = true;
                    }
                    if (sameColor(pX2, pY2, pX3, pY3) == false) {
                        System.out.println("same Color");
                        executeCondition = false;
                        flush();
                        break;
                    } else {
                        executeCondition = true;
                    }
                    if (verifyNumbersBeforeAndAfter(pX2, pY2, pX3, pY3) == true) {
                        System.out.println("Verify numbers Before and After");
                        executeCondition = false;
                        flush();
                        break;
                    } else {
                        executeCondition = true;
                    }
                }
                if (executeCondition == false) {
                    System.out.println("Execute condition");
                    counter++;
                    c++;
                    continue;
                }
                for (int y = 0; y < moveX.size(); y++) {
                    pX = Integer.parseInt(moveX.get(y));
                    pY = Integer.parseInt(moveY.get(y));
                    delete(pX, pY);
                    points++;
                }
                flush();
                fill();
                counter--;
                System.out.println(showMatrixColor());
            } catch (Exception e) {
                System.out.println("Juega bien, por favor\n:)");
                counter++;
                c++;
            }
        }
        if (counter == 0) {
            System.out.println(CYAN + "Se acabó el juego Tienes 0 movimientos\n\uD83C\uDD76\uD83C\uDD81\uD83C\uDD70\uD83C\uDD72\uD83C\uDD78\uD83C\uDD70\uD83C\uDD82  \uD83C\uDD7F\uD83C\uDD7E\uD83C\uDD81  \uD83C\uDD79\uD83C\uDD84\uD83C\uDD76\uD83C\uDD70\uD83C\uDD81" + cRESET);
            youLoss();
        }
    }
    private void delete(int x, int y) {
        this.tablero[x][y] = 0;
        down();
    }
    private void fill() {
        for (int x = 0; x < this.tablero.length; x++) {
            for (int y = 0; y < this.tablero[x].length; y++) {
                if (this.tablero[x][y] == 0) {
                    this.tablero[x][y] = ThreadLocalRandom.current().nextInt(1, 6); // Crea numeros aleatorios.
                }
            }
        }
    }
    private void down() { // Baja los cuadros que estén vacios.
        int aux;
        for (int x = (this.tablero.length - 1); x > 0; x--) {
            for (int y = (this.tablero[x].length - 1); y > -1; y--) {
                if (this.tablero[x][y] == 0) {
                    aux = this.tablero[x - 1][y];
                    this.tablero[x - 1][y] = this.tablero[x][y];
                    this.tablero[x][y] = aux;
                }
            }
        }
    }
    private void split(String s) {
        spl = s.split("-");
        for (String aSpl: spl) {
            spl2 = aSpl.split(",");
            for (int x = 1; x < spl2.length; x++) {
                moveX.add(spl2[x - 1]);
                moveY.add(spl2[x]);
            }
        }
    }
    private void flush() {
        for (int y = 0; y < moveY.size(); y++) {
            moveY.remove(y);
            moveX.remove(y);
        }
    }
    private void youLoss() {
        System.out.println("\n" + PURPLE + "                                                             ..");
        System.out.println("                                  ,,,                         MM .M");
        System.out.println("                              ,!MMMMMMM!,                     MM MM  ,.");
        System.out.println("      ., .M                .MMMMMMMMMMMMMMMM.,          'MM.  MM MM .M'");
        System.out.println("    . M: M;  M          .MMMMMMMMMMMMMMMMMMMMMM,          'MM,:M M'!M'");
        System.out.println("   ;M MM M: .M        .MMMMMMMMMMMMMMMMMMMMMMMMMM,         'MM'...'M");
        System.out.println("    M;MM;M :MM      .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.       .MMMMMMMM");
        System.out.println("    'M;M'M MM      MMMMMM  MMMMMMMMMMMMMMMMM  MMMMMM.    ,,M.M.'MMM'");
        System.out.println("     MM'MMMM      MMMMMM" + CYAN + " @@" + PURPLE + " MMMMMMMMMMMMMMM" + CYAN + " @@" + PURPLE + " MMMMMMM.'M''MMMM;MM'");
        System.out.println("    MM., ,MM     MMMMMMMM  MMMMMMMMMMMMMMMMM  MMMMMMMMM      '.MMM");
        System.out.println("    'MM;MMMMMMMM.MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.      'MMM");
        System.out.println("     ''.'MMM'  .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM       MMMM");
        System.out.println("      MMC      MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.      'MMMM");
        System.out.println("     .MM      :MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM''MMM       MMMMM");
        System.out.println("     MMM      :M  'MMMMMMMMMMMMM.MMMMM.MMMMMMMMMM'.MM  MM:M.    'MMMMM");
        System.out.println("    .MMM   ...:M: :M.'MMMMMMMMMMMMMMMMMMMMMMMMM'.M''   MM:MMMMMMMMMMMM'");
        System.out.println("   AMMM..MMMMM:M.    :M.'MMMMMMMMMMMMMMMMMMMM'.MM'     MM''''''''''''");
        System.out.println("   MMMMMMMMMMM:MM     'M'.M'MMMMMMMMMMMMMM'.MC'M'     .MM");
        System.out.println("    '''''''''':MM.       'MM!M.'M-M-M-M'M.'MM'        MMM");
        System.out.println("               MMM.            'MMMM!MMMM'            .MM");
        System.out.println("                MMM.             '''   ''            .MM'");
        System.out.println("                 MMM.                               MMM'");
        System.out.println("                  MMMM            " + RED + ",.J.JJJJ." + PURPLE + "       .MMM'");
        System.out.println("                   MMMM.       " + RED + "'JJJJJJJ'JJJM" + PURPLE + "   CMMMMM");
        System.out.println("                     MMMMM.    " + RED + "'JJJJJJJJ'JJJ" + PURPLE + " .MMMMM'");
        System.out.println("                       MMMMMMMM.'  " + RED + "'JJJJJ'JJ" + PURPLE + "MMMMM'");
        System.out.println("                         'MMMMMMMMM" + RED + "'JJJJJ JJJJJ'" + PURPLE);
        System.out.println("                            ''MMMMMM" + RED + "JJJJJJJJJJ'");
        System.out.println("                                    " + RED + "'JJJJJJJJ'\t\t\t\t\t\t\t\t " + cRESET);
    }
    private boolean verifySizeArrayListSame(ArrayList x, ArrayList y) {
        return x.size() == y.size();
    }
    private boolean verifyRangeNumber(int x, int y) { // Verifica que el número sea mayor o igual a cero y menor que seis.
        return (x < 6 && x >= 0) && (y < 6 && y >= 0);
    }
   /**
    private boolean verifyValidMovement(ArrayList < Integer > x, ArrayList < Integer > y, ArrayList < Integer > x1, ArrayList < Integer > y2){
        for (int y = 0 ; y < (moveX.size() - 1) ; y++) {
            if (sameColor()) {

            }
        }
    }*/
    private boolean verifyNumbersBeforeAndAfter(int fila1, int col1, int fila2, int col2) { // verifica que no sea diagonal.
        return (((fila1 < fila2) && (col1 < col2)) || ((fila1 > fila2) && (col1 > col2)) || ((fila1 > fila2) && (col1 < col2)) || ((fila1 < fila2) && (col1 > col2)));
    }
    private boolean sameColor(int fila1, int col1, int fila2, int col2) {
        return this.tablero[fila1][col1] == this.tablero[fila2][col2];
    }
    private boolean moreThanOneMovementInX() {
        return moveX.size() < 2;
    }
    private boolean moreThanOneMovementInY() {
        return moveY.size() < 2;
    }
    private boolean equalMovement(int x, int y, int x2, int y2) {
        return this.tablero[x][y] == this.tablero[x2][y2];
    }
    private boolean verifySquare(ArrayList < Integer > x, ArrayList < Integer > y) {
        return this.tablero[x.get(0)][y.get(0)] == this.tablero[x.get((x.size() - 1))][y.get((y.size() - 1))];
    }
}