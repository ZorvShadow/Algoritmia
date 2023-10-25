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
        char[] finalArr = strToChar(auxiliar);

        return finalArr;
    }

    public static void main(String[] args) {
        char[] mensaje = strToChar("Ingresa una cadena de texto: ");
        char[] cadena = readChars(mensaje);

        int numA = 0;
        int numE = 0;
        int numI = 0;
        int numO = 0;
        int numU = 0;
        int numComas = 0;
        int numPuntos = 0;
        int numEspacios = 0;

        for (int i = 0; i < cadena.length; i++) {
            if (cadena[i] == 'a' || cadena[i] == 'A')
                numA++;

            if (cadena[i] == 'e' || cadena[i] == 'E')
                numE++;

            if (cadena[i] == 'i' || cadena[i] == 'I')
                numI++;

            if (cadena[i] == 'o' || cadena[i] == 'O')
                numO++;

            if (cadena[i] == 'u' || cadena[i] == 'U')
                numU++;

            if (cadena[i] == ' ')
                numEspacios++;

            if (cadena[i] == '.')
                numPuntos++;

            if (cadena[i] == ',')
                numComas++;
        }

        char[] mensaje1 = { 'A', ':', ' ' };
        printChars(mensaje1);
        printChars(strToChar(numA + ""));
        System.out.println();

        char[] mensaje2 = { 'E', ':', ' ' };
        printChars(mensaje2);
        printChars(strToChar(numE + ""));
        System.out.println();

        char[] mensaje3 = { 'I', ':', ' ' };
        printChars(mensaje3);
        printChars(strToChar(numI + ""));
        System.out.println();

        char[] mensaje4 = { 'O', ':', ' ' };
        printChars(mensaje4);
        printChars(strToChar(numO + ""));
        System.out.println();

        char[] mensaje5 = { 'U', ':', ' ' };
        printChars(mensaje5);
        printChars(strToChar(numU + ""));
        System.out.println();

        char[] mensaje6 = { 'E','s','p','a','c','i','o','s', ':', ' ' };
        printChars(mensaje6);
        printChars(strToChar(numEspacios + ""));
        System.out.println();

        char[] mensaje7 = { 'C','o','m','a','s', ':', ' ' };
        printChars(mensaje7);
        printChars(strToChar(numComas + ""));
        System.out.println();

        char[] mensaje8 = { 'P','u','n','t','o','s', ':', ' ' };
        printChars(mensaje8);
        printChars(strToChar(numPuntos + ""));
        System.out.println();

        System.out.println();
    }
}