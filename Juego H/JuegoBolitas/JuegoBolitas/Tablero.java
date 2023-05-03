import java.io.Serializable;

public class Tablero implements Serializable
{
   //atributos
   private int[][] tablero;

   /*
   Para dar color al texto por consola, la informacion esta en:
   https://misc.flogisoft.com/bash/tip_colors_and_formatting
   */

    //Colores
    public static final String cNEGRO = "\033[30;100m";// BLACK
    public static final String cROJO = "\033[91;101m";// RED
    public static final String cVERDE = "\033[92;102m";// GREEN
    public static final String cAMARILLO = "\033[93;103m";// YELLOW
    public static final String cAZUL = "\033[94;104m";// BLUE
    public static final String cMORADO = "\033[95;105m"; // PURPLE
    public static final String cCIELO = "\033[96;106m";  // CYAN
    public static final String cBLANCO = "\033[97;107m";   // WHITE
    public static final String cRESET = "\033[0;0m";// RESETAR
    
   //metodos
   public Tablero (int filas, int cols, int nColores){
       this.tablero = new int[filas][cols];
       if (nColores < 0)
            nColores = 3; //por defector tres cololes
       if (nColores > 8)
            nColores = 8; //maximo de colores
       
       for(int y=0; y<tablero.length; y++){ //ciclo filas
          for (int x=0; x<tablero[y].length; x++){ //ciclo columnas de cada fila
            tablero[y][x] = (int)(Math.random()*nColores)+1;
          } 
       }   
   }
   
   public String verTableroColor(){
      String m = "\n TABLERO DE JUEGO \n   ";
      //imprimir guia tablero
      for (int i=0; i<tablero[0].length; i++){
          m = m + "["+i+"] ";
      }
      m = m + "\n";
      for(int y=0; y<tablero.length; y++){ //ciclo filas
          m = m+"["+y+"]";
          for (int x=0; x<tablero[y].length; x++){ //ciclo columnas de cada fila
            switch (tablero[y][x]) {
                case 1:
                    m = m + cROJO + " " + tablero[y][x] + " " + cRESET + " ";
                    break;
                case 2:
                    m = m + cVERDE + " " + tablero[y][x] + " " + cRESET + " ";
                    break;
                case 3:
                    m = m + cAMARILLO + " " + tablero[y][x] + " " + cRESET + " ";
                    break;
                case 4:
                    m = m + cAZUL + " " + tablero[y][x] + " " + cRESET + " ";
                    break;
                case 5:
                    m = m + cMORADO + " " + tablero[y][x] + " " + cRESET + " ";
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
            };      
        }
        m=m+"\n";
      }
      m=m+"\n";
      return m;
   }
   
   public String verTablero(){
        String m = "\n TABLERO DE JUEGO \n   ";
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
}
