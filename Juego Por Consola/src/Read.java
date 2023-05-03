import java.util.Scanner;

public class Read {

    // Metodos
    public static int leerNumero(String mensaje){
        Scanner entry = new Scanner (System.in);
        System.out.print(mensaje);
        return entry.nextInt();
    }

    public static String leerTexto(String mensaje){
        Scanner entry = new Scanner (System.in);
        System.out.print(mensaje);
        return entry.nextLine();
    }

    public static double leerFlotante(String mensaje){
        Scanner entry = new Scanner (System.in);
        System.out.print(mensaje);
        return entry.nextDouble();
    }
}