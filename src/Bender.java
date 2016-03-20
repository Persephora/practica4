/**
 * Created by linux on 18/03/16.
 */
class Bender {
    //VARIABLES
    private final char[][] terreno;
    private int posX;
    private int posY;
    private int ancho;
    private int largo;
    private String prioridad = "SENW";
    private int posxT;
    private int posyT;
    private int contador;
    private int movimientos;

    //CONSTRUCTOR BENDER
    public Bender(String mapa) {
        ancho = ancho(mapa);
        terreno = construirMapa(mapa);
        String r = QuitarSalto(mapa);
    }

    //RECORRIDO DE BENDER
    public String run() {
        boolean teletransportado = false;
        String resultado = "";
        EncontrarBender(terreno);
        int priotele = 0;
        while (terreno[posY][posX] != '$') {
            if (terreno[posY][posX] == '$') {
                break;
            } else if (terreno[posY][posX] == 'I') {
                prioridad = iPrioridad(prioridad);
                contador = contador(prioridad);
                resultado += prioridad.charAt(contador);
                desplazamiento(prioridad.charAt(contador));
            } else if (terreno[posY][posX] == 'T') {
                priotele = contador;
                teletransportado = true;
                EncontrarTransporter(terreno);
            }
            contador = contador(prioridad);
            if (teletransportado) {
                contador = priotele;
            }
            while (!pared(prioridad.charAt(contador))) {
                if (terreno[posY][posX] == '$') {
                    break;
                }
                resultado += prioridad.charAt(contador);
                desplazamiento(prioridad.charAt(contador));
            }
        }
        return resultado;
    }

    //METODO PARA SABER EL ANCHO DE NUESTRO MAPA
    private int ancho(String r) {
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '\n') {
                ancho = i;
                return ancho;
            }
        }
        return ancho;
    }

    //CONSTRUIR MAPA EN UN ARRAY MULTIDIMENSIONAL
    private char[][] construirMapa(String r) {
        int Largo = r.length() / ancho;
        r = QuitarSalto(r);
        int x = 0;
        int y = ancho;
        char[][] terreno = new char[Largo - 1][ancho];
        for (int h = 0; h < Largo - 1; h++) {
            String Parcial = r.substring(x, y);
            for (int k = 0; k < ancho; k++) {
                if (Parcial.charAt(k) == '\n') {
                    k++;
                    continue;
                }
                terreno[h][k] = Parcial.charAt(k);
            }
            x = y;
            y += ancho;
        }
        return terreno;
    }

    //METODO QUE CAMBIA LA PRIORIDAD EN CASO DE UN INVERTIR
    private String iPrioridad(String prioridad) {
        String parte;
        parte = prioridad.substring(0, 2);
        prioridad = prioridad.substring(2, 4);
        prioridad += parte;
        return prioridad;
    }

    //QUITAR SALTOS DEL STRING PARA UNA MEJOR MANIPULACION
    private String QuitarSalto(String r) {
        String res = "";
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '\n') {
                continue;
            }
            res += r.charAt(i);
        }
        return res;
    }

    //ENCONTRAR INICIO DE DESPLAZAMIENTO
    private void EncontrarBender(char[][] array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                if (array[y][x] == 'X') {
                    posX = x;
                    posY = y;
                }
            }
        }
    }

    //ENCONTRAR POSICION TELETRANSPORTER
    private void EncontrarTransporter(char[][] array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                if (array[y][x] == 'T') {
                    if (x != posX && y != posY) {
                        posxT = x;
                        posyT = y;
                        posX = posxT;
                        posY = posyT;
                        return;
                    }
                }
            }
        }
    }

    //COMPROBAR SI HAY PARED
    private boolean pared(char prioridad) {
        switch (prioridad) {
            case 'S':
                if (terreno[posY + 1][posX] == '#') {
                    return true;
                }
                break;
            case 'E':
                if (terreno[posY][posX + 1] == '#') {
                    return true;
                }
                break;
            case 'N':
                if (terreno[posY - 1][posX] == '#') {
                    return true;
                }
                break;
            case 'W':
                if (terreno[posY][posX - 1] == '#') {
                    return true;
                }
                break;
        }
        return false;
    }

    //DESPLAZAR EL ROBOT
    private void desplazamiento(char prioridad) {
        switch (prioridad) {
            case 'S':
                posY += 1;
                movimientos++;
                break;
            case 'E':
                posX += 1;
                movimientos++;
                break;
            case 'N':
                posY -= 1;
                movimientos++;
                break;
            case 'W':
                posX -= 1;
                movimientos++;
                break;
        }
    }

    //CONTADOR PARA SABER DIRECCION
    private int contador(String prioridad) {
        for (int i = 0; i < prioridad.length(); i++) {
            boolean pared = pared(prioridad.charAt(i));
            if (!pared) {
                contador = i;
                break;
            }
        }
        return contador;
    }
}
