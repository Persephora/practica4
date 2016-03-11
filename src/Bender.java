import java.util.Arrays;

/**
 * Created by linux on 10/03/16.
 */
class Bender {
    private final String mapa;

    public static void main(String[] args) {
        String mapa = "" +
                "#######\n" +
                "# X   #\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "# $   #\n" +
                "#     #\n" +
                "#######";
        Bender c = new Bender(mapa);
        c.Mapa(mapa);
        char[][] Mapa = c.Mapa(mapa);
        int[] posicion = c.Inicio(Mapa);
        System.out.println(Arrays.deepToString(Mapa));
        System.out.println(Arrays.toString(posicion));
    }

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        this.mapa = mapa;
    }


    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.
    public String run() {
        return "";
    }

    public char[][] Mapa(String r) {
        int Largo = r.length() / Ancho(r);
        int ancho = Ancho(r);
        r = QuitarSalto(r);
        int x = 0;
        int y = ancho;
        char[][] Mapa = new char[Largo - 1][ancho];
        for (int h = 0; h < Largo - 1; h++) {
            String Parcial = r.substring(x, y);
            for (int k = 0; k < ancho; k++) {
                Mapa[h][k] = Parcial.charAt(k);
            }
            x = y;
            y += ancho;
        }
        return Mapa;
    }

    int Ancho(String r) {
        int ancho = 0;
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '\n') {
                ancho = i;
                break;
            }
        }
        return ancho;
    }

    String QuitarSalto(String r) {
        String res = "";
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '\n') {
                continue;
            }
            res += r.charAt(i);
        }
        return res;
    }

    int[] Inicio(char[][] array) {
        int[] posicion = new int[2];
        for (int h = 0; h < array.length; h++) {
            for (int i = 0; i < array[h].length; i++) {
                if (array[h][i] == 'X') {
                    posicion[0] = h;
                    posicion[1] = i;
                    break;
                }
            }
        }
        return posicion;
    }

    String Recorrer(char[][] array) {
        String Resultado = "";
        array = Mapa(mapa);
        for (int h = 0; h < array.length; h++) {
            for (int i = 0; i < array[h].length; i++) {
                if (array[h][i] == ' ') {
                }
            }
        }
        return Resultado;
    }
}