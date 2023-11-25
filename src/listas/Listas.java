package listas;

import java.util.Scanner;

/**
 * @author García Espino Enrique Román
 * @version 0.0.1
 */
public class Listas {
    private static String[] conciertos = {"Concierto 1", "Concierto 2", "Concierto 3", "Concierto 4", "Concierto 5"};
    private static Boleto[] boletos = new Boleto[conciertos.length];

    /**
     * @param mensaje Mensaje a mostrar, se le concatenará un " (S/N)" al final
     * @param scanner Objeto scanner
     * @return El valor de la respuesta
     */
    public static boolean preguntarSiNo(String mensaje, Scanner scanner) {
        boolean valido = false;
        boolean eleccion = false;

        while (!valido) {
            System.out.print(mensaje + " (S/N) ");
            String respuesta = scanner.next().toLowerCase();
            eleccion = respuesta.charAt(0) == 's';

            valido = (eleccion || respuesta.charAt(0) == 'n') && respuesta.length() == 1;

            if (!valido) System.out.println("Respuesta inválida!!");


        }

        return eleccion;
    }

    public static int inputIntValido(int min, int max, String mensaje, Scanner scanner) {
        boolean valido = false;
        int num = min - 1;
        while (!valido) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                valido = num <= max && num >= min;

                if (!valido) System.out.println("Respuesta inválida!!");
            } else {
                scanner.next();
                System.out.println("Ingresa un número entero.");
            }

        }

        return num;

    }

    /**
     * @param cadena Arreglo de carácteres a convertir a Cadena de texto.
     * @return Cadena de texto resultante.
     */
    private static String charArrToString(char[] cadena) {
        if (cadena == null) return null;
        if (cadena.length == 0) return "";

        String nuevo = "";
        for (int i = 0; i < cadena.length; i++) {
            nuevo = nuevo + cadena[i];
        }
        return nuevo;
    }

    /**
     * @param boleto Boleto base o inicial
     */
    private static void printBoletos(Boleto boleto) {
        if (boleto == null) return;
        if (boleto.getNombreBoleto() == null) return;

        Boleto aux = boleto;
        System.out.printf("%-5s | %-20s\n", "Núm", "Nombre");
        System.out.println("----------------");
        while (aux != null) {
            System.out.printf("%-5d | %-20s\n", aux.getNumeroBoleto(), charArrToString(aux.getNombreBoleto()));
            aux = aux.getSiguiente();
        }

    }

    /**
     * @param inicial Boleto inicial o base.
     * @return Boleto final, sin siguiente.
     */
    private static Boleto getLastElement(Boleto inicial) {
        if (inicial == null) return null;
        if (inicial.getNombreBoleto() == null) return null;
        if (inicial.getSiguiente() == null) return inicial;
        Boleto aux = inicial;

        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente() != null) aux = aux.getSiguiente();
        }
        return aux;

    }

    /**
     * @param inicial Boleto inicial o base
     * @param nombre  Nombre de la persona del boleto
     */
    private static void addBoleto(Boleto inicial, char[] nombre) {
        if (inicial == null) return;

        Boleto ultimo = getLastElement(inicial);

        if (ultimo == null) {
            inicial.setNombreBoleto(nombre);
            inicial.setNumeroBoleto(1);
            inicial.setSiguiente(null);
            return;
        }

        Boleto adicion = new Boleto();

        adicion.setNumeroBoleto(ultimo.getNumeroBoleto() + 1);
        adicion.setNombreBoleto(nombre);

        ultimo.setSiguiente(adicion);

    }

    public static void main(String[] args) {
        /*Menu
        1. Comprar boletos
            1.1. Preguntar por 5 conciertos posibles.
                 Preguntar cuantos boletos
                 Preguntar nombres
        2. Desplegar boletos comprados
            2.1  Preguntar por el concierto a desplegar.
                 Desplegar los boletos
                 Desplegar total de boletos y total de dinero.
        3. Salir


        Notas:
            Hacer 5 listas diferentes, 1 para cada concierto.
        */
        // Inicializar boletos

        for (int i = 0; i < boletos.length; i++) {
            boletos[i] = new Boleto();
        }

        Scanner scanner = new Scanner(System.in);
        boolean activo = true;

        while (activo) {
            System.out.println("          Menú Principal");
            System.out.println("  1. Comprar boletos.");
            System.out.println("  2. Desplegar boletos comprados.");
            System.out.println("  3. Salir");

            int eleccion = inputIntValido(1, 3, "Ingrese el menú deseado: ", scanner);
            switch (eleccion) {
                case 1:
                    subComprar(scanner);
                    break;
                case 2:
                    subDesplegar(scanner);
                    break;
                case 3:
                    System.out.println("Adios...");
                    activo = false;
                    break;
                default:
                    break;
            }
        }

    }

    // Inician submenús
    public static void subComprar(Scanner scanner) {
        boolean activo = true;
        while (activo) {
            System.out.println("Los conciertos disponibles son: ");
            for (int i = 0; i < conciertos.length; i++) {
                System.out.printf("%-2d. %s\n", i + 1, conciertos[i]);
            }

            int conciertoSeleccionado = inputIntValido(1, conciertos.length, "¿Qué número de concierto desea? ", scanner) - 1;
            int cantidadBoletos = inputIntValido(1, Integer.MAX_VALUE, "¿Cuántos boletos desea? ", scanner);

            for (int i = 0; i < cantidadBoletos; i++) {
                System.out.printf("Ingresa el nombre boleto %d: ", i + 1);
                char[] nombre = scanner.next().toCharArray();
                addBoleto(boletos[conciertoSeleccionado], nombre);
            }

            activo = preguntarSiNo("¿Desea comprar más boletos?", scanner);
        }
    }

    public static void subDesplegar(Scanner scanner) {
        boolean activo = true;
        while (activo) {
            System.out.println("Los conciertos disponibles para desplegar son: ");
            for (int i = 0; i < conciertos.length; i++) {
                System.out.printf("%-2d. %s\n", i + 1, conciertos[i]);
            }

            int conciertoSeleccionado = inputIntValido(1, conciertos.length, "¿Qué número de concierto desea? ", scanner) - 1;
            Boleto boleto = boletos[conciertoSeleccionado];
            if (boleto.getNombreBoleto() == null) System.out.println("No hay boletos comprados en este concierto ");
            else printBoletos(boleto);

            activo = preguntarSiNo("¿Desea desplegar otro concierto?", scanner);
        }
    }

}
