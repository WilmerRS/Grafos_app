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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author WILMER
 */
public class Boton extends JButton implements Patron {

    public static final int BTN_DIAGONAL = 1;
    public static final int BTN_NO_DIAGONAL = 0;
    
    private RoundedPanel pnFondo;
    private Dimension dimension;
    private JLabel lbTexto;

    private String texto;

    public Color BACKGROUND;
    public Color BORDER;
    public Color FOREGROUND;
    public Color HOVER;
    public Color CLICK;
    public int TIPO;
    private int indice;
    
    public Boton(Dimension dimension, String texto, int tipo) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.TIPO = tipo;
        tipoBoton(tipo);
        inicarComponentes();
    }
    public Boton(Dimension dimension, String texto, int tipo, int indice) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.TIPO = tipo;
        this.indice = indice;
        tipoBoton(tipo);
        inicarComponentes();
    }

    private void tipoBoton(int i) {
        if (i == BOTON_AZUL) {
            BACKGROUND = COLOR_ACENTUADOR;
            FOREGROUND = FONT_ACENTUADOR;
            HOVER = COLOR_HOVER_AZUL;
            CLICK = COLOR_CLICK_AZUL;
            BORDER = COLOR_ACENTUADOR;
        } else {
            BACKGROUND = COLOR_PRINCIPAL;
            FOREGROUND = FONT_PRINCIPAL;
            HOVER = COLOR_HOVER_GRIS;
            CLICK = COLOR_CLICK_GRIS;
            BORDER = FONT_PRINCIPAL;
        }
    }

    private void inicarComponentes() {
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(null);
        this.setOpaque(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        lbTexto = new JLabel(texto);
        lbTexto.setForeground(FOREGROUND);
        lbTexto.setFont(INTER_PRINCIPAL);
        lbTexto.setHorizontalAlignment(SwingConstants.CENTER);
        lbTexto.setVerticalAlignment(SwingConstants.CENTER);
        lbTexto.setOpaque(false);

        pnFondo = new RoundedPanel(RADIO, BACKGROUND, BORDER);
        pnFondo.setLayout(new BorderLayout());
        pnFondo.setPreferredSize(dimension);
        pnFondo.add(lbTexto);
        addEventos();

        this.add(pnFondo);
    }

    private void addEventos() {
        // EVENTOS DEL MOUSE
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, HOVER, BORDER);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, BACKGROUND, BORDER);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, CLICK, BORDER);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, HOVER, BORDER);
            }
        });

        // EVENTOS DEL FOCO
        this.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                pnFondo.actualizarPanel(RADIO, HOVER, BORDER);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                pnFondo.actualizarPanel(RADIO, BACKGROUND, BORDER);
            }
        });
        
    }

    public JLabel getLbTexto() {
        return lbTexto;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
