import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sun.audio.*;
import java.io.*;

public class SonidoWav {
    //metodos

    public static void Sonidowav()throws FileNotFoundException, IOException{

        FileInputStream direction;
        JFileChooser fileChooser=new JFileChooser();
        if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            direction = new FileInputStream(file.getAbsolutePath());
            AudioStream audioStream = new AudioStream(direction);
            AudioPlayer.player.start(audioStream);
            //JOptionPane.showMessageDialog(null, "STOP?");
            //AudioPlayer.player.stop(audioStream);
        }else {
            JOptionPane.showMessageDialog(null, "\nNo se ha seleccionado ningún archivo válido");
        }
    }
    /**
     *
     public class SonidoWav extends Thread{
     //metodos
     public SonidoWav(String str){
     super(str);
     }

     public static void Sonidowav()throws FileNotFoundException, IOException{

     FileInputStream direction;
     JFileChooser fileChooser=new JFileChooser();
     if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
     File file = fileChooser.getSelectedFile();
     direction = new FileInputStream(file.getAbsolutePath());
     AudioStream audioStream = new AudioStream(direction);
     AudioPlayer.player.start(audioStream);
     //JOptionPane.showMessageDialog(null, "STOP?");
     //AudioPlayer.player.stop(audioStream);
     }else {
     JOptionPane.showMessageDialog(null, "\nNo se ha seleccionado ningún archivo válido");
     }
     }
     */
}
