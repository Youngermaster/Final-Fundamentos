public class Executor {

  //Clase para ejecutar los metodos creados de la clase tablero.

    //atributos
        int movements;

    //metodos
        public static void pruebaImprimirJuego(){

            int movements = 0;
            //crear tablero
                Tablero tablero = new Tablero(6, 6, 5);

            //ver el tablero
                while(movements < 30) {
                    try {
                        System.out.println(tablero.verMatrizColor());
                        tablero.rMovements();

                        movements++;
                    }catch (Exception e){
                        System.out.println("Intenta de nuevo por favor");
                    }
                }

        /*System.out.println(tablero.verMatriz());
        
        //hacer una linea en el tablero por columna
        tablero.modificarColumna(2, 3);
        System.out.println(tablero.verMatrizColor());

        //hacer una linea en el tablero por Fila
        tablero.modificarFila(2, 3);
        System.out.println(tablero.verMatrizColor());
        */
    }

}