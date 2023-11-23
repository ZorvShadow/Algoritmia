import java.util.Scanner;

public class CuentaVocales {
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
        return strToChar(auxiliar);
    }

    public static int[] contarCaracteres(char[] cadena) {
        // vocales, signos, minusculas y mayusculas
        // 5 vocales, 1 de signos, 1 de mins, 1 de mayus
        // asignar un arreglo de 8 de largo para almacenar todo en el siguiente orden:
        // {a, e, i, o, u, signos, MAYUS, minus}

        int[] cuenta = new int[8];

        char ultimo = cadena[cadena.length - 2];

        if (ultimo == 'a' || ultimo == 'A')
            cuenta[0]++;

        if (ultimo == 'e' || ultimo == 'E')
            cuenta[1]++;

        if (ultimo == 'i' || ultimo == 'I')
            cuenta[2]++;

        if (ultimo == 'o' || ultimo == 'O')
            cuenta[3]++;

        if (ultimo == 'u' || ultimo == 'U')
            cuenta[4]++;
        // si la A mayus es 65, la Z 90, la a 97 y la z 122, la ñ 164, la Ñ 165
        if (ultimo >= 65 && ultimo <= 90 || ultimo == 165) {
            cuenta[6]++;
        } else if ((ultimo >= 97 && ultimo <= 122) || ultimo == 164) {
            cuenta[7]++;
        }

        if ((ultimo >= 33 && ultimo <= 47) ||
                (ultimo >= 58 && ultimo <= 64) ||
                (ultimo >= 91 && ultimo <= 96) ||
                (ultimo >= 123 && ultimo <= 255) &&
                        ultimo != 165
                        && ultimo != 164) {
            cuenta[5]++;
        }

        // carac especiales: 33-47, 58-64, 91-96, 123-255

        char[] nuevoArr = new char[cadena.length - 1];

        for (int i = 0; i < nuevoArr.length; i++) {
            nuevoArr[i] = cadena[i];
        }

        if (nuevoArr.length > 1) {
            int[] cuentaNueva = contarCaracteres(nuevoArr);
            for (int i = 0; i < cuenta.length; i++) {
                cuenta[i] += cuentaNueva[i];
            }
        }

        return cuenta;
    }



    public static void main(String[] args) {
        char[] cadena = readChars(new char[]{'I', 'n', 'g', 'r', 'e', 's', 'a', ' ', 'u', 'n', 'a', ' ', 'c', 'a', 'd', 'e', 'n', 'a', ' ', 'd', 'e', ' ', 't', 'e', 'x', 't', 'o', ':', ' '});

        int[] cuenta = contarCaracteres(cadena);

        printChars(new char[] { 'A', ':', ' ' });
        System.out.println(cuenta[0]);

        printChars(new char[]{ 'E', ':', ' ' });
        System.out.println(cuenta[1]);

        printChars(new char[]{ 'I', ':', ' ' });
        System.out.println(cuenta[2]);

        printChars(new char[] { 'O', ':', ' ' });
        System.out.println(cuenta[3]);

        printChars(new char[]{ 'U', ':', ' ' });
        System.out.println(cuenta[4]);

        printChars(new char[] { 'M', 'a', 'y', 'ú', 's', 'c', 'u', 'l', 'a', 's', ':', ' ' });
        System.out.println(cuenta[6]);

        printChars(new char[] { 'M', 'i', 'n', 'ú', 's', 'c', 'u', 'l', 'a', 's', ':', ' ' });
        System.out.println(cuenta[7]);

        printChars(new char[] { 'C', 'a', 'r', 'a', 'c', 't', 'e', 'r', 'e', 's', ' ', 'e', 's', 'p', 'e', 'c', 'i',
                'a', 'l', 'e', 's', ':', ' ' });
        System.out.println(cuenta[5]);

    }
}