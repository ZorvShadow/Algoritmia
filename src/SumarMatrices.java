import java.util.Scanner;

public class SumarMatrices {
    public static void printChars(char[] cadena) {
        for (int i = 0; i < cadena.length; i++) {
            if (cadena[i] == 0)
                break;
            System.out.print(cadena[i]);
        }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printChars(new char[]{'I', 'n', 'g', 'r', 'e', 's', 'a', ' ', 'e', 'l', ' ', 't', 'a', 'm', 'a', 'ñ', 'o', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 't', 'r', 'i', 'z', ' ', 'c', 'u', 'a', 'd', 'r', 'a', 'd', 'a', ':', ' '});
        int largo = scanner.nextInt();
        int[][] matriz = new int[largo][largo];


        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.printf("Ingrese el valor en posición (%2d, %-2d): ", x, y);
                //matriz[y][x] = scanner.nextInt();
                matriz[y][x] = (int) (Math.random() * 10);
                System.out.println(matriz[y][x]);
            }
        }

        int[][] sumaColsFilas = sumarColsFilasMatrizBidimensional(matriz);
        int[] sumaDiags = sumarDiagonalesMatrizBidimensional(matriz);

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


    }
}
