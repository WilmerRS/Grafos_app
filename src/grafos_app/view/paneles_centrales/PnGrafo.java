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
import grafos_app.view.RoundedPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author WILMER
 */
public class PnGrafo extends RoundedPanel implements Patron {

    private final String TITULO = "Grafo";
    private final String GUARDAR = "Guardar";

    private PnLienzo pnLienzo;

    private JLabel lbTitulo;

    private Boton btnGuardar;
    private RoundedPanel pnCentralFondo;
    private JPanel pnCentral;

    
    private JFileChooser seleccionar;
    private File archivo;
    private FileInputStream entrada;
    private FileOutputStream salida;
    
    public PnGrafo() {
        super(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout(MARGEN, MARGEN));
        this.setBackground(COLOR_PRINCIPAL);

        JPanel pnArriba = new JPanel(new BorderLayout());
        pnArriba.setOpaque(false);

        pnCentral = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pnCentral.setOpaque(false);

        lbTitulo = new JLabel(TITULO);
        lbTitulo.setFont(INTER_PRINCIPAL);
        lbTitulo.setForeground(FONT_PRINCIPAL);
        lbTitulo.setFont(INTER_PRINCIPAL);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);

        btnGuardar = new Boton(new Dimension((int) (ANCHO * 0.07), (int) (ALTO * 0.033)), GUARDAR, BOTON_AZUL);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnGuardarEvent(ae);
            }
        });

        JPanel relleno = new JPanel(new BorderLayout());
        relleno.setPreferredSize(new Dimension((int) (ANCHO * 0.07), (int) (ALTO * 0.033)));
        relleno.setOpaque(false);

        pnArriba.add(lbTitulo, BorderLayout.CENTER);
        pnArriba.add(btnGuardar, BorderLayout.EAST);
        pnArriba.add(relleno, BorderLayout.WEST);

        pnLienzo = new PnLienzo();

        pnCentral.add(pnArriba, BorderLayout.NORTH);
        pnCentral.add(pnLienzo, BorderLayout.CENTER);

        pnCentralFondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        pnCentralFondo.setLayout(new BorderLayout(MARGEN, MARGEN));
        pnCentralFondo.setBackground(COLOR_SECUNDARIO);
        pnCentralFondo.add(pnCentral, BorderLayout.CENTER);
        hacerMagenes();

        this.add(pnCentralFondo);

    }

    private void btnGuardarEvent(java.awt.event.ActionEvent evt) {
        seleccionar = new JFileChooser();
        seleccionar.setDialogTitle("Guardar Imagen");
        seleccionar.setFileFilter(new FileNameExtensionFilter("JPEG (*.jpg;*.jpeg)", "jpg", "jpeg"));
        seleccionar.setFileFilter(new FileNameExtensionFilter("PNG (*.png)", "png"));
        seleccionar.setFileFilter(new FileNameExtensionFilter("Mapa de Bits(*.bmp)", "bmp"));
        seleccionar.setFileFilter(new FileNameExtensionFilter("Todas las imágenes(*.jpg;*.jpeg;*.png;*.bmp)", "jpg", "jpeg", "png", "bmp"));
        seleccionar.setMultiSelectionEnabled(false);
        seleccionar.setName("Formula");
        if (seleccionar.showDialog(this, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith(".jpg") || archivo.getName().endsWith(".png")
                    || archivo.getName().endsWith(".bmp") || archivo.getName().endsWith(".jpeg")) {
                try {
                    BufferedImage imagen = new BufferedImage(pnLienzo.getWidth(), pnLienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    pnLienzo.paint(imagen.getGraphics());
                    guardarArchivo(archivo, imagen);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el sistema.\nIntente nuevamente.", "Error al guardar imagen",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            } else {
                archivo = null;
                JOptionPane.showMessageDialog(null, "El fórmato de imagen introducido no está permitido", "Error al guardar imagen",
                        JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./src/icons/1x/icon-64.png"));
            }
        }
    }

    public void guardarArchivo(File pFile, BufferedImage imagen) throws IOException {
        try {
            salida = new FileOutputStream(pFile);
            String formato = archivo.getName();
            if (formato.endsWith("jpg")) {
                ImageIO.write(imagen, "jpg", pFile);
            } else if (formato.endsWith("png")) {
                ImageIO.write(imagen, "png", pFile);
            } else if (formato.endsWith("bmp")) {
                ImageIO.write(imagen, "bmp", pFile);
            } else if (formato.endsWith("jpeg")) {
                ImageIO.write(imagen, "jpeg", pFile);
            }
            JOptionPane.showMessageDialog(null, "Imagen guardada exitosamente", "Imagen guardada",
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./src/icons/1x/icon-64.png"));
        } catch (FileNotFoundException ex) {
        }
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

    public PnLienzo getPnLienzo() {
        return pnLienzo;
    }

    public void setPnLienzo(PnLienzo pnLienzo) {
        pnCentral.remove(this.pnLienzo);
        this.pnLienzo = pnLienzo;
        pnCentral.add(pnLienzo, BorderLayout.CENTER);
    }

}
