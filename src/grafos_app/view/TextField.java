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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author WILMER
 */
public class TextField extends JPanel implements Patron {

    public static final int RESTRICCION_NUMEROS = 1;
    public static final int RESTRICCION_LETRAS = 2;
    public static final int RESTRICCION_NO_EDITABLE = 3;

    private static Color BACKGROUND = COLOR_SECUNDARIO;
    private static Color BORDER = COLOR_SECUNDARIO;

    private RoundedPanel pnFondo;
    private JTextField txtField;
    private JScrollPane spTxtField;
    private Dimension dimension;
    private String texto;
    private int restriccion;
    private String aux;

    public TextField(Dimension dimension, String texto) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.aux = texto;
        this.restriccion = 0;
        inicarComponentes();
    }

    public TextField(Dimension dimension, String texto, int restriccion) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.aux = texto;
        this.restriccion = restriccion;
        inicarComponentes();
    }

    private void inicarComponentes() {
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(null);
        this.setOpaque(false);
        this.setPreferredSize(dimension);
        this.setFocusable(false);

        txtField = new JTextField(texto);
        txtField.setForeground(FONT_PRINCIPAL);
        txtField.setFont(INTER_SECUNDARIA);
        txtField.setBorder(new Border() {
            @Override
            public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
            }

            @Override
            public Insets getBorderInsets(Component cmpnt) {
                return new Insets(2, 10, 2, 10);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
        txtField.setOpaque(false);
        txtField.setCaretColor(COLOR_ACENTUADOR);
        txtField.setSelectedTextColor(FONT_ACENTUADOR);
        txtField.setSelectionColor(COLOR_ACENTUADOR);
        txtField.setMargin(new java.awt.Insets(7, 7, 7, 7));

        spTxtField = new JScrollPane(txtField,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spTxtField.setBorder(null);
        spTxtField.setOpaque(false);
        spTxtField.getViewport().setOpaque(false);
        spTxtField.setViewportView(txtField);

        spTxtField.getHorizontalScrollBar().setPreferredSize(new Dimension(4,4));
        spTxtField.getHorizontalScrollBar().setBorder(null);
        
        pnFondo = new RoundedPanel(RADIO, BACKGROUND, BORDER);
        pnFondo.setLayout(new BorderLayout(4, 3));
        pnFondo.setBackground(COLOR_SECUNDARIO);
        pnFondo.add(spTxtField, BorderLayout.CENTER);
        hacerMagenes();

        addEventos();

        this.add(pnFondo);
    }

    private void hacerMagenes() {
        int i = 1;
        JPanel izq = new JPanel();
        izq.setOpaque(false);
        izq.setPreferredSize(new Dimension(i, i));
        pnFondo.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setOpaque(false);
        der.setPreferredSize(new Dimension(i, i));
        pnFondo.add(der, BorderLayout.EAST);

        JPanel nor = new JPanel();
        nor.setOpaque(false);
        nor.setPreferredSize(new Dimension(i, i));
        pnFondo.add(nor, BorderLayout.NORTH);

        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.setPreferredSize(new Dimension(i, i));
        pnFondo.add(sur, BorderLayout.SOUTH);
    }

    private void addEventos() {
        txtField.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                BORDER = COLOR_ACENTUADOR;
                pnFondo.actualizarPanel(RADIO, COLOR_SECUNDARIO, BORDER);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                BORDER = COLOR_SECUNDARIO;
                pnFondo.actualizarPanel(RADIO, BACKGROUND, BORDER);
            }
        });

        txtField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                controlarEntrada();
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                controlarEntrada();
            }
        });

        if (restriccion == RESTRICCION_NO_EDITABLE) {
            txtField.setEditable(false);
//            txtField.setEnabled(false);
        }
    }

    private void controlarEntrada() {
        String temp = txtField.getText();
        String texto = "";
        try {
            switch (restriccion) {
                case RESTRICCION_LETRAS:
                    if (((temp.charAt(temp.length() - 1) > 64 && temp.charAt(temp.length() - 1) < 91) // Letras mayusculas
                            || (temp.charAt(temp.length() - 1) > 96 && temp.charAt(temp.length() - 1) < 123))) {// Letras miniculas 
                        String temp1 = txtField.getText();

                        texto += (temp1.charAt(temp1.length() - 1) + "").toUpperCase();
                        txtField.setText(texto);
                        aux = texto;
                    } else {
                        txtField.setText(aux);
                    }
                    break;
                case RESTRICCION_NUMEROS:
                    if (!(temp.charAt(temp.length() - 1) >= 48 && temp.charAt(temp.length() - 1) <= 57)) { // Nume
                        char vector[] = temp.toCharArray();
                        for (int i = 0; i < vector.length - 1; i++) {
                            texto += (vector[i]);
                        }
                        txtField.setText(texto);
                    }
                    break;
            }
        } catch (Exception e) {
        }

    }

    public void setTexto(String text0) {
        txtField.setText(texto);
    }

    public JTextField getTxtField() {
        return txtField;
    }

    public String getAux() {
        return aux;
    }

    public JScrollPane getSpTxtField() {
        return spTxtField;
    }

    public void setSpTxtField(JScrollPane spTxtField) {
        this.spTxtField = spTxtField;
    }
}
