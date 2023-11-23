import java.util.Scanner;

public class Calificaciones {

    public static float sumaArr(float[] arr) {
        if (arr.length == 0) return 0;

        float suma = arr[arr.length - 1];
        float[] newArr = new float[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        return suma + sumaArr(newArr);

    }


    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        float sumaGeneral = 0;

        System.out.print("Cuántas calificaciones vas a ingresar: ");
        int largo = leer.nextInt();

        float[] califs = new float[largo];
        float[] proms = new float[8];

        for (int i = 0; i < largo; i++) {
            System.out.print("Ingresa la calificación " + (i + 1) + ": ");
            califs[i] = leer.nextFloat();

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

    }

}
