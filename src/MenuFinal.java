import java.util.Arrays;
import java.util.Scanner;

public class MenuFinal {
    public static boolean preguntarSiNo(String mensaje, Scanner scanner) {
        System.out.print(mensaje + " (S/N)");
        char eleccion = scanner.next().toLowerCase().charAt(0);
        boolean valido = eleccion == 's' || eleccion == 'n';
        if (!valido) preguntarSiNo(mensaje, scanner);

        return eleccion == 's';
    }

    public static float sumaArr(float[] arr) {
        if (arr.length == 0) return 0;

        float suma = arr[arr.length - 1];
        float[] newArr = new float[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        return suma + sumaArr(newArr);

    }

    public static void promedios(Scanner scanner) {
        boolean activo = true;

        while (activo) {
            float sumaGeneral = 0;

            System.out.print("\nCuántas calificaciones vas a ingresar: ");
            int largo = scanner.nextInt();

            float[] califs = new float[largo];
            float[] proms = new float[8];

            for (int i = 0; i < largo; i++) {
                System.out.print("Ingresa la calificación " + (i + 1) + ": ");
                califs[i] = scanner.nextFloat();

                sumaGeneral = sumaGeneral + califs[i];

                if (califs[i] < 6)
                    proms[0]++;

                if (califs[i] > 10)
                    proms[6]++;

                for (int l = 0; l < 5; l++) {
                    if ((califs[i] <= (l + 6f)) && (califs[i] > (l + 5f))) {
                        proms[l + 1]++;
                    }
                }

            }

            System.out.println("\nEl promedio general es de: " + sumaArr(califs) / largo + "\n");

            System.out.printf("%-6s    |  %-5s\n", "Calif.", "Valor");
            System.out.println("--------- | -----");

            System.out.printf("%-6s    |  %-5s\n", "5-", (int) proms[0]);
            for (int uwu = 0; uwu < 5; uwu++) { // Se imprime la tabla final con el número de califs.
                System.out.printf("%-6s    |  %-5s\n", uwu + 6, (int) proms[uwu + 1]);
            }
            System.out.printf("-%6s    |  %-5s\n", "10+", (int) proms[6]);

            activo = preguntarSiNo("¿Desea calcular otros promedios?", scanner);
        }
    }

    public static void matrices(Scanner scanner) {
        boolean activo = true;
        while (activo) {
            printChars(new char[]{'I', 'n', 'g', 'r', 'e', 's', 'a', ' ', 'e', 'l', ' ', 't', 'a', 'm', 'a', 'ñ', 'o', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 't', 'r', 'i', 'z', ' ', 'c', 'u', 'a', 'd', 'r', 'a', 'd', 'a', ':', ' '});
            int largo = scanner.nextInt();
            int[][] matriz = new int[largo][largo];


            for (int y = 0; y < matriz.length; y++) {
                for (int x = 0; x < matriz[y].length; x++) {
                    System.out.printf("Ingrese el valor en la fila %d y columna %d: ", x + 1, y + 1);
                    matriz[y][x] = scanner.nextInt();
                    //matriz[y][x] = (int) (Math.random() * 10);
                    //System.out.println(matriz[y][x]);
                }
                System.out.println();
            }

            int[][] sumaColsFilas = sumarColsFilasMatrizBidimensional(matriz);
            int[] sumaDiags = sumarDiagonalesMatrizBidimensional(matriz);
            int[][] multiColsFilas = multiplicarColsFilasMatrizBidimensional(matriz);
            int[] multiDiags = multiplicarDiagonalesMatrizBidimensional(matriz);

            System.out.println("\nTu cuadrado es el siguiente: ");


            printMatrizBidimensional(matriz);

            printChars(new char[]{'\n', 'L', 'a', ' ', 's', 'u', 'm', 'a', ' ', 'd', 'e', ' ', 'l', 'a', 's', ' ', 'c', 'o', 'l', 'u', 'm', 'n', 'a', 's', ' ', 'e', 's', ' ', 'l', 'a', ' ', 's', 'i', 'g', 'u', 'i', 'e', 'n', 't', 'e', ':', '\n'});
            System.out.printf("%-7s %-5s\n", "Columna", "Valor");
            for (int i = 0; i < sumaColsFilas[0].length; i++) {
                System.out.printf("%-7d %-5d\n", i + 1, sumaColsFilas[0][i]);
            }

            printChars(new char[]{'\n', 'L', 'a', ' ', 's', 'u', 'm', 'a', ' ', 'd', 'e', ' ', 'l', 'a', 's', ' ', 'f', 'i', 'l', 'a', 's', ' ', 'e', 's', ' ', 'l', 'a', ' ', 's', 'i', 'g', 'u', 'i', 'e', 'n', 't', 'e', ':', '\n'});
            System.out.printf("%-4s %-5s\n", "Fila", "Valor");
            for (int i = 0; i < sumaColsFilas[1].length; i++) {
                System.out.printf("%-4d %-5d\n", i + 1, sumaColsFilas[1][i]);
            }

            printChars(new char[]{'\n', 'L', 'a', ' ', 's', 'u', 'm', 'a', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'p', 'r', 'i', 'm', 'e', 'r', 'a', ' ', 'd', 'i', 'a', 'g', 'o', 'n', 'a', 'l', ' ', 'e', 's', ' '});
            System.out.println(sumaDiags[0]);

            printChars(new char[]{'\n', 'L', 'a', ' ', 's', 'u', 'm', 'a', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 's', 'e', 'g', 'u', 'n', 'd', 'a', ' ', 'd', 'i', 'a', 'g', 'o', 'n', 'a', 'l', ' ', 'e', 's', ' '});
            System.out.println(sumaDiags[1]);

            System.out.println("Las multiplicaciones de las filas son: ");
            for (int i = 0; i < multiColsFilas[1].length; i++) {
                System.out.printf("%-4d %-5d\n", i + 1, multiColsFilas[1][i]);
            }

            System.out.println("La multiplicacion de la primera diagonal es: ");
            System.out.println(multiDiags[0]);

            System.out.println("La multiplicacion de la segunda diagonal es: ");
            System.out.println(multiDiags[1]);

            int[] indiceMayor = encontrarIndexMayor(sumaColsFilas);
            int valorMayor = sumaColsFilas[indiceMayor[0]][indiceMayor[1]];
            if (valorMayor < sumaDiags[0]) {
                valorMayor = sumaDiags[0];
                indiceMayor = new int[]{2};
            } else if (valorMayor < sumaDiags[1]) {
                valorMayor = sumaDiags[1];
                indiceMayor = new int[]{3};
            }
            if (indiceMayor.length == 1) {
                System.out.printf("La suma mayor es la de la diagonal %d", indiceMayor[0] - 1);
            } else {
                switch (indiceMayor[0]) {
                    case 0:
                        System.out.printf("La suma mayor está en la fila %d", indiceMayor[1] + 1);
                        break;
                    case 1:

                        System.out.printf("La suma mayor está en la columna %d", indiceMayor[1] + 1);
                        break;
                }
            }
            System.out.printf(" con un valor de %d.\n", valorMayor);
            activo = preguntarSiNo("¿Desea calcular otra matriz?", scanner);
        }
    }

    public static void caracteres(Scanner scanner) {
        boolean activo = true;
        while (activo) {
            char[] cadena = readChars(new char[]{'I', 'n', 'g', 'r', 'e', 's', 'a', ' ', 'u', 'n', 'a', ' ', 'c', 'a', 'd', 'e', 'n', 'a', ' ', 'd', 'e', ' ', 't', 'e', 'x', 't', 'o', ':', ' '}, scanner);

            int[] cuenta = contarCaracteres(cadena);

            printChars(new char[]{'A', ':', ' '});
            System.out.println(cuenta[0]);

            printChars(new char[]{'E', ':', ' '});
            System.out.println(cuenta[1]);

            printChars(new char[]{'I', ':', ' '});
            System.out.println(cuenta[2]);

            printChars(new char[]{'O', ':', ' '});
            System.out.println(cuenta[3]);

            printChars(new char[]{'U', ':', ' '});
            System.out.println(cuenta[4]);

            printChars(new char[]{'M', 'a', 'y', 'ú', 's', 'c', 'u', 'l', 'a', 's', ':', ' '});
            System.out.println(cuenta[6]);

            printChars(new char[]{'M', 'i', 'n', 'ú', 's', 'c', 'u', 'l', 'a', 's', ':', ' '});
            System.out.println(cuenta[7]);

            printChars(new char[]{'C', 'a', 'r', 'a', 'c', 't', 'e', 'r', 'e', 's', ' ', 'e', 's', 'p', 'e', 'c', 'i',
                    'a', 'l', 'e', 's', ':', ' '});
            System.out.println(cuenta[5]);

            activo = preguntarSiNo("Desea introducir más frases? ", scanner);
        }
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

    public static char[] readChars(char[] mensaje, Scanner scanner) {
        printChars(mensaje);
        String auxiliar = scanner.nextLine();
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

    public static int[] encontrarIndexMayor(int[][] matriz) {
        int max = Integer.MIN_VALUE; // Una constante proporcionada por Java para que funcione con cualquier numero
        int[] index = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > max) {
                    max = matriz[i][j];

                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }

    public static void printMatrizBidimensional(int[][] matriz) {
        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.printf(" %-3d ", matriz[y][x]);
            }
            System.out.println();
        }
    }

    public static int[][] sumarColsFilasMatrizBidimensional(int[][] matriz) {
        int[] sumaCols = new int[matriz[0].length];
        int[] sumaFilas = new int[matriz.length];

        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                sumaCols[x] += matriz[y][x];
                sumaFilas[y] += matriz[y][x];
            }

        }

        return new int[][]{sumaCols, sumaFilas};
    }

    public static int[] sumarDiagonalesMatrizBidimensional(int[][] matriz) {
        int[] sumaDiags = new int[2];
        sumaDiags[0] += matriz[matriz.length - 1][matriz[0].length - 1];

        for (int i = 0; i < matriz.length; i++) {
            sumaDiags[1] += matriz[i][matriz.length - 1 - i];
        }

        int[][] nuevoArr = new int[matriz.length - 1][matriz[0].length - 1];

        for (int y = 0; y < nuevoArr.length; y++) {
            for (int x = 0; x < nuevoArr[y].length; x++) {
                nuevoArr[y][x] = matriz[y][x];
            }
        }
        if (nuevoArr.length != 0) {
            sumaDiags[0] += sumarDiagonalesMatrizBidimensional(nuevoArr)[0];
        }

        return sumaDiags;
    }

    public static int[][] multiplicarColsFilasMatrizBidimensional(int[][] matriz) {
        int[] multiCols = new int[matriz[0].length];
        int[] multiFilas = new int[matriz.length];
        Arrays.fill(multiCols, 1);
        Arrays.fill(multiFilas, 1);

        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                multiCols[x] *= matriz[y][x];
                multiFilas[y] *= matriz[y][x];
            }

        }

        return new int[][]{multiCols, multiFilas};
    }

    public static int[] multiplicarDiagonalesMatrizBidimensional(int[][] matriz) {
        int[] multiDiags = new int[]{1, 1};
        multiDiags[0] *= matriz[matriz.length - 1][matriz[0].length - 1];
        System.out.println("Arrays.toString(multiDiags) = " + Arrays.toString(multiDiags));

        for (int i = 0; i < matriz.length; i++) {
            multiDiags[1] *= matriz[i][matriz.length - 1 - i];
            multiDiags[0] *= matriz[i][i];
        }
        return multiDiags;
    }

    public static void main(String[] args) {
        boolean activo = true;
        while (activo) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenido al menú");
            System.out.println("1. Suma de matrices.");
            System.out.println("2. Promedios de calificaciones.");
            System.out.println("3. Contar caracteres.");
            System.out.println("4. Salir.");
            System.out.print("Ingresa la opción: ");

            int eleccion = scanner.nextInt();
            switch (eleccion) {
                case 1:
                    matrices(scanner);
                    break;
                case 2:
                    promedios(scanner);
                    break;
                case 3:
                    caracteres(scanner);
                    break;
                case 4:
                    activo = false;
                    break;
            }
        }
    }
}
