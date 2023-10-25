import java.util.Scanner;

public class Calificaciones {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        float sumaGeneral = 0;

        System.out.print("Cuántas calificaciones vas a ingresar: ");
        int largo = leer.nextInt();

        float[] califs = new float[largo];
        float[] proms = new float[7];

        for (int i = 0; i < largo; i++) {
            System.out.print("Ingresa la calificación " + (i + 1) + ": ");
            califs[i] = leer.nextFloat();

            sumaGeneral = sumaGeneral + califs[i];

            if (califs[i] < 6)
                proms[0] = proms[0] + 1;

            for (int l = 0; l < 5; l++) {
                if ((califs[i] <= (l + 6f)) && (califs[i] > (l + 5f))) {
                    proms[l + 1] = proms[l + 1] + 1;
                }
            }
        }

        proms[6] = sumaGeneral / (float) largo;

        System.out.println("\nEl promedio general es de: " + proms[6] + "\n");

        System.out.println(" Calif  |  Núm");
        System.out.println("------- | -----");

        for (int uwu = 0; uwu < 6; uwu++) { // Se imprime la tabla final con el número de califs.
            System.out.printf("%4s    |  %2s\n", uwu + 5, (int) proms[uwu]);
        }

    }

}
