import java.util.Arrays;
import java.util.Scanner;

public class StrToArrChars {
    /**
     * @param mensaje Cadena de texto a convertir.
     * @return Arreglo de carácteres.
     */

    public static char[] strToChar(String mensaje) {
        char[] finalArr = new char[mensaje.length() + 1];

        for (int i = 0; i < mensaje.length(); i++) {
            finalArr[i] = mensaje.charAt(i);
        }

        finalArr[mensaje.length()] = 0;
        return finalArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa una cadena a convertir: ");
        char[] cadena = strToChar(scanner.nextLine());
        String arrStr = Arrays.toString(cadena);

        System.out.println("char[] cadena = {" + arrStr.substring(1, arrStr.length() - 1) + "}");

    }
}
