/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.view.paneles_centrales;

import grafos_app.model.Arista;
import grafos_app.model.Grafo;
import grafos_app.model.Vertice;
import grafos_app.view.Patron;
import static grafos_app.view.Patron.COLOR_ACENTUADOR;
import static grafos_app.view.Patron.COLOR_PRINCIPAL;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.QuadCurve2D;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class PnLienzo extends JPanel implements Patron {

    private Grafo grafo;
    private int radio_2;
    private int radio;
    private int altoMitad;
    private int anchoMitad;

    public PnLienzo() {
        iniciarComponentes();
    }

    public PnLienzo(Grafo grafo) {
        this.grafo = grafo;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_PRINCIPAL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // No pintar nada
        if (grafo == null) {
            return;
        }

        anchoMitad = getWidth() / 2;
        altoMitad = getHeight() / 2;
        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // Radio
        radio = (int) (ANCHO * 0.01);
        radio_2 = (int) (ANCHO * 0.028);

        // Pintar vertices
        graphics.setColor(FONT_PRINCIPAL);
        for (Vertice vertice : grafo.getVertices()) {
            for (Arista arista : vertice.getAristas()) {
                graphics.setStroke(new BasicStroke((int) (ALTO * 0.0027)));
                // Lazo
                if (arista.getA() == arista.getB()) {
                    int x_1 = anchoMitad + ((int) arista.getPosInicio().getX());
                    int y_1 = altoMitad + ((int) arista.getPosInicio().getY()) - ((int) (radio_2 / 2));

                    graphics.drawOval(x_1, y_1, radio_2, radio_2);
                } else {
                    int x_1 = anchoMitad + (int) arista.getPosInicio().getX();
                    int y_1 = altoMitad + (int) arista.getPosInicio().getY();

                    int x_2 = anchoMitad + (int) arista.getPosFinal().getX();
                    int y_2 = altoMitad + (int) arista.getPosFinal().getY();

//                    System.out.println("x1 " + x_1 + "  y1 " + y_1 + "  x2 " + x_2 + "  y2 " + y_2);
                    for (int i = 0; i < arista.getCantidad(); i++) {
                        if (i == 0) {
                            graphics.drawLine(x_1, y_1, x_2, y_2);
                        } else {
                            graphics.draw(dibujarCurva(graphics, x_1, x_2, y_1, y_2, i * i));
//                            graphics.drawArc((x_1 + x_2) / 2, (y_1 + y_2) / 2, 100, 100, 0, 180);
                        }

                    }
                }
            }
        }

        // Pintar grafo correspondiente
        // Dibujar vertices
        for (Vertice vertice : grafo.getVertices()) {
//            System.out.println(vertice.getPosicion());
            //Vertices
            graphics.setColor(vertice.getColor());
            int x = anchoMitad + (int) vertice.getPosicion().getX();
            int y = altoMitad + (int) vertice.getPosicion().getY();
            graphics.fillOval((int) (x - (radio / 2)), (int) (y - (radio / 2)), radio, radio);

            //Nombre
            graphics.setColor(FONT_PRINCIPAL);
            graphics.setFont(INTER_PRINCIPAL);
            int x_1 = anchoMitad + (int) vertice.getPos_nombre().getX() - 4;
            int y_1 = altoMitad + (int) vertice.getPos_nombre().getY() + 7;
            graphics.drawString(Character.toString(vertice.getNombre()), x_1, y_1);
        }
    }

//    public void pintarVertice(Graphics graphics, Point punto, Color color) {
//        graphics.setColor(color);
//        int x = anchoMitad + (int) punto.getX();
//        int y = altoMitad + (int) punto.getY();
//        graphics.fillOval((int) (x - (radio / 2)), (int) (y - (radio / 2)), radio, radio);
//    }

    private QuadCurve2D.Double dibujarCurva(Graphics g, int x_1, int x_2, int y_1, int y_2, int i) {

        Point control = null;
        int var = 40;
        int c = 7;

        int neg = (int) (Math.pow(-1, i));

        double a = (y_1 - y_2);
        double b = (x_1 - x_2);
        double m = a / b;
        double grado = Math.atan(m);

        double ang45 = Math.PI / 4;
        double ang90 = Math.PI / 2;

        int x_med = (int) (x_1 + x_2) / 2;
        int y_med = (int) (y_1 + y_2) / 2;

//        if (grado > 0) {
//            if (grado <= ang45 && grado >= 0) {
//                control = new Point(x_med - (c * i), y_med - (c * i));
//            }
//            if (grado <= ang90 && grado > ang45) {
//                control = new Point(x_med - (c * i), y_med - (c * i));
//            }
//        } else {
//            if (grado >= -ang45 && grado <= 0) {
//                control = new Point(x_med + (c * i) + var, y_med + (c * i) + var);
//            }
//            if (grado >= -ang90 && grado < -ang45) {
//                control = new Point(x_med + (c * i) + var, y_med + (c * i) + var);
//            }
//        }
        if (grado > 0) {
            if (grado <= ang45 && grado >= 0) {
                control = new Point((x_1 + x_2) / 2 - (c + (c * i)), (y_1 + y_2) / 2 + (var + (c * i)));
            }
            if (grado <= ang90 && grado > ang45) {
                control = new Point((x_1 + x_2) / 2 + (var + (c * i)), (y_1 + y_2) / 2 + (c + (c * i)));
            }
        } else {
            if (grado >= -ang45 && grado <= 0) {
                control = new Point((x_1 + x_2) / 2 - (var - c + (c * i)), (y_1 + y_2) / 2 - (var + (c * i)));
            }
            if (grado >= -ang90 && grado < -ang45) {
                control = new Point((x_1 + x_2) / 2 - (var + (c * i)) - 20, (y_1 + y_2) / 2 - (c + (c * i)));
            }
        }
//        if (grado > 0) {
//            if (grado <= ang45 && grado >= 0) {
//                control = new Point(x_med - (c + (c * i)), y_med + (var + (c * i)));
//            }
//            if (grado <= ang90 && grado > ang45) {
//                control = new Point(x_med + (var + (c * i)), y_med / 2 + (c + (c * i)));
//            }
//        } else {
//            if (grado >= -ang45 && grado <= 0) {
//                control = new Point(x_med - (var - c + (c * i)), y_med / 2 - (var + (c * i)));
//            }
//            if (grado >= -ang90 && grado < -ang45) {
//                control = new Point(x_med - (var + (c * i)), y_med / 2 - (c + (c * i)));
//            }
//        }

        Point tempInicial = new Point(x_1, (int) y_1),
                tempFinal = new Point(x_2, (int) y_2);

        QuadCurve2D.Double quad = new QuadCurve2D.Double();
        quad.setCurve(tempInicial, control, tempFinal);

        return quad;

    }

    public Grafo getGrafo() {
        return grafo;
    }

    public int getRadio_2() {
        return radio_2;
    }

    public int getRadio() {
        return radio;
    }

    public int getAltoMitad() {
        return altoMitad;
    }

    public int getAnchoMitad() {
        return anchoMitad;
    }

}
