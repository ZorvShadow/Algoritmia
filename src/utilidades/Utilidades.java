package utilidades;

public class Utilidades {
    public static String generarRandomString(int largo) {
        String cadena = "";
        // 65 - 90 mayus
        for (int i = 0; i < largo; i++) {
            boolean mayus = Math.random() < 0.5 || i == 0;
            char caracter = (char) (Math.random() * 25 + 65);
            String nueva = "" + caracter;
            if (!mayus) nueva = nueva.toLowerCase();
            cadena += nueva;
        }
        return cadena;
    }
}
