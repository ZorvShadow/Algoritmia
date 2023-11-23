import java.util.Arrays;
import java.util.Scanner;

public class CuentaVocales {
    public static int[] contarCaracteres(char[] cadena, int[] cuenta) {
        // vocales, signos, minusculas y mayusculas
        // 5 vocales, 1 de signos, 1 de mins, 1 de mayus
        // asignar un arreglo de 8 de largo para almacenar todo en el siguiente orden:
        // {a, e, i, o, u, signos, MAYUS, minus}

        int ultimo = cadena.length - 2;

        if (cadena[ultimo] == 'a' || cadena[ultimo] == 'A')
            cuenta[0]++;

        if (cadena[ultimo] == 'e' || cadena[ultimo] == 'E')
            cuenta[1]++;

        if (cadena[ultimo] == 'i' || cadena[ultimo] == 'I')
            cuenta[2]++;

        if (cadena[ultimo] == 'o' || cadena[ultimo] == 'O')
            cuenta[3]++;

        if (cadena[ultimo] == 'u' || cadena[ultimo] == 'U')
            cuenta[4]++;
        // si la A mayus es 65, la Z 90, la a 97 y la z 122, la ñ 164, la Ñ 165
        if (cadena[ultimo] >= 65 && cadena[ultimo] <= 90 || cadena[ultimo] == 165) {
            cuenta[6]++;
        } else if ((cadena[ultimo] >= 97 && cadena[ultimo] <= 122) || cadena[ultimo] == 164) {
            cuenta[7]++;
        }

        if ((cadena[ultimo] >= 33 && cadena[ultimo] <= 47) ||
                (cadena[ultimo] >= 58 && cadena[ultimo] <= 64) ||
                (cadena[ultimo] >= 91 && cadena[ultimo] <= 96) ||
                (cadena[ultimo] >= 123 && cadena[ultimo] <= 255) &&
                        cadena[ultimo] != 165
                        && cadena[ultimo] != 164) {
            cuenta[5]++;
        }

        // carac especiales: 33-47, 58-64, 91-96, 123-255

        char[] nuevoArr = new char[cadena.length - 1];

        for (int i = 0; i < nuevoArr.length; i++) {
            nuevoArr[i] = cadena[i];
        }

        if (nuevoArr.length > 1) {
            return contarCaracteres(nuevoArr, cuenta);
        }

        return cuenta;
    }

    public static void printChars(char[] cadena) {
        for (int i = 0; i < cadena.length; i++) {
            if (cadena[i] == 0)
                break;
            System.out.print(cadena[i]);
        }
    }

    public static char[] strToChar(String mensaje) {
        char[] finalArr = new char[mensaje.length() + 1];

        for (int i = 0; i < mensaje.length(); i++) {
            finalArr[i] = mensaje.charAt(i);
        }

        finalArr[mensaje.length()] = 0;
        return finalArr;
    }

    public static char[] readChars(char[] mensaje) {
        printChars(mensaje);
        String auxiliar = new Scanner(System.in).nextLine();
        char[] finalArr = strToChar(auxiliar);

        return finalArr;
    }

    public static void main(String[] args) {
        char[] mensaje = strToChar("Ingresa una cadena de texto: ");
        char[] cadena = readChars(mensaje);

        int[] cuenta = contarCaracteres(cadena, new int[8]);

        printChars(new char[] { 'A', ':', ' ' });
        System.out.println(cuenta[0]);

        char[] mensaje2 = { 'E', ':', ' ' };
        printChars(mensaje2);
        System.out.println(cuenta[1]);

        char[] mensaje3 = { 'I', ':', ' ' };
        printChars(mensaje3);
        System.out.println(cuenta[2]);

        char[] mensaje4 = { 'O', ':', ' ' };
        printChars(mensaje4);
        System.out.println(cuenta[3]);

        char[] mensaje5 = { 'U', ':', ' ' };
        printChars(mensaje5);
        System.out.println(cuenta[4]);

        printChars(new char[] { 'M', 'a', 'y', 'ú', 's', 'c', 'u', 'l', 'a', 's', ':', ' ' });
        System.out.println(cuenta[6]);

        printChars(new char[] { 'M', 'i', 'n', 'ú', 's', 'c', 'u', 'l', 'a', 's', ':', ' ' });
        System.out.println(cuenta[7]);

        printChars(new char[] { 'C', 'a', 'r', 'a', 'c', 't', 'e', 'r', 'e', 's', ' ', 'e', 's', 'p', 'e', 'c', 'i',
                'a', 'l', 'e', 's', ':', ' ' });
        System.out.println(cuenta[5]);

        System.out.println();
    }
}