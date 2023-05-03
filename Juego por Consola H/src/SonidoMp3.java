import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.*;

public class SonidoMp3{

    public void SonidoMp3() throws FileNotFoundException, IOException {
        try {
            FileInputStream direction;
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                direction = new FileInputStream(file.getAbsolutePath());
                Player player;
                BufferedInputStream bufferedInputStream = new BufferedInputStream(direction);
                player = new Player(bufferedInputStream);
                player.play();
            } else {
                JOptionPane.showMessageDialog(null, "\nNo se ha seleccionado ningún archivo válido");
            }

        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*public class SonidoMp3 extends Thread {

    //metodos

    public SonidoMp3(String str){
        super(str);
    }

    public void SonidoMp3() throws FileNotFoundException, IOException {
        try {
            FileInputStream direction;
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                direction = new FileInputStream(file.getAbsolutePath());
                Player player;
                BufferedInputStream bufferedInputStream = new BufferedInputStream(direction);
                player = new Player(bufferedInputStream);
                player.play();
            } else {
                JOptionPane.showMessageDialog(null, "\nNo se ha seleccionado ningún archivo válido");
            }

        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    */
}
