/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.view;

import static grafos_app.view.Patron.FONT_PRINCIPAL;
import static grafos_app.view.Patron.INTER_PRINCIPAL;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author WILMER
 */
public class VnTutorial extends javax.swing.JDialog implements Patron {

    private RoundedPanel pnCentralFondo;
    private JPanel pnBackground;
    private JPanel pnCentral;

    private JLabel lbTitulo;
    private JLabel lbTutorial;
    private JScrollPane spTutorial;
    private String TITULO_CABECERA = "Tutorial - Grafos App";

    public VnTutorial(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.7), (int) (ALTO * 0.8)));
        this.setMaximumSize(new Dimension((int) (ANCHO * 0.7) + 1, (int) (ALTO * 0.8) + 1));
        this.setPreferredSize(new Dimension((int) (ANCHO * 0.7), (int) (ALTO * 0.8)));
        this.setLayout(new BorderLayout(MARGEN, MARGEN));
        this.setTitle(TITULO_CABECERA);
        this.setBackground(COLOR_SECUNDARIO);

        lbTitulo = new JLabel(TITULO_CABECERA);
        lbTitulo.setForeground(FONT_PRINCIPAL);
        lbTitulo.setFont(INTER_PRINCIPAL);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);

        lbTutorial = new JLabel();
        lbTutorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTutorial.setOpaque(true);
        lbTutorial.setBackground(COLOR_PRINCIPAL);
        lbTutorial.setIcon(new ImageIcon("src/icons/Tutorial/Tutorial_"+TUTORIAL+".jpg"));

        spTutorial = new JScrollPane(lbTutorial,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spTutorial.setBorder(null);
        spTutorial.setBackground(COLOR_PRINCIPAL);
        spTutorial.setViewportView(lbTutorial);
        spTutorial.getHorizontalScrollBar().setPreferredSize(new Dimension(6, 6));
        spTutorial.getHorizontalScrollBar().setBorder(null);
        spTutorial.getVerticalScrollBar().setPreferredSize(new Dimension(6, 6));
        spTutorial.getVerticalScrollBar().setBorder(null);

        JPanel pnTemp = new JPanel();
        pnTemp.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnTemp.setOpaque(false);
        pnTemp.add(lbTitulo, BorderLayout.NORTH);
        pnTemp.add(spTutorial, BorderLayout.CENTER);

        pnCentral = new JPanel();
        pnCentral.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnCentral.setOpaque(false);
        pnCentral.add(pnTemp, BorderLayout.CENTER);
        hacerMagenes(pnCentral);

        pnBackground = new JPanel();
        pnBackground.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnBackground.setBackground(COLOR_SECUNDARIO);
        pnBackground.setMinimumSize(new Dimension((int) (ANCHO * 0.7), (int) (ALTO * 0.8)));
        pnBackground.setMaximumSize(new Dimension((int) (ANCHO * 0.7) + 1, (int) (ALTO * 0.8) + 1));
        pnBackground.setPreferredSize(new Dimension((int) (ANCHO * 0.7), (int) (ALTO * 0.8)));

        pnCentralFondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        pnCentralFondo.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnCentralFondo.setBackground(COLOR_SECUNDARIO);
        pnCentralFondo.add(pnCentral, BorderLayout.CENTER);

//        pnBackground.add(lbTitulo, BorderLayout.NORTH);
        pnBackground.add(pnCentralFondo, BorderLayout.CENTER);
        hacerMagenes(pnBackground);
        this.add(pnBackground);
    }

    private void hacerMagenes(JPanel pn) {
        int i = 0;
        JPanel izq = new JPanel();
        izq.setOpaque(false);
        izq.setPreferredSize(new Dimension(i, i));
        pn.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setOpaque(false);
        der.setPreferredSize(new Dimension(i, i));
        pn.add(der, BorderLayout.EAST);

        JPanel nor = new JPanel();
        nor.setOpaque(false);
        nor.setPreferredSize(new Dimension(i, i));
        pn.add(nor, BorderLayout.NORTH);

        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.setPreferredSize(new Dimension(i, i));
        pn.add(sur, BorderLayout.SOUTH);
    }
}
