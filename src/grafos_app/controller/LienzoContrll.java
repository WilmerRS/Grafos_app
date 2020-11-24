/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.controller;

import grafos_app.model.Grafo;
import grafos_app.model.Vertice;
import grafos_app.view.Patron;
import grafos_app.view.paneles_centrales.PnLienzo;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

/**
 *
 * @author WILMER
 */
public class LienzoContrll implements Patron {

    private PnLienzo pnLienzo;

    public LienzoContrll() {
    }

    public LienzoContrll(PnLienzo pnLienzo) {
        this.pnLienzo = pnLienzo;
    }

    public PnLienzo getPnLienzo() {
        return pnLienzo;
    }

    public void setPnLienzo(PnLienzo pnLienzo) {
        this.pnLienzo = pnLienzo;
        if (pnLienzo != null) {
            agregarEventos();
        }
    }

    private void agregarEventos() {
        pnLienzo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                cambioMouse(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                arratreMouse(e);
            }

        });
    }

    public void cambioMouse(MouseEvent e) {
        Grafo gra = pnLienzo.getGrafo();
        if (gra == null) {
            return;
        }
        ArrayList<Point> puntos = gra.getPosiciones();
        for (int i = 0; i < puntos.size(); i++) {
            Point p = gra.ecuacionDeCirculo(e.getPoint(), new Point(pnLienzo.getAnchoMitad(), pnLienzo.getAltoMitad()), pnLienzo.getRadio());
            if (p != null) {
                gra.verticeEnPosisicion(p).colorResaltado();
                pnLienzo.updateUI();
            } else {
                gra.colorDefecto();
                pnLienzo.updateUI();
            }
            pnLienzo.updateUI();
        }
    }

    public void arratreMouse(MouseEvent e) {
        Grafo gra = pnLienzo.getGrafo();
        if (gra == null) {
            return;
        }
        Point ubicacion = new Point(e.getX() - pnLienzo.getAnchoMitad(), e.getY() - pnLienzo.getAltoMitad());
        Point p = gra.ecuacionDeCirculo(e.getPoint(), new Point(pnLienzo.getAnchoMitad(), pnLienzo.getAltoMitad()), pnLienzo.getRadio());
        if (p != null) {
            Vertice ver = gra.verticeEnPosisicion(p);
            int x_1 = ver.getPosicion().x;
            int y_1 = ver.getPosicion().y;

            int x_var = x_1 - ubicacion.x;
            int y_var = y_1 - ubicacion.y;

            Point pos_nombre = new Point(ver.getPos_nombre().x - x_var, ver.getPos_nombre().y - y_var);

            ver.setPosicion(ubicacion);
            if (pos_nombre.x != 0 && pos_nombre.y != 0) {
                ver.setPos_nombre(pos_nombre);
            }
            gra.actualizarPosiciones();
            pnLienzo.updateUI();
        }
    }

}
