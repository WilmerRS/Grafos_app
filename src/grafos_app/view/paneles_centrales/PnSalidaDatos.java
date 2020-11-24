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
import grafos_app.view.RoundedPanel;
import grafos_app.view.TextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class PnSalidaDatos extends RoundedPanel implements Patron {

    private final String TITULO_SALIDA = "Salida de datos";
    private final String GRAFO = "Grafo: ";
    private final String TEOREMA = "Sumatoria de grados";
    private final String TIPO_GRAFO = "Tipo de grafo:";
    private final String GRADO_NODO = "Grados de los vertices:";
    private final String VERTICES = "Número de vertices:";
    private final String ARISTAS = "Número de aristas:";

    private RoundedPanel pnFondo;
    private JPanel pnCentral;

    private JLabel lbTitulo;
    private JLabel lbGrafo;
    private JLabel lbTeorema;
    private JLabel lbTipoGrafo;
    private JLabel lbGradoNodo;
    private JLabel lbVertice;
    private JLabel lbAristas;

    private TextField txtGrafo;
    private TextField txtTeorema;
    private TextField txtTipoGrafo;
    private TextField txtGradoNodo;
    private TextField txtVertice;
    private TextField txtAristas;

    public PnSalidaDatos() {
        super(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_PRINCIPAL);

        lbTitulo = new JLabel(TITULO_SALIDA);
        lbTitulo.setFont(INTER_PRINCIPAL);
        lbTitulo.setBackground(FONT_PRINCIPAL);

        lbGrafo = new JLabel(GRAFO);
        lbGrafo.setFont(INTER_SECUNDARIA);
        lbGrafo.setBackground(FONT_PRINCIPAL);

        lbTeorema = new JLabel(TEOREMA);
        lbTeorema.setFont(INTER_SECUNDARIA);
        lbTeorema.setBackground(FONT_PRINCIPAL);

        lbTipoGrafo = new JLabel(TIPO_GRAFO);
        lbTipoGrafo.setFont(INTER_SECUNDARIA);
        lbTipoGrafo.setBackground(FONT_PRINCIPAL);

        lbGradoNodo = new JLabel(GRADO_NODO);
        lbGradoNodo.setFont(INTER_SECUNDARIA);
        lbGradoNodo.setBackground(FONT_PRINCIPAL);

        lbVertice = new JLabel(VERTICES);
        lbVertice.setFont(INTER_SECUNDARIA);
        lbVertice.setBackground(FONT_PRINCIPAL);
        
        lbAristas = new JLabel(ARISTAS);
        lbAristas.setFont(INTER_SECUNDARIA);
        lbAristas.setBackground(FONT_PRINCIPAL);

        txtGrafo = new TextField(new Dimension(0, (int) (ALTO * 0.05)), "E(G) = [{A, B}, {A, C}, {A, D}, {B, C}, {B, E}, {C, D}, {C, E}]", TextField.RESTRICCION_NO_EDITABLE);
        txtTeorema = new TextField(new Dimension((int) (ANCHO * 0.1), 0), "", TextField.RESTRICCION_NO_EDITABLE);
        txtTipoGrafo = new TextField(new Dimension(0, (int) (ALTO * 0.05)), "", TextField.RESTRICCION_NO_EDITABLE);
        txtGradoNodo = new TextField(new Dimension(0, 0), "", TextField.RESTRICCION_NO_EDITABLE);
        txtVertice = new TextField(new Dimension((int) (ANCHO * 0.1), 0), "", TextField.RESTRICCION_NO_EDITABLE);
        txtAristas = new TextField(new Dimension((int) (ANCHO * 0.1), 0), "", TextField.RESTRICCION_NO_EDITABLE);

        JPanel pnGrafo = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnGrafo.setOpaque(false);
        pnGrafo.add(lbGrafo, BorderLayout.NORTH);
        pnGrafo.add(txtGrafo, BorderLayout.CENTER);

        JPanel pnVertices = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnVertices.setOpaque(false);
        pnVertices.add(lbVertice, BorderLayout.NORTH);
        pnVertices.add(txtVertice, BorderLayout.CENTER);

        JPanel pnTipoGrafo = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnTipoGrafo.setOpaque(false);
        pnTipoGrafo.add(lbTipoGrafo, BorderLayout.NORTH);
        pnTipoGrafo.add(txtTipoGrafo, BorderLayout.CENTER);

        JPanel pnTeorema = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnTeorema.setOpaque(false);
        pnTeorema.add(lbTeorema, BorderLayout.NORTH);
        pnTeorema.add(txtTeorema, BorderLayout.CENTER);

        JPanel pnAristas = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnAristas.setOpaque(false);
        pnAristas.add(lbAristas, BorderLayout.NORTH);
        pnAristas.add(txtAristas, BorderLayout.CENTER);
        
        JPanel pnGradoNodo = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnGradoNodo.setOpaque(false);
        pnGradoNodo.add(lbGradoNodo, BorderLayout.NORTH);
        pnGradoNodo.add(txtGradoNodo, BorderLayout.CENTER);

        JPanel pnArriba = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnArriba.setOpaque(false);

        pnArriba.add(pnGrafo, BorderLayout.CENTER);
        pnArriba.add(pnVertices, BorderLayout.EAST);

        JPanel pnAbajo = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnAbajo.setOpaque(false);

        JPanel temp = new JPanel(new GridLayout(1, 2, MARGEN_2, MARGEN_2));
        temp.setOpaque(false);
        temp.add(pnTeorema);
        temp.add(pnAristas);
        temp.add(pnGradoNodo);

        pnAbajo.add(pnTipoGrafo, BorderLayout.CENTER);
        pnAbajo.add(temp, BorderLayout.EAST);

        pnCentral = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pnCentral.setOpaque(false);

        pnCentral.add(lbTitulo, BorderLayout.NORTH);
        pnCentral.add(pnArriba, BorderLayout.CENTER);
        pnCentral.add(pnAbajo, BorderLayout.SOUTH);

        pnFondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        pnFondo.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnFondo.setBackground(COLOR_SECUNDARIO);
        pnFondo.add(pnCentral, BorderLayout.CENTER);
        hacerMagenes();

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

    public RoundedPanel getPnFondo() {
        return pnFondo;
    }

    public void setPnFondo(RoundedPanel pnFondo) {
        this.pnFondo = pnFondo;
    }

    public JPanel getPnCentral() {
        return pnCentral;
    }

    public void setPnCentral(JPanel pnCentral) {
        this.pnCentral = pnCentral;
    }

    public JLabel getLbTitulo() {
        return lbTitulo;
    }

    public void setLbTitulo(JLabel lbTitulo) {
        this.lbTitulo = lbTitulo;
    }

    public JLabel getLbGrafo() {
        return lbGrafo;
    }

    public void setLbGrafo(JLabel lbGrafo) {
        this.lbGrafo = lbGrafo;
    }

    public JLabel getLbTeorema() {
        return lbTeorema;
    }

    public void setLbTeorema(JLabel lbTeorema) {
        this.lbTeorema = lbTeorema;
    }

    public JLabel getLbTipoGrafo() {
        return lbTipoGrafo;
    }

    public void setLbTipoGrafo(JLabel lbTipoGrafo) {
        this.lbTipoGrafo = lbTipoGrafo;
    }

    public JLabel getLbGradoNodo() {
        return lbGradoNodo;
    }

    public void setLbGradoNodo(JLabel lbGradoNodo) {
        this.lbGradoNodo = lbGradoNodo;
    }

    public JLabel getLbVertice() {
        return lbVertice;
    }

    public void setLbVertice(JLabel lbVertice) {
        this.lbVertice = lbVertice;
    }

    public TextField getTxtGrafo() {
        return txtGrafo;
    }

    public void setTxtGrafo(TextField txtGrafo) {
        this.txtGrafo = txtGrafo;
    }

    public TextField getTxtTeorema() {
        return txtTeorema;
    }

    public void setTxtTeorema(TextField txtTeorema) {
        this.txtTeorema = txtTeorema;
    }

    public TextField getTxtTipoGrafo() {
        return txtTipoGrafo;
    }

    public void setTxtTipoGrafo(TextField txtTipoGrafo) {
        this.txtTipoGrafo = txtTipoGrafo;
    }

    public TextField getTxtGradoNodo() {
        return txtGradoNodo;
    }

    public void setTxtGradoNodo(TextField txtGradoNodo) {
        this.txtGradoNodo = txtGradoNodo;
    }

    public TextField getTxtVertice() {
        return txtVertice;
    }

    public void setTxtVertice(TextField txtVertice) {
        this.txtVertice = txtVertice;
    }

    public JLabel getLbAristas() {
        return lbAristas;
    }

    public void setLbAristas(JLabel lbAristas) {
        this.lbAristas = lbAristas;
    }

    public TextField getTxtAristas() {
        return txtAristas;
    }

    public void setTxtAristas(TextField txtAristas) {
        this.txtAristas = txtAristas;
    }

}
