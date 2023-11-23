import java.util.Scanner;

public class Cuadrado {
    public static double raizNewton(double numero, double x) {
        if (x < 0) return -1d;
        double fx = x * x - numero;
        double devFx = 2*x;
        double x1 = x - (fx/devFx);
        System.out.print("Intento: " + x1 + "\n");
        double dif = Math.abs(x1 - x);
        if (dif < 0.0000000000001) {
            return x1;
        } else {
            return raizNewton(numero, x1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Qué raíz cuadrada deseas calcular? ");
        double num = scanner.nextDouble();

        System.out.print(raizNewton(num, num/2));
    }
}
