import java.util.ArrayList;
import java.util.Scanner;

public class Tablero
{
    //atributos

    private int[][] tablero;
    String move;
    ArrayList <String> movements = new ArrayList<>();
    ArrayList <Integer> movementsF = new ArrayList<>();
    ArrayList <Integer> movementsC = new ArrayList<>();
    Scanner entry = new Scanner(System.in);
    String condition;
    int fila, col, fila2, col2;
    int countMoves = 0;
    int moveLength = 0;
   /*
   Para dar color al texto por consola, la informacion esta en:
   https://misc.flogisoft.com/bash/tip_colors_and_formatting
   */


    //Colores
    public static final String cNEGRO = "\033[1;100m";// BLACK
    public static final String cROJO = "\033[1;101m";// RED
    public static final String cVERDE = "\033[1;102m";// GREEN
    public static final String cAMARILLO = "\033[1;103m";// YELLOW
    public static final String cAZUL = "\033[1;104m";// BLUE
    public static final String cMORADO = "\033[1;105m"; // PURPLE
    public static final String cCIELO = "\033[1;106m";  // CYAN
    public static final String cBLANCO = "\033[1;107m";   // WHITE
    public static final String cRESET = "\033[1;0m";// BLACK

    //metodos

    public Tablero (int filas, int cols, int nColores){
        this.tablero = new int[filas][cols];
        if (nColores < 0)
            nColores = 3; //por defecto tres cololes
        if (nColores > 8)
             nColores = 8; //maximo de colores

        for(int y=0; y<tablero.length; y++){ //ciclo filas
            for (int x=0; x<tablero[y].length; x++){ //ciclo columnas de cada fila
                tablero[y][x] = (int)(Math.random()*nColores)+1;
            }
        }
    }

    public String verMatrizColor(){
        String m = "   ";

        //imprimir guia tablero
        for (int i=0; i<tablero[0].length; i++){
            m = m + "   ["+i+"]   ";
        }
        m = m + "\n";
        for(int y=0; y<tablero.length; y++){ //ciclo filas
            m = m+"["+y+"]";

            for (int x=0; x <tablero[y].length; x++){ //ciclo columnas de cada fila
                switch (tablero[y][x]) {

                    case 1:
                        m = m + cROJO + " " + " Red  " + " " + cRESET + " ";
                        break;
                    case 2:
                        m = m + cVERDE + "  Green " + cRESET + " ";
                        break;
                    case 3:
                        m = m + cAMARILLO + " Yellow " + cRESET + " ";
                        break;
                    case 4:
                        m = m + cAZUL + "  Blue  " + cRESET + " ";
                        break;
                    case 5:
                        m = m + cMORADO + " Purple " + cRESET + " ";
                        break;
                    case 6:
                        m = m + cCIELO + " " + tablero[y][x] + " " + cRESET + " ";
                        break;
                    case 7:
                        m = m + cBLANCO + " " + tablero[y][x] + " " + cRESET + " ";
                        break;
                    case 8:
                        m = m + cNEGRO + " " + tablero[y][x] + " " + cRESET + " ";
                        break;
                    default:
                        m = m + cRESET + " " + tablero[y][x] + " " + cRESET + " ";
                        break;
                }
            }
            m=m+"\n";
        }
        m=m+"\n";
        return m;
    }

    public void rMovements(){
        System.out.println("Digite una cadena de posiciones\nCuando termine de digitar copie \"finish\".\nUn ejemplo es:\n0,0-0,1-0,2-finish\n________________________________\n");
        move = entry.next();
        if(descomponer(move) == true){
            movements.add(move);
        }


    }

    public boolean descomponer(String cadena){
        int nFinal = (cadena.length()) - 6;
        int count2 = 1;
        int count3 = 0;
        for(int y = 0 ; y < nFinal ; y++){
            String fila3 = cadena.substring(y + count3, count2);
            String col3 = cadena.substring(y + 2 + count3, count2 + 2);
            count3+= 3;
            count2+= 4;
            int fila4 = Integer.parseInt(fila3);
            int col4 = Integer.parseInt(col3);
            movementsF.add(fila4);
            movementsC.add(col4);
        }
        return cadena.substring(nFinal).equalsIgnoreCase("Finish")? true : false;
    }

    public void recibir(){

        System.out.println("Digite una cadena de posiciones\nCuando termine de digitar copie \"finish\".\nUn ejemplo es:\n0 - 0\n0 - 1\nfinish\n________________________________\n");
        int countM = 0;
        while (countM < 30) {

            System.out.print("Digite la fila que desea: ");
            fila = entry.nextInt();
            if(fila > tablero.length){
                System.out.println("Pruebe de nuevo");
                break;
            }
            System.out.print("Digite la columna que desea: ");
            col = entry.nextInt();
            if(col > tablero[0].length){
                System.out.println("Pruebe de nuevo");
                break;
            }
            System.out.print("\nDigite la fila que desea: ");
            fila2 = entry.nextInt();
            if(fila2 > tablero.length){
                System.out.println("Pruebe de nuevo");
                break;
            }
            System.out.print("Digite la columna que desea: ");
            col2 = entry.nextInt();
            if(col2 > tablero[0].length){
                System.out.println("Pruebe de nuevo");
                break;
            }
            System.out.println("¿Desea seguir digitando posiciones?\nfinish para parar, con cualquier otra palabra puedes continuar");
            condition = entry.next();
            if(condition.equalsIgnoreCase("finish")){
                break;
            }
            countM++;
        }
    }

    public boolean validacion(int fila1, int col1, int fila2, int col2){
        return (fila1 >= fila2 || col1 >= col2) && (fila1 <= fila2 || col1 <= col2);
    }

    public void delete(){

    }

    public void square(){

    }

    public void rellenar(){

    }



   /*
   public String verMatriz(){
        String m = "   ";
        //imprimir guia tablero
        for (int i=0; i<tablero[0].length; i++){
            m = m + "["+i+"] ";
        }
        m = m + "\n";
        for(int y=0; y<tablero.length; y++){ //ciclo filas
            m = m+"["+y+"]";
            for (int x=0; x<tablero[y].length; x++){ //ciclo columnas de cada fila
               m = m + " " + tablero[y][x] + " " + " ";
            }
            m=m+"\n";
        }
        m=m+"\n";
        return m;
   }

   public void modificarColumna(int col, int valor){
      if (col < tablero[0].length && col >= 0){
        for(int y=0; y<tablero.length; y++){
          tablero[y][col] = valor;  
        } 
      }
   }
   
   public void modificarFila(int fila, int valor){
    if (fila < tablero.length && fila >= 0){
      for(int x=0; x<tablero[fila].length; x++){
        tablero[fila][x] = valor;  
      } 
    }
 }
 */
}
