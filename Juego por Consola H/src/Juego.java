import javax.swing.*;
import java.io.IOException;

public class Juego {
    // Main del Juego.
    public static void main(String[] args) {
        SonidoMp3 sonidoMp3 = new SonidoMp3();
        try {
            sonidoMp3.SonidoMp3();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Executor.printGame();
    }
    /**
         SonidoMp3 sonidoMp3 = new SonidoMp3();
        try {
        sonidoMp3.SonidoMp3();
        } catch (IOException e) {
        e.printStackTrace();
        }
     */
    /**
     * // Main del Juego.
     *     public static void main(String[] args) {
     *         boolean condition = true;
     *         Executor executor = new Executor("Proceso 1");
     *         SonidoMp3 sonidoMp3 = new SonidoMp3("Proceso 2a");
     *         SonidoWav sonidoWav = new SonidoWav("Proceso 2b");
     *
     *         while (condition == true) {
     *             String conditionS = JOptionPane.showInputDialog("¿Qué tipo de dato es su canción?");
     *             if (conditionS.equalsIgnoreCase("mp3")) {
     *                 try {
     *                     sonidoMp3.SonidoMp3();
     *                     executor.run();
     *                     condition = false;
     *                 } catch (IOException e) {
     *                     e.printStackTrace();
     *                 }
     *             }
     *             if (conditionS.equalsIgnoreCase("wav")){
     *                 sonidoWav.start();
     *                 executor.run();
     *                 condition = false;
     *             }
     *         }
     *         //Executor.printGame();
     *     }
     */
}