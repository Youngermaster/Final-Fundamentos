import java.util.Scanner;

public class Teclado {
    //atributos

    //metodos
    public static int leerNumero(String mensaje){
        Scanner teclado = new Scanner (System.in);
        System.out.print(mensaje);
        return teclado.nextInt();
    }

    public static String leerTexto(String mensaje){
        Scanner teclado = new Scanner (System.in);
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    public static double leerFlotante(String mensaje){
        Scanner teclado = new Scanner (System.in);
        System.out.print(mensaje);
        return teclado.nextDouble();
    }
}