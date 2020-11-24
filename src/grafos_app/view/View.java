/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class View extends JFrame implements Patron {

    private String TITULO = "Grafos APP";

    /**
     * Crear la vista o la interfaz de la app
     */
    public View() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private JPanel pnCabecera;
    private JPanel pnBackground;
    private JPanel pnCentralFondo;
    private PnCentral pnCentral;

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.5), (int) (ALTO * 0.5)));
        this.setIconImages(ICONS);
        this.setTitle(TITULO);

        pnBackground = new JPanel();
        pnBackground.setLayout(new BorderLayout());
        pnBackground.setBackground(COLOR_SECUNDARIO);
        pnBackground.setPreferredSize(new Dimension((int) (ANCHO * 0.8), (int) (ALTO * 0.8)));
        
        pnCentral  = new PnCentral();
        
        pnCentralFondo  =new JPanel();
        pnCentralFondo.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnCentralFondo.setBackground(COLOR_SECUNDARIO);
        pnCentralFondo.add(pnCentral, BorderLayout.CENTER);
        hacerMagenes();

        pnCabecera = new PnCabecera();
        
        pnBackground.add(pnCabecera, BorderLayout.NORTH);
        pnBackground.add(pnCentralFondo, BorderLayout.CENTER);
        getContentPane().add(pnBackground, java.awt.BorderLayout.CENTER);
        pack();
    }

    private void hacerMagenes() {
        int i =0;
        JPanel izq = new JPanel();
        izq.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(izq, BorderLayout.WEST);
        
        JPanel der = new JPanel();
        der.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(der, BorderLayout.EAST);
        
        JPanel nor = new JPanel();
        nor.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(nor, BorderLayout.NORTH);
        
        JPanel sur = new JPanel();
        sur.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(sur, BorderLayout.SOUTH);
    }

    public PnCentral getPnCentral() {
        return pnCentral;
    }
    
}
