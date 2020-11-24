/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.view;

import static grafos_app.view.Patron.COLOR_PRINCIPAL;
import grafos_app.view.paneles_centrales.PnEntradaDatos;
import grafos_app.view.paneles_centrales.PnGrafo;
import grafos_app.view.paneles_centrales.PnMatriz;
import grafos_app.view.paneles_centrales.PnSalidaDatos;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * 
 * @author WILMER
 */
public class PnCentral extends RoundedPanel implements Patron {

    private PnEntradaDatos pnEntradaDatos;
    private PnMatriz pnMatriz;
    private PnGrafo pnGrafo;
    private PnSalidaDatos pnSalidaDatos;
    
    
    public PnCentral() {
        super(0, COLOR_SECUNDARIO, COLOR_SECUNDARIO);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout(MARGEN, 0));
        
        JPanel izq = new JPanel();
        izq.setLayout(new BorderLayout(0, MARGEN));
        izq.setOpaque(false);
        
        JPanel der = new JPanel();
        der.setLayout(new BorderLayout(0, MARGEN));
        der.setBackground(COLOR_PRINCIPAL);
        der.setOpaque(false);
        
        pnEntradaDatos = new PnEntradaDatos();
        
        pnMatriz = new PnMatriz();
        
        izq.add(pnEntradaDatos, BorderLayout.CENTER);
        izq.add(pnMatriz, BorderLayout.NORTH);
        
        pnGrafo  = new PnGrafo();
        pnSalidaDatos = new PnSalidaDatos();
        der.add(pnGrafo, BorderLayout.CENTER);
        der.add(pnSalidaDatos, BorderLayout.SOUTH);
        
        this.add(izq, BorderLayout.WEST);
        this.add(der, BorderLayout.CENTER);
    }

    public PnMatriz getPnMatriz() {
        return pnMatriz;
    }

    public PnGrafo getPnGrafo() {
        return pnGrafo;
    }

    public PnSalidaDatos getPnSalidaDatos() {
        return pnSalidaDatos;
    }
    
}
