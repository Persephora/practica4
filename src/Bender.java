import java.util.Arrays;

/**
 * Created by linux on 10/03/16.
 */
class Bender {
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
        int[][] Inicio = c.Inicio(Mapa);
        System.out.println(Arrays.deepToString(Mapa));
        System.out.println(Arrays.deepToString(Inicio));
    }

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
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

    int[][] Inicio(char[][] array) {
        return null;
    }
}

