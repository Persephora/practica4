/**
 * Created by linux on 10/03/16.
 */
class Bender {
    char[][] terreno;
    int posX;
    int posY;
    int posFinalX;
    int posFinalY;
    int ancho;
    String prioridad = "SENW";

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        ancho = ancho(mapa);
        terreno = construirMapa(mapa);

    }


    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.
    public String run() {
        String resultado = recorrer(terreno);
        return resultado;
    }

    int ancho(String r) {
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '\n') {
                ancho += 1;
            }
        }
        return ancho;
    }

    public char[][] construirMapa(String r) {
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

    void EncontrarBender(char[][] array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                if (array[y][x] == 'X') {
                    posX = x;
                    posY = y;
                }
                if (array[y][x] == '$') {
                    posFinalX = x;
                    posFinalY = y;
                }
            }
        }
    }

    String recorrer(char[][] terreno) {
        String resultado = "";
        EncontrarBender(terreno);
        int contador = 0;
        char direccion;
        for (int x = posX; x < ancho; x++) {
            for (int y = posY; y < terreno.length; y++) {
                if (terreno[y + 1][x] == ' ') {
                    resultado += prioridad.charAt(contador);
                }
                if (x == posFinalX && y == posFinalY) {
                    resultado += prioridad.charAt(contador);
                    return resultado;
                }
                posY = y;
                if (terreno[y + 1][x] == '$') {
                    resultado += prioridad.charAt(contador);
                    return resultado;
                }
                if (terreno[y + 1][x] != ' ') {
                    contador++;
                    if (terreno[y][x + 1] == ' ') {
                        x++;
                        for (int a = x; a <= posFinalX; a++) {
                            if (terreno[posY][a] == ' ') {
                                resultado += prioridad.charAt(contador);
                            }
                            if (a == posFinalX && posY == posFinalY) {
                                resultado += prioridad.charAt(contador);

                                return resultado;
                            }
                            posX = a;
                        }

                        contador = 0;
                    }
                    if (terreno[y - 1][posX] == ' ') {
                        contador += 2;
                        y--;
                        for (int b = y; b >= posFinalY; b--) {
                            if (terreno[b][posX] == ' ') {
                                resultado += prioridad.charAt(contador);

                            }
                            if (posX == posFinalX && b == posFinalY) {
                                resultado += prioridad.charAt(contador);

                                return resultado;
                            }
                            posY = b;
                        }
                        contador = 0;
                    }
                    if (terreno[posY][posX - 1] == ' ') {
                        contador += 3;
                        x--;
                        for (int c = posX; c >= posFinalX; c--) {
                            if (terreno[posY][c] == ' ') {
                                resultado += prioridad.charAt(contador);
                            }
                            if (c == posFinalX && posY == posFinalY) {
                                resultado += prioridad.charAt(contador);
                                return resultado;
                            }
                            posX = c;
                        }
                        contador = 0;
                    }

                }
            }
        }
        return resultado;
    }

    String obstaculos(char[][] terreno) {
        String resultado = "";
        EncontrarBender(terreno);
        int contador = 0;
        char direccion;
        for (int x = posX; x < ancho; x++) {
            for (int y = posY; y < terreno.length; y++) {
                if (terreno[y + 1][x] == ' ') {
                    resultado += prioridad.charAt(contador);
                    if (x == posFinalX && y == posFinalY) {
                        resultado = resultado + prioridad.charAt(contador);
                        return resultado;
                    }
                }
                if (terreno[y + 1][x] != ' ') {
                    contador++;
                    if (terreno[y][x + 1] == ' ') {
                        for (int a = x; a < ancho; x++) {
                            if (terreno[y][a] == ' ') {
                                resultado += prioridad.charAt(contador);
                                if (x == posFinalX && y == posFinalY) {
                                    resultado = resultado + prioridad.charAt(contador);
                                    return resultado;
                                }
                            }
                        }
                    }
                    if (terreno[y - 1][x] == ' ') {
                        for (int b = y; b > 0; b--) {
                            if (terreno[b][x] == ' ') {
                                resultado += prioridad.charAt(contador);
                                if (x == posFinalX && y == posFinalY) {
                                    resultado = resultado + prioridad.charAt(contador);
                                    return resultado;
                                }
                            }
                        }
                    }
                    if (terreno[y][x - 1] == ' ') {
                        for (int c = x; c > 0; c--) {
                            if (terreno[y][c] == ' ') {
                                resultado += prioridad.charAt(contador);
                                if (x == posFinalX && y == posFinalY) {
                                    resultado = resultado + prioridad.charAt(contador);
                                    return resultado;
                                }
                            }
                        }
                    }

                }
            }
        }
        return resultado;
    }
}

