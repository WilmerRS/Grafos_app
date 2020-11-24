/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.view.paneles_centrales;

import grafos_app.view.Patron;
import static grafos_app.view.Patron.COLOR_PRINCIPAL;
import grafos_app.view.RoundedPanel;
import grafos_app.view.TextField;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 *
 * @author WILMER
 */
public class PnEntradaDatos extends RoundedPanel implements Patron {

    public PnEntradaDatos() {
        super(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new FlowLayout());
        this.setBackground(COLOR_PRINCIPAL);
//        TextField tx =new TextField(new Dimension(130,50), "Hola", TextField.RESTRICCION_NO_EDITABLE);
//        TextField tx2 =new TextField(new Dimension(130,50), "Hola");
//        this.add(tx);
//        this.add(tx2);
    }
}
