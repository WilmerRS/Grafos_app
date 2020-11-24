/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.model;

import static grafos_app.view.Patron.ANCHO;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author WILMER
 */
public class Grafo {

    private final String GRAFO_SIMPLE = "Es un grafo simple.";
    private final String GRAFO_MULTIPLE = "Es un grafo múltiple: E = [ ";

    private ArrayList<Vertice> vertices;
//    private Hashtable<Character, Vertice> hashVertices;
    private int numVertices = 0;
    private ArrayList<Point> posiciones;
    private int radio = (int) (ANCHO * 0.09);
    private int radio_2 = (int) (ANCHO * 0.015);

    public Grafo() {
        vertices = new ArrayList<>();
//        hashVertices = new Hashtable<>();
        posiciones = new ArrayList<>();
    }

    public void limpiarGrafo() {
        vertices.removeAll(vertices);
        posiciones.removeAll(posiciones);
        numVertices = 0;
    }

    private boolean existeVertice(char nombre) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNombre() == nombre) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarVertice(char nombre) {

        if (!existeVertice(nombre)) {
            Vertice vertice = new Vertice(nombre);
            vertices.add(vertice);
//            hashVertices.put(nombre, vertice);
            numVertices++;
            posiciones = obtenerPosiciones();
            return true;
        }
        return false;
    }

    public boolean agregarArista(char nomVertice_1, char nomVertice_2, int cantidad) {
//        System.out.println( "Cantidad: " + cantidad);
        for (Vertice vertice : vertices) {
            if (vertice.getNombre() == nomVertice_1 && cantidad > 0) {
                vertice.agregarArista(vertice.getPosicion(), obtenerPosicion(nomVertice_2), cantidad, nomVertice_1, nomVertice_2);

                if (nomVertice_1 != nomVertice_2) {
                    aumentarGradoVertice(cantidad, nomVertice_1);
                    aumentarGradoVertice(cantidad, nomVertice_2);
                } else {
                    aumentarGradoVertice(cantidad, nomVertice_1);
                }
            }
        }
        return true;
    }

    private void aumentarGradoVertice(int cantidad, char nomVertice) {
        for (Vertice vertice : vertices) {
            if (vertice.getNombre() == nomVertice) {
                vertice.setGrado(vertice.getGrado() + cantidad);
                return;
            }
        }
    }

    public boolean isGrafo(String[][] matriz) {
        return esSimetrica(matriz);
    }

    public int sumatoriaGrados() {
        int cont = 0;
        for (Vertice vertice : vertices) {
            cont += vertice.getGrado();
        }
        return cont;
    }

    public int contarAristas() {
        int cont = 0;
//        for (Vertice vertice : vertices) {
//            cont += vertice.getAristas().size();
//        }
        for (Vertice vertice : vertices) {
            for (Arista arista : vertice.getAristas()) {
                if (arista.getA() == arista.getB()) {
                    cont++;
                } else {
                    cont += arista.getCantidad();
                }
            }
        }
        return cont;
    }

    public String gradosGrafo() {
        int cont = 0;
        String cadena = "Grados: [ ";
        for (Vertice vertice : vertices) {
            cont++;
            cadena += vertice.getNombre() + "(" + vertice.getGrado() + "), ";
        }
        return quitarComa(cadena.toCharArray(), cont);
    }

    public String tipoGrafo() {
        int cont = 0;
        int c = 0;
        String tipo = GRAFO_MULTIPLE;
        for (Vertice vertice : vertices) {
            for (Arista arista : vertice.getAristas()) {
                if (arista.getA() == arista.getB()) {
                    if (arista.getCantidad() != 0) {
                        cont++;
                        tipo += arista.getNombreArista() + ", ";
                    }
                } else {
                    if (arista.getCantidad() > 1) {
                        cont++;
                        tipo += arista.getNombreArista() + ", ";
                    }
                }
                c++;
            }
        }
        if (cont != 0) {
            return quitarComa(tipo.toCharArray(), c);
        }
        return GRAFO_SIMPLE;
    }

    private boolean esSimetrica(String matriz[][]) {
        for (int fila = 1; fila < matriz.length; fila++) {
            for (int columna = 0; columna < fila; columna++) {
                if (!matriz[fila][columna].equals(matriz[columna][fila])) {
                    return false;
                }
            }
        }
        return true;
    }

    private ArrayList<Point> obtenerPosiciones() {
        ArrayList<Point> temp = new ArrayList<>();
        double angulo = (2 * Math.PI) / vertices.size();
        double rotacion = (2 * Math.PI) / Math.random() * (5 - 15 + 1) + 15;
        int x, y, x_1, y_1;
        int i = 0;
        for (Vertice vertice : vertices) {
            x = (int) (radio * Math.cos((angulo * i) + rotacion));
            y = (int) (radio * Math.sin((angulo * i) + rotacion));

            x_1 = (int) ((radio + radio_2) * Math.cos((angulo * i) + rotacion));
            y_1 = (int) ((radio + radio_2) * Math.sin((angulo * i) + rotacion));

            vertice.setPosicion(new Point(x, y));
            vertice.setPos_nombre(new Point(x_1, y_1));

            temp.add(new Point(x, y));
            i++;
        }
        return temp;
    }

    public void actualizarPosiciones() {
        for (Vertice vertice : vertices) {
            Point pos = vertice.getPosicion();
            for (Vertice vertice1 : vertices) {
                for (Arista arista : vertice1.getAristas()) {
                    if (arista.getA() == vertice.getNombre()) {
                        arista.setPosInicio(pos);
                    }
                    if (arista.getB() == vertice.getNombre()) {
                        arista.setPosFinal(pos);
                    }
                }
            }
        }
    }

    public Point obtenerPosicion(char nomVertice) {
        for (Vertice vertice : vertices) {
            if (vertice.getNombre() == nomVertice) {
                return vertice.getPosicion();
            }
        }
        return null;
    }

    public String obtenerCadenaGrafo() {
//        System.out.println("num ver "+ vertices.size());

        String cadena = "G (V, E) = [ ";
        int cont = 0;
        for (int i = 0; i < vertices.size(); i++) {
            cadena += vertices.get(i).obtenerCadenaVertice();
            cont++;;
        }
        return quitarComa(cadena.toCharArray(), cont);
    }

    private String quitarComa(char[] cadena, int cont) {
        String temp = "";
        int resto = 2;
        if (cont == 0) {
            resto = 1;
        }
        for (int i = 0; i < cadena.length - resto; i++) {
            temp += Character.toString(cadena[i]);
        }
        return temp + " ]";
    }

    public Point ecuacionDeCirculo(Point punto, Point ubicacion, int RADIO) {
        return verificarPosicion((punto.x - ubicacion.x), (punto.y - ubicacion.y), RADIO / 2);
    }

    private Point verificarPosicion(int x, int y, int radMed) {
        for (Vertice vertice : vertices) {

            if (x > (vertice.getPosicion().x - radMed) && x < (vertice.getPosicion().x + radMed)) {
                if (y > (vertice.getPosicion().y - radMed) && y < (vertice.getPosicion().y + radMed)) {
                    return vertice.getPosicion();
                }
            }

        }
        return null;
    }

    public Vertice verticeEnPosisicion(Point punto) {
        for (Vertice vertice : vertices) {
            if (vertice.getPosicion().x == punto.x && vertice.getPosicion().y == punto.y) {
                return vertice;
            }
        }
        return null;
    }

    public Vertice colorDefecto() {
        for (Vertice vertice : vertices) {
            vertice.colorDefecto();
        }
        return null;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public ArrayList<Point> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<Point> posiciones) {
        this.posiciones = posiciones;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getRadio_2() {
        return radio_2;
    }

    public void setRadio_2(int radio_2) {
        this.radio_2 = radio_2;
    }

}
