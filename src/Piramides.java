import java.util.Scanner;
public class Piramides {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("¿De qué tamaño deseas las piramides? ");
            int size = scanner.nextInt() + 1;

            // Piramide 1
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print('*');
                }
                System.out.println();
            }
            System.out.println();

            // Piramide 2
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < (size - i - 1); j++) {
                    System.out.print('*');
                }
                System.out.println();
            }

            System.out.print("¿Deseas crear otra piramide? (S/N) ");
            char respuesta = scanner.next().toLowerCase().charAt(0);

            if (respuesta != 's') break;
        }



    }
}
