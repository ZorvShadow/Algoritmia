import java.util.Arrays;
import java.util.Scanner;

public class StrToArrChars {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa una cadena a convertir: ");
            char[] cadena = (scanner.nextLine().toCharArray());

            String[] cadenaComas = new String[cadena.length];
            for (int i = 0; i < cadena.length; i++) {
                cadenaComas[i] = "'" + cadena[i] + "'";
            }

            String arrStr = Arrays.toString(cadenaComas);

            System.out.println("char[] cadena = new char[]{" + arrStr.substring(1, arrStr.length() - 1) + "};");

            System.out.print("Desea ingresar otro? (s/n) ");

            if (scanner.next().toLowerCase().charAt(0) != 's') break;
        }
    }
}
