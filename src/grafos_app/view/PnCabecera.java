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
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author WILMER
 */
public class PnCabecera extends RoundedPanel implements Patron {

    private final String TITULO_CABECERA = "Grafos APP";
    private JLabel lbTitulo;
    private JLabel lbIcono;
    private JButton btnAyuda;

    public PnCabecera() {
        super(0, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setPreferredSize(new Dimension(0, (int) (ALTO * 0.05)));
        this.setLayout(new BorderLayout());

        lbTitulo = new JLabel(TITULO_CABECERA);
        lbTitulo.setForeground(FONT_PRINCIPAL);
        lbTitulo.setFont(INTER_PRINCIPAL);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);

        JPanel tempSombra = new JPanel();
        tempSombra.setBackground(COLOR_TERCIARIO);
        tempSombra.setPreferredSize(new Dimension(0, (int) (ALTO * 0.0025)));

        JPanel izq = new JPanel(new GridBagLayout());
        izq.setOpaque(false);
        izq.setPreferredSize(new Dimension((int) (ALTO * 0.07), 0));

        JPanel der = new JPanel(new BorderLayout());
        der.setOpaque(false);
        der.setPreferredSize(new Dimension((int) (ALTO * 0.07), 0));

        btnAyuda = new JButton();
        btnAyuda.setLayout(new java.awt.BorderLayout());
        btnAyuda.setBorder(null);
        btnAyuda.setOpaque(false);
        btnAyuda.setFocusPainted(false);
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setFocusable(false);
        btnAyuda.setIcon(new ImageIcon("./src/icons/1x/infor-" + ICON_INFOR + ".png"));
        btnAyuda.setRolloverIcon(new ImageIcon("./src/icons/1x/infor-hover-" + ICON_INFOR + ".png"));
        agregarEventoBotonTutorial();

        lbIcono = new JLabel();
        lbIcono.setHorizontalAlignment(SwingConstants.CENTER);
        lbIcono.setVerticalAlignment(SwingConstants.CENTER);
        lbIcono.setIcon(new ImageIcon("./src/icons/1x/icon-" + ICON_CAB + ".png"));

        izq.add(btnAyuda);
        der.add(lbIcono);

        this.add(lbTitulo, BorderLayout.CENTER);
        this.add(tempSombra, BorderLayout.SOUTH);
        this.add(izq, BorderLayout.EAST);
        this.add(der, BorderLayout.WEST);
    }

    public void agregarEventoBotonTutorial() {
        btnAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VnTutorial vn = new VnTutorial(View.getFrames()[0], true);
                vn.setVisible(true);
            }
        });
    }

}
