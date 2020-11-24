/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.view.paneles_centrales;

import grafos_app.view.Boton;
import grafos_app.view.Patron;
import static grafos_app.view.Patron.COLOR_PRINCIPAL;
import grafos_app.view.RoundedPanel;
import grafos_app.view.TextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author WILMER
 */
public class PnMatriz extends RoundedPanel implements Patron {

    private final String TITULO_PANEL = "Grafos matriciales";
    private final String SUB_TAMANHO = "Número de nodos:";
    private final String SUB_MATRIZ = "Digite el grafo matricial:";
    private final String BTN_CALCULAR = "Calcular";
    private final String BTN_CREAR_MATRIZ = "Crear matriz";
    private final String BTN_LIMPIAR = "Limpiar";

    private RoundedPanel pnCentralFondo;
    private JPanel pnCentral;

    private JLabel lbTituloPanel;
    private JLabel lbTamanho;
    private JLabel lbMatriz;

    private JPanel pnEntradaDatos;
    private JPanel pnMatriz;
    private JPanel pnRegillaBtn;
    private JPanel pnBotones;

    private Boton btnCalcular;
    private Boton btnCrearMatriz;
    private Boton btnLimpiar;

    private TextField txtTamanho;

    private JScrollPane spMatriz;

    private int numVertices = 2 + 1;

    public PnMatriz() {
        super(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_PRINCIPAL);
        this.setPreferredSize(new Dimension((int) (ANCHO * 0.2), (int) (ALTO * 0.44)));

        lbTituloPanel = new JLabel(TITULO_PANEL);
        lbTituloPanel.setFont(INTER_PRINCIPAL);
        lbTituloPanel.setBackground(FONT_PRINCIPAL);

        lbTamanho = new JLabel(SUB_TAMANHO);
        lbTamanho.setFont(INTER_SECUNDARIA);
        lbTamanho.setBackground(FONT_PRINCIPAL);

        lbMatriz = new JLabel(SUB_MATRIZ);
        lbMatriz.setFont(INTER_SECUNDARIA);
        lbMatriz.setBackground(FONT_PRINCIPAL);

        pnMatriz = new JPanel();
        pnMatriz.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnMatriz.setOpaque(false);

        txtTamanho = new TextField(new Dimension(0, (int) (ALTO * 0.05)), numVertices - 1 + "", TextField.RESTRICCION_NUMEROS);
        btnCrearMatriz = new Boton(new Dimension(0, (int) (ALTO * 0.05)), BTN_CREAR_MATRIZ, BOTON_BLANCO);

        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));

        pnEntradaDatos = new JPanel();
        pnEntradaDatos.setLayout(new GridLayout(1, 2, MARGEN, MARGEN));
        pnEntradaDatos.setOpaque(false);

        temp.add(lbTamanho, BorderLayout.NORTH);
        temp.add(pnEntradaDatos, BorderLayout.CENTER);

        pnEntradaDatos.add(txtTamanho);
        pnEntradaDatos.add(btnCrearMatriz);

        pnRegillaBtn = new JPanel();
        pnRegillaBtn.setLayout(new GridLayout(numVertices, numVertices, MARGEN_2, MARGEN_2));
        pnRegillaBtn.setBackground(COLOR_PRINCIPAL);
