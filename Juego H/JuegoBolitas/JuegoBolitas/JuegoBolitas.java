import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JuegoBolitas {
   //atriburos
  public Tablero tablero;
  public String nombreJugador;

    //Colores
    public static final String cNEGRO = "\033[30m";// BLACK
    public static final String cROJO = "\033[91m";// RED
    public static final String cVERDE = "\033[92m";// GREEN
    public static final String cAMARILLO = "\033[93m";// YELLOW
    public static final String cAZUL = "\033[94m";// BLUE
    public static final String cMORADO = "\033[95m"; // PURPLE
    public static final String cCIELO = "\033[96m";  // CYAN
    public static final String cBLANCO = "\033[97m";   // WHITE
    public static final String cRESET = "\033[0m";// RESETAR
   

  //metodos
  public JuegoBolitas(){
      this.nombreJugador = Teclado.leerTexto("Nombre del juegador? ");
  }

  public void iniciar(){
      try {
        int opcion = verMenuInicio();
        while (opcion != 9){
            switch (opcion){
                case 1:
                    this.abrirArchivoTablero(Teclado.leerTexto("Nombre del archivo: "));
                    System.out.println("El Tablero de juego esta abierto y disponible. Animate a jugar :)");
                    break;          
                case 2:
                    this.guardarArchivoTablero(Teclado.leerTexto("Nombre del archivo: "));
                    System.out.println("El Tablero de juego esta guardado, todo bajo control :)");
                    break;
                case 3:
                    System.out.println(this.tablero.verTableroColor());
                    break;
                case 4:
                    this.tablero = new Tablero(Teclado.leerNumero("Cuantas filas tiene el tablero? "),
                                            Teclado.leerNumero("Cuantas Columnas tiene el tablero? "),
                                            Teclado.leerNumero("Cuantos Colores tiene el tablero? "));
                    System.out.println(this.tablero.verTableroColor());
                    break;
            };
            opcion = verMenuInicio();
        }
    } catch (Exception error){
        System.out.println("Parece que hay un error :( /n" + error.toString());
    }
  }
  

  public int verMenuInicio(){
    System.out.println();
    System.out.println("=================================");
    System.out.println("=          Juego BOLITAS        =");
    System.out.println("=================================");
    System.out.println();
    System.out.println(" ["+cROJO+"1"+cRESET+"] Abrir juego de archivo");
    System.out.println(" [2] Guardar juego de archivo");
    System.out.println(" [3] Ver tablero");
    System.out.println(" [4] Generar tablero nuevo");
    System.out.println(" ------------------------------");
    System.out.println(" [9] Salir del juego");
    System.out.println();
    return Teclado.leerNumero("Cual es tu opcion? ");
  }


  public void guardarArchivoTablero(String nombreArchivo){
    try {
      ObjectOutputStream guardar = new ObjectOutputStream(
                                                   new FileOutputStream(nombreArchivo));
      guardar.writeObject(this.tablero);
    } catch (Exception e){
        System.out.println("Parece que hay un error :( /n" + e.toString());
    }
  }

  public void abrirArchivoTablero(String nombreArchivo){
    try {
      ObjectInputStream abrir = new ObjectInputStream(
                                                    new FileInputStream(nombreArchivo));
      this.tablero = (Tablero)abrir.readObject();
    } catch (Exception e){
        System.out.println("Parece que hay un error :( /n" + e.toString());
    }
  }

}