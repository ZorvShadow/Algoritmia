import java.util.Scanner;

public class Cuadro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("¿De qué tamaño deseas el cuadrado? ");
            int size = scanner.nextInt();

            // Piramide 1
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print('*');
                }
                System.out.println();
            }

            System.out.print("\n¿Deseas crear otro cuadrado? (S/N) ");
            char respuesta = scanner.next().toLowerCase().charAt(0);

            if (respuesta != 's') break;
        }



    }
}
