
    /*
      Clase principal que inicia el programa
    
      Para compilar:  javac ProgramaX.java
      Para ejecutar:  java ProgramaX
      
      Programa desarrollado en VisualStudio Code 1.2.2 {https://code.visualstudio.com/}
      Java como lenguaje JDK 8 {http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html}
    */
    import javafx.scene.media.*;
    import java.io.File;


    public class ProgramaX {

        private boolean credito = true;

        public void ejecutar(){
            Thread hiloJuego = new Thread(new Juego());
            Sonido objS = new Sonido("theme.mp3");
            try {
               
                hiloJuego.start();
                
                //cargar sonido
                
                objS.play();
                
                Thread hiloTiempo = new Thread(new Tiempo(400000));
                hiloTiempo.start();
                hiloTiempo.join();
                //Thread.sleep(4000);
                
                //el tiempo termino :(
                hiloJuego.stop();
                objS.dispose();
                System.out.println("El tiempo termino.....  :(");
                System.exit(0);

            }catch(Exception e){
                e.printStackTrace();
                
            } finally{
                //hiloJuego.destroy();
                //objS.dispose();
            }
        }
        
        //inner class
        private class Tiempo extends Thread {

            private int duracion;
        
            public Tiempo (int duracion){
                 this.duracion = duracion;
            }
        
            public void run(){
                try{
                    Thread.sleep(this.duracion);
                    credito = false;
                } catch(Exception e){
                    e.printStackTrace();
                } finally {
                    credito = false;
                }   
            }
        }
    }