/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Permite controlar el disenho de la app
 *
 * @author WILMER
 */
public interface Patron {

    /**
     * Variables de ancho y alto de la pantalla donde se ejecuta la app. Ayuda a
     * mantener la relacion de aspecto en diferentes resoluciones
     */
    public static final int ANCHO = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int ALTO = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final ArrayList<Image> ICONS = crearListaIconos();

    public static final int ICON_CAB = (ANCHO > 1420) ? 32 : 21;
    public static final int ICON_INFOR = (ANCHO > 1420) ? 25 : 17;
    public static final int TUTORIAL = (ANCHO > 1420) ? 1920 : 1366;

    public static final int BOTON_AZUL = 0;
    public static final int BOTON_BLANCO = 1;

    public static int MARGEN = (int) (ANCHO * 0.007); // ~5
    public static int MARGEN_2 = (int) (ANCHO * 0.003); // ~5
    public static int RADIO = (int) (ANCHO * 0.011);  // ~10

    public static final Color COLOR_PRINCIPAL = new Color(255, 255, 255);
    public static final Color COLOR_SECUNDARIO = new Color(245, 245, 245);
    public static final Color COLOR_TERCIARIO = new Color(225, 225, 225);

    public static final Color COLOR_HOVER_AZUL = new Color(10, 210, 255);
    public static final Color COLOR_HOVER_GRIS = new Color(247, 247, 247);

    public static final Color COLOR_CLICK_AZUL = new Color(20, 220, 255);
    public static final Color COLOR_CLICK_GRIS = new Color(240, 240, 240);

    public static final Color COLOR_ACENTUADOR = new Color(0, 196, 255);

    public static final Color FONT_PRINCIPAL = new Color(102, 102, 102);
    public static final Color FONT_SECUNDARIO = new Color(150, 150, 150);
    public static final Color FONT_ACENTUADOR = new Color(255, 255, 255);

    public static Font INTER_MEDIUM_18 = cambiarFuente("Inter-Medium-slnt=0", 18);
    public static Font INTER_MEDIUM_16 = cambiarFuente("Inter-Medium-slnt=0", 16);
    public static Font INTER_MEDIUM_12 = cambiarFuente("Inter-Medium-slnt=0", 12);

    public static final Font INTER_LIGTH_18 = cambiarFuente("Inter-Light-slnt=0", 18);
    public static final Font INTER_LIGTH_16 = cambiarFuente("Inter-Light-slnt=0", 16);
    public static final Font INTER_LIGTH_12 = cambiarFuente("Inter-Light-slnt=0", 12);

    public static final Font INTER_PRINCIPAL = definirTamanho(0);
    public static final Font INTER_SECUNDARIA = definirTamanho(1);

    /**
     * NO USAR
     *
     * @param font
     * @param px
     * @return
     */
    public static Font cambiarFuente(String font, int px) {
        Font fuente = null;
        InputStream myStream;
        try {
            myStream = new BufferedInputStream(new FileInputStream("src/fonts/" + font + ".ttf"));
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, px);
        } catch (FontFormatException | IOException ex) {
        }
        return fuente;
    }

    /**
     * NO USAR
     * @param i
     * @return
     */
    public static Font definirTamanho(int i) {
        if (ANCHO >= 1440) {
            if (i == 0) {
                return INTER_MEDIUM_16;
            } else {
                return INTER_LIGTH_16;
            }
        } else {
            if (i == 0) {
                return INTER_MEDIUM_12;
            } else {
                return INTER_LIGTH_12;
            }
        }
    }

    public static ArrayList<Image> crearListaIconos() {

        ArrayList<Image> array = new ArrayList<>();
        int s = 16;
        int numIcons = 7;
        for (int i = 0; i < numIcons; i++) {
            Image icon = new ImageIcon("./src/icons/1x/icon-" + s + ".png").getImage();
            array.add(icon);
            s *= 2;
        }
        return array;
    }
}
