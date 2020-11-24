/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author WILMER
 */
public class Vertice {

    private ArrayList<Arista> aristas;
    private Hashtable<Integer, Integer> hashAristas;
    private int grado = 0;
    private char nombre;
    private Point posicion;
    private Point pos_nombre;

    private Color color = new Color(0, 196, 255);
    
    public Vertice(char nombre) {
        aristas = new ArrayList<>();
        hashAristas = new Hashtable<>();
        this.nombre = nombre;
//        this.posicion = posicion;
//        this.pos_nombre = pos_nombre;
    }

//    public boolean isAristaEnVertice(char a, char b) {
//        System.out.println(a + " -*- " + b);
//        int ar = hashAristas.get(a + b);
//
//        hashAristas.replace(a + b, (hashAristas.get(a + b)+1));
//        System.out.println(hashAristas.get(a + b));
//        if (ar == 2) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    public boolean agregarArista(Point posInicio, Point posFinal, int cantidad, char a, char b) {
//        System.out.println("Agregando arista   " + a + " - - " + b);
        Arista arista = new Arista(posInicio, posFinal, cantidad, a, b);
        hashAristas.put(a + b, 0);
        aristas.add(arista);
//        grado = obtenerGrado();
        return true;
    }

    public String obtenerCadenaVertice() {
        String cadena = "";
        for (int i = 0; i < aristas.size(); i++) {
            cadena += aristas.get(i).getNombreArista() + ", ";
        }
        return cadena;
    }

    public void colorDefecto() {
        color = new Color(0, 196, 255);
    }
    
    public void colorResaltado() {
        color = new Color(255, 174, 201);
    }

    public int getGrado() {
        return grado;
    }

    public char getNombre() {
        return nombre;
    }

    public Point getPosicion() {
        return posicion;
    }

    public Point getPos_nombre() {
        return pos_nombre;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public void setPos_nombre(Point pos_nombre) {
        this.pos_nombre = pos_nombre;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
