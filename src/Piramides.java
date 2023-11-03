import java.util.Scanner;

// Basado en el trabajo por Hakeem 🤓👆
public class Piramides {

    private static final char caracterRelleno = '*';

    public static void printArrsDobles(char[][] arr, boolean invertirY, boolean invertirX) {
        if (arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {

            int indexY = invertirY ? arr.length - 1 - i : i;

            for (int j = 0; j < arr[i].length; j++) {
                int indexX = invertirX ? arr[indexY].length - 1 - j : j;

                char caracter = arr[indexY][indexX];
                if (caracter == 0) caracter = ' ';
                System.out.print(caracter);
            }
            System.out.println();
        }
    }

    public static char[][] generarPiramideRectangulo(int size, boolean relleno) {
        if (size < 0) return null;

        char[][] arr = new char[size][size];

        // Piramide
        for (int i = 0; i < arr.length; i++) {
            int caracteres = arr[i].length - i;
            for (int j = 0; j < caracteres; j++) {
                /*  El primero checa si es el ultimo
                    El segundo checa si es la ultima fila
                    El tercero checa si es la primera columna
                    Por ultimo se checa si era relleno
                 */
                arr[i][j] = caracteres - 1 == j || j == 0 || i == 0 || relleno ? caracterRelleno : 0;
            }
        }
        return arr;
    }

    public static char[][] generarTrianguloCentrado(int size, boolean relleno) {
        if (size < 0) return null;

        int horizontal = size * 2 + 1;
        char[][] arr = new char[size][horizontal];

        // Se crea el triangulo
        for (int i = 0; i < size; i++) {
            int espacio = horizontal / 2 - i - 1; // Se calcula los espacios a dejar a la izquierda
            int caracteres = i * 2 + 1; // Se obtiene el número de caracteres a escribir, dado por la serie 2n + 1

            for (int j = 0; j < caracteres; j++) {
                arr[i][j + espacio] = j == 0 || j == caracteres - 1 || i == size - 1 || relleno ? caracterRelleno : 0;
            }
        }

        return arr;
    }

    public static char[][] rotarArrBidimensional(char[][] arr, boolean izquierda) {
        // Primero se tiene que intercambiar el ancho y el alto, por lo que obtenemos los dos.
        int alto = arr.length;
        int ancho = arr[0].length; // Se utiliza el del primer array.

        // Se crea el nuevo array
        char[][] nuevoArr = new char[ancho][alto];
        for (int i = 0; i < nuevoArr.length; i++) {

            for (int j = 0; j < nuevoArr[i].length; j++) {
                int index = izquierda ? nuevoArr[i].length - j - 1 : j;
                nuevoArr[i][index] = arr[j][i];
            }
        }
        return nuevoArr;
    }

    public static char[][] generarRectangulo(int ancho, int alto) {
        if (ancho < 0 || alto < 0) return null;

        char[][] arr = new char[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                arr[i][j] = caracterRelleno;
            }
        }

        return arr;
    }

    public static char[][] generarPiramidePalabra(String palabra) {
        if (palabra.isBlank()) return null;

        int size = palabra.length();
        int horizontal = size * 2 + 1;
        char[][] arr = new char[size][horizontal];

        // Se crea el triangulo
        for (int i = 0; i < size; i++) {
            int espacio = horizontal / 2 - i - 1; // Se calcula los espacios a dejar a la izquierda
            int caracteres = i * 2 + 1; // Se obtiene el número de caracteres a escribir, dado por la serie 2n + 1

            for (int j = 0; j < caracteres; j++) {
                arr[i][j + espacio] = j % 2 == 0 ? palabra.charAt(j/2) : ' ';
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\n\n");
            System.out.print("Bienvenido al menú \n");
            System.out.print("  1.  Piramide hacia la izquierda\n");
            System.out.print("  2.  Piramide hacia la derecha\n");
            System.out.print("  3.  Piramide invertida hacia la izquierda\n");
            System.out.print("  4.  Piramide invertida hacia la derecha\n");
            System.out.print("  5.  Piramide vacía hacia la izquierda\n");
            System.out.print("  6.  Piramide vacía hacia la derecha\n");
            System.out.print("  7.  Piramide vacía invertida hacia la izquierda\n");
            System.out.print("  8.  Piramide vacía invertida hacia la derecha\n");
            System.out.print("  9.  Triangulo centrado\n");
            System.out.print("  10. Triangulo centrado vacío\n");
            System.out.print("  11. Triangulo centrado invertido\n");
            System.out.print("  12. Triangulo centrado invertido vacío\n");
            System.out.print("  13. Triangulo con su base pegada a la izquierda\n");
            System.out.print("  14. Triangulo con su base pegada a la derecha\n");
            System.out.print("  15. Triangulo vacío con su base pegada a la izquierda\n");
            System.out.print("  16. Triangulo vacío con su base pegada a la derecha\n");
            System.out.print("  17. Rombo\n");
            System.out.print("  18. Cuadrado\n");
            System.out.print("  19. Rectángulo\n");
            System.out.print("  20. Palabra a pirámide\n");
            System.out.print("  21. Salir\n");

            System.out.print("Elige una opción: ");

            int eleccion = scanner.nextInt();
            char[][] arr = new char[0][0];

            if (eleccion > 0 && eleccion < 19) System.out.print("¿De qué tamaño deseas la figura? ");

            if (eleccion > 0 && eleccion <= 8) { // 1-8
                arr = generarPiramideRectangulo(scanner.nextInt(), 4 > eleccion);
            } else if (eleccion >= 9 && eleccion <= 17) { // 9-17
                arr = generarTrianguloCentrado(scanner.nextInt(), eleccion != 10 && eleccion != 12 && eleccion != 15 && eleccion != 16);
                if (eleccion >= 13) arr = rotarArrBidimensional(arr, eleccion == 13 || eleccion == 15);
            } else if (eleccion == 18) {
                int size = scanner.nextInt();
                arr = generarRectangulo(size, size);
            } else if (eleccion == 19) {
                System.out.print("¿De qué alto deseas el rectángulo? ");
                int alto = scanner.nextInt();
                System.out.print("¿De qué ancho deseas el rectángulo? ");
                int ancho = scanner.nextInt();
                arr = generarRectangulo(ancho, alto);
            } else if (eleccion == 20) {
                System.out.print("Introduce tu palabra: ");
                arr = generarPiramidePalabra(scanner.next());
            }

            switch (eleccion) {
                case 1, 5, 11, 12:
                    printArrsDobles(arr, true, false);
                    break;
                case 2, 6:
                    printArrsDobles(arr, true, true);
                    break;
                case 3, 7, 9, 10, 13, 14, 15, 16, 18, 19, 20:
                    printArrsDobles(arr, false, false);
                    break;
                case 4, 8:
                    printArrsDobles(arr, false, true);
                    break;
                case 17:
                    printArrsDobles(arr, false, false);
                    printArrsDobles(arr, true, false);
                    break;
                case 21:
                    return;
            }
        }
    }
}