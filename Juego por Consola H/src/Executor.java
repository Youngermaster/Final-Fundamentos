import java.io.IOException;

public class Executor {//extends Thread

    //Clase para ejecutar todos los metodos creados de la clase tablero.

    // Atributos
    static int countMovements = 30;

    //metodos
    //public Executor(String str){super(str);}

    //public void run() { printGame(); }

    public static void printGame(){
        //crear tablero
        Tablero tablero = new Tablero(6, 6, 5);

        //ver el tablero
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tINSTRUCCIONES");
        System.out.println("\nBienvenido a el juego DOTS por consola, para jugarlo debes seguir las siguientes instrucciones:\n");
        System.out.println("1. El juego consta de 30 movimientos \"Válidos\".");
        System.out.println("2. Puedes hacer moviemientos de la siguiente manera:");
        System.out.println("\t0 1");
        System.out.println("\t0 2");
        System.out.println("\tfinish");
        System.out.println("3. El puntaje está dado por el número de puntos que se retiren del tablero.");
        System.out.println("4. Para retirar puntos del tablero, el usuario escoge una secuencia de puntos del mismo color \n   que se encuentren contiguos sobre la misma fila, la misma columna o cambiando de dirección,\n   respecto a la secuencia anterior, mediante giros de 90 grados.");
        System.out.println("5. Si la secuencia de puntos forma una figura cerrada, se eliminan todos los puntos\n   del mismo color de la secuencia que se encuentren en el tablero.");

        System.out.println("\n");
        System.out.println(tablero.showMatrixColor());
        tablero.recibir();
    }
      /**
                while (countMovements > 0) {
                    try {
                        System.out.println("\t\t\t\t\tTienes " + countMovements + " movimientos.\n");
                        tablero.recibir();

                        System.out.println(tablero.showMatrixColor());
                        countMovements--;
                    } catch (Exception e) {
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\tWARNING\nDigita Bien las coordenadas por favor");
                    }
                }

                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\"Felictaciones\"");
            }
       */
}