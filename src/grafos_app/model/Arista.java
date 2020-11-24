/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.model;

import java.awt.Point;

/**
 *
 * @author WILMER
 */
public class Arista {

    private Point posInicio;
    private Point posFinal;
    private int cantidad;
    private String nombreArista;
    private char a, b;

    public Arista(Point posInicio, Point posFinal, int cantidad, char a, char b) {
        this.posInicio = posInicio;
        this.posFinal = posFinal;
        this.cantidad = cantidad;
        this.nombreArista = "{" + a + ", " + b + "}";
        this.a = a;
        this.b = b;
    }

    public Point getPosInicio() {
        return posInicio;
    }

    public void setPosInicio(Point posInicio) {
        this.posInicio = posInicio;
    }

    public Point getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(Point posFinal) {
        this.posFinal = posFinal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreArista() {
        return nombreArista;
    }

    public void setNombreArista(String nombreArista) {
        this.nombreArista = nombreArista;
    }

    public char getA() {
        return a;
    }

    public void setA(char a) {
        this.a = a;
    }

    public char getB() {
        return b;
    }

    public void setB(char b) {
        this.b = b;
    }

}
