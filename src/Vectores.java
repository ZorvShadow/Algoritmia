import java.util.Scanner;

public class Vectores {
    public static float productoPunto(float[] vector1, float[] vector2) {
        float resultado = 0;
        for (int i = 0; i < 3; i++) {
            resultado += vector1[i] * vector2[i];
        }
        return resultado;
    }

    public static float[] productoCruz(float[] vector1, float[] vector2) {
        float[] resultado = new float[3];
        resultado[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        resultado[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        resultado[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            float[] vector1 = new float[3];
            float[] vector2 = new float[3];

            // Solicitar input del usuario para el vector1
            System.out.println("Ingrese las componentes del primer vector:");
            for (int i = 0; i < 3; i++) {
                System.out.print("Componente " + (i + 1) + ": ");
                vector1[i] = scanner.nextFloat();
            }

            // Solicitar input del usuario para el vector2
            System.out.println("Ingrese las componentes del segundo vector:");
            for (int i = 0; i < 3; i++) {
                System.out.print("Componente " + (i + 1) + ": ");
                vector2[i] = scanner.nextFloat();
            }

            // Calcular y mostrar el producto punto
            float productoPuntoResultado = productoPunto(vector1, vector2);
            System.out.println("Producto Punto: " + productoPuntoResultado);

            // Calcular y mostrar el producto cruz
            float[] productoCruzResultado = productoCruz(vector1, vector2);
            System.out.println("Producto Cruz: " + productoCruzResultado[0] + "i, " + productoCruzResultado[1] + "j, " + productoCruzResultado[2] + "k");

            System.out.print("Desea continuar? (S/N) ");
        } while (scanner.next().charAt(0) == 's');
        // Cerrar el scanner
        scanner.close();
    }
}