//        actualizarMatriz();

        JPanel temp_2 = new JPanel();
        temp_2.setOpaque(false);
        temp_2.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));

        spMatriz = new JScrollPane(pnRegillaBtn,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spMatriz.setBorder(null);
        spMatriz.setBackground(COLOR_PRINCIPAL);
        spMatriz.setViewportView(pnRegillaBtn);

        spMatriz.getHorizontalScrollBar().setPreferredSize(new Dimension(6, 6));
        spMatriz.getHorizontalScrollBar().setBorder(null);

        spMatriz.getVerticalScrollBar().setPreferredSize(new Dimension(6, 6));
        spMatriz.getVerticalScrollBar().setBorder(null);

        temp_2.add(lbMatriz, BorderLayout.NORTH);
        temp_2.add(spMatriz, BorderLayout.CENTER);

        pnMatriz.add(temp, BorderLayout.NORTH);
        pnMatriz.add(temp_2, BorderLayout.CENTER);

        btnCalcular = new Boton(new Dimension(0, (int) (ALTO * 0.05)), BTN_CALCULAR, BOTON_AZUL);
        btnLimpiar = new Boton(new Dimension(0, (int) (ALTO * 0.05)), BTN_LIMPIAR, BOTON_BLANCO);

        pnBotones = new JPanel();
        pnBotones.setLayout(new GridLayout(1, 2, MARGEN, MARGEN));
        pnBotones.setOpaque(false);

        pnBotones.add(btnLimpiar);
        pnBotones.add(btnCalcular);

        pnCentral = new JPanel();
        pnCentral.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnCentral.setOpaque(false);

        pnCentral.add(lbTituloPanel, BorderLayout.NORTH);
        pnCentral.add(pnMatriz, BorderLayout.CENTER);
        pnCentral.add(pnBotones, BorderLayout.SOUTH);

        pnCentralFondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        pnCentralFondo.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnCentralFondo.setBackground(COLOR_SECUNDARIO);
        pnCentralFondo.add(pnCentral, BorderLayout.CENTER);
        hacerMagenes();

        this.add(pnCentralFondo);
    }

    public void actualizarMatriz(ArrayList<Character> aristas) {
        //Limpiar regilla
        pnRegillaBtn.removeAll();
        pnRegillaBtn.setLayout(new GridLayout(numVertices, numVertices, MARGEN_2, MARGEN_2));

        Dimension dm = new Dimension((int) (ANCHO * 0.028), (int) (ALTO * 0.03));
        TextField txt;
        int k = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == 0 && j == 0) {
                    txt = new TextField(dm, Character.toString(aristas.get(k)), TextField.RESTRICCION_NO_EDITABLE);
                    txt.getTxtField().setHorizontalAlignment(JTextField.CENTER);
                    pnRegillaBtn.add(txt);
                } else if (i == 0) {
                    txt = new TextField(dm, Character.toString(aristas.get(k)), TextField.RESTRICCION_LETRAS);
                    txt.getTxtField().setHorizontalAlignment(JTextField.CENTER);
                    txt.getSpTxtField().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    agregarCambios(txt);
                    pnRegillaBtn.add(txt);
                } else if (j == 0) {
                    txt = new TextField(dm, Character.toString(aristas.get(k)), TextField.RESTRICCION_LETRAS);
                    txt.getSpTxtField().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    txt.getTxtField().setHorizontalAlignment(JTextField.CENTER);
                    agregarCambios(txt);
                    pnRegillaBtn.add(txt);
                } else {
                    int indice = Boton.BTN_NO_DIAGONAL;
                    if (i == j) {
                        indice = Boton.BTN_DIAGONAL;
                    }
                    Boton temp = new Boton(dm, Character.toString(aristas.get(k)), BOTON_BLANCO, indice);

                    pnRegillaBtn.add(temp);
                }
                k++;
            }
        }
        addEventosBotonesMtz();
        pnRegillaBtn.updateUI();
    }
    
    private void agregarCambios(TextField txt) {
        txt.getTxtField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                actualizarTextos(txt);
            }
        });
    }

    private void actualizarTextos(TextField txt) {
        int i = numVertices;
        int j = 1;
        while (j < numVertices) {
            TextField txtFilas = (TextField) pnRegillaBtn.getComponent(i);
            TextField txtColumnas = (TextField) pnRegillaBtn.getComponent(j);

            String fila = txtFilas.getTxtField().getText();
            String columna = txtColumnas.getTxtField().getText();

            if (txt == txtFilas) {
                txtFilas.getTxtField().setText(columna);
                if (!existeVertice(fila, numVertices, numVertices * (numVertices - 1))) {
                    txtFilas.getTxtField().setText(fila);
                    txtColumnas.getTxtField().setText(fila);
                }
            } else {
                txtColumnas.getTxtField().setText(fila);
                if (!existeVertice(columna, 1, numVertices)) {
                    txtFilas.getTxtField().setText(columna);
                    txtColumnas.getTxtField().setText(columna);
                }
            }
            j += 1;
            i += numVertices;
        }
    }

    private void addEventosBotonesMtz() {
        int i = numVertices + 1;
        while (i < numVertices * numVertices) {
            Boton btn = (Boton) pnRegillaBtn.getComponent(i);
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    cambiarIndice(me, btn, btn.getIndice() == Boton.BTN_DIAGONAL);
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                }

                @Override
                public void mouseExited(MouseEvent me) {
                }
            });

            // recorrer solo el interior de la matriz
            if ((i + 1) % numVertices == 0) {
                i += 2;
            } else {
                i += 1;
            }
        }
    }

    private void cambiarIndice(MouseEvent me, Boton btn, boolean diagonal) {
        int cambio = 1;
        if (diagonal) {
            cambio = 2;
        }

        //Clic izquierdo
        if (me.getButton() == 1) {
            if (diagonal) {
                btn.getLbTexto().setText(cambio + "");
                return;
            }

            btn.getLbTexto().setText((Integer.parseInt(btn.getLbTexto().getText()) + cambio) + "");
            return;
        }

        //click derecho
        if (me.getButton() == 3) {
            if (!(Integer.parseInt(btn.getLbTexto().getText()) == 0)) {
                btn.getLbTexto().setText((Integer.parseInt(btn.getLbTexto().getText()) - cambio) + "");
            }
        }
    }

    private boolean existeVertice(String vertice, int inicio, int fin) {
        int i = inicio;
        while (i < fin) {
            TextField temp = (TextField) pnRegillaBtn.getComponent(i);
            if (temp.getTxtField().getText().equals(vertice.toUpperCase())) {
                return true;
            }
            i += inicio;
        }
        return false;
    }

    private void hacerMagenes() {
        int i = 0;
        JPanel izq = new JPanel();
        izq.setOpaque(false);
        izq.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setOpaque(false);
        der.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(der, BorderLayout.EAST);

        JPanel nor = new JPanel();
        nor.setOpaque(false);
        nor.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(nor, BorderLayout.NORTH);

        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.setPreferredSize(new Dimension(i, i));
        pnCentralFondo.add(sur, BorderLayout.SOUTH);
    }

    public Boton getBtnCalcular() {
        return btnCalcular;
    }

    public Boton getBtnCrearMatriz() {
        return btnCrearMatriz;
    }

    public Boton getBtnLimpiar() {
        return btnLimpiar;
    }

    public TextField getTxtTamanho() {
        return txtTamanho;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public JPanel getPnRegillaBtn() {
        return pnRegillaBtn;
    }

}
