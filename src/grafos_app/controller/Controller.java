/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.controller;

import grafos_app.model.Model;
import grafos_app.view.Boton;
import grafos_app.view.TextField;
import grafos_app.view.View;
import grafos_app.view.paneles_centrales.PnLienzo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class Controller {

    private final Model model;
    private final View view;
    
    private LienzoContrll lienzoContrll;

    /**
     * Permite construir el controlador, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view Interfaz, parte visual del programa
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        configuracionesIniciales();
        lienzoContrll = new LienzoContrll();
        addEventos();
    }

    private void addEventos() {
        addEventoCalcular();
        addEventoLimpiar();
        addEventoCrearMatriz();
    }

    private void addEventoCalcular() {
        view.getPnCentral().getPnMatriz().getBtnCalcular().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int numV = view.getPnCentral().getPnMatriz().getNumVertices();
                boolean isGrafo = obtenerGrafo(view.getPnCentral().getPnMatriz().getPnRegillaBtn(), numV);
                if (isGrafo) {
//                    System.out.println();
                    String grafo = model.getGrafo().obtenerCadenaGrafo();
                    String tipo = model.getGrafo().tipoGrafo();
                    int aristas = model.getGrafo().contarAristas();
                    int sumGrados = (int) (model.getGrafo().sumatoriaGrados());

                    String grado = model.getGrafo().gradosGrafo();

                    PnLienzo ln = new PnLienzo(model.getGrafo());
                    view.getPnCentral().getPnGrafo().setPnLienzo(ln);
                    view.getPnCentral().getPnGrafo().getPnLienzo().updateUI();
                    lienzoContrll.setPnLienzo(ln);

                    view.getPnCentral().getPnSalidaDatos().getTxtGrafo().getTxtField().setText(grafo);
                    view.getPnCentral().getPnSalidaDatos().getTxtVertice().getTxtField().setText((numV - 1) + "");
                    view.getPnCentral().getPnSalidaDatos().getTxtTipoGrafo().getTxtField().setText(tipo);
                    view.getPnCentral().getPnSalidaDatos().getTxtTeorema().getTxtField().setText(sumGrados + "");
                    view.getPnCentral().getPnSalidaDatos().getTxtAristas().getTxtField().setText(aristas + "");
                    view.getPnCentral().getPnSalidaDatos().getTxtGradoNodo().getTxtField().setText(grado);
                } else {
                    valoresPorDefecto();
                }
            }
        });
    }

    private void valoresPorDefecto() {
        //Limpiar grafo
        model.getGrafo().limpiarGrafo();
        String grafo = model.getGrafo().obtenerCadenaGrafo();

        PnLienzo ln = new PnLienzo();
        view.getPnCentral().getPnGrafo().setPnLienzo(ln);
        view.getPnCentral().getPnGrafo().getPnLienzo().updateUI();
        lienzoContrll.setPnLienzo(ln);
        
        
        String grado = model.getGrafo().gradosGrafo();

        view.getPnCentral().getPnSalidaDatos().getTxtGrafo().getTxtField().setText(grafo);
        view.getPnCentral().getPnSalidaDatos().getTxtTipoGrafo().getTxtField().setText("No es un grafo.");
        view.getPnCentral().getPnSalidaDatos().getTxtTipoGrafo().getTxtField().requestFocus();
        view.getPnCentral().getPnSalidaDatos().getTxtTeorema().getTxtField().setText("0");
        view.getPnCentral().getPnSalidaDatos().getTxtAristas().getTxtField().setText("0");
        view.getPnCentral().getPnSalidaDatos().getTxtGradoNodo().getTxtField().setText(grado);
    }

    private void addEventoLimpiar() {
        view.getPnCentral().getPnMatriz().getBtnLimpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int tam = view.getPnCentral().getPnMatriz().getNumVertices();
                view.getPnCentral().getPnMatriz().actualizarMatriz(model.crearGrafo(tam - 1));
            }
        });
    }

    private void addEventoCrearMatriz() {
        view.getPnCentral().getPnMatriz().getBtnCrearMatriz().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int tam = Integer.parseInt(view.getPnCentral().getPnMatriz().getTxtTamanho().getTxtField().getText());
                    if (tam > 0) {
                        view.getPnCentral().getPnMatriz().setNumVertices(tam + 1);
                        view.getPnCentral().getPnMatriz().actualizarMatriz(model.crearGrafo(tam));
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número mayor a 0.\n", "Error en la entrada",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./src/icons/1x/icon-64.png"));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número entero.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./src/icons/1x/icon-64.png"));
                }
            }
        });
    }

    private void configuracionesIniciales() {
        view.getPnCentral().getPnMatriz().setNumVertices(2 + 1);
        view.getPnCentral().getPnMatriz().actualizarMatriz(model.crearGrafo(2));
        String grafo = model.getGrafo().obtenerCadenaGrafo();
        view.getPnCentral().getPnSalidaDatos().getTxtGrafo().getTxtField().setText(grafo);
        view.getPnCentral().getPnSalidaDatos().getTxtVertice().getTxtField().setText((2) + "");
        view.getPnCentral().getPnSalidaDatos().getTxtTipoGrafo().getTxtField().setText("No es un grafo.");
        view.getPnCentral().getPnSalidaDatos().getTxtTeorema().getTxtField().setText("0");
        view.getPnCentral().getPnSalidaDatos().getTxtAristas().getTxtField().setText("0");
        
        String grado = model.getGrafo().gradosGrafo();
        view.getPnCentral().getPnSalidaDatos().getTxtGradoNodo().getTxtField().setText(grado);
    }

    public boolean obtenerGrafo(JPanel panel, int numVertices) {
        //Limpiar grafo
        model.getGrafo().limpiarGrafo();

        // Pasar a matriz de String
        String[][] matriz = convertirMatriz(panel, numVertices);
        if (!model.getGrafo().isGrafo(matriz)) {
            return false;
        }

        int i = 1;
        // Obtener vertices
        while (i < numVertices) {
            TextField txt = (TextField) panel.getComponent(i);
            if (txt.getTxtField().getText().isEmpty()) {
                return false;
            }
            boolean aristaRep = model.getGrafo().agregarVertice(txt.getTxtField().getText().toCharArray()[0]);
            if (!aristaRep) {
                return false;
            }
            i++;
        }

        // Obtener aristas
        int limite = numVertices * numVertices;
        char vertice_1 = 0;
        char vertice_2 = 0;
//        System.out.println("limite[posiciones] " + limite);

        int k = 1;
        int salto = 1;
        while (i < limite) {
//            System.out.println(i);
            // Vertices 
            if (i % (numVertices) == 0) {
                TextField txt = (TextField) panel.getComponent(i);
                vertice_2 = txt.getTxtField().getText().toCharArray()[0];
                k = salto;
                i += salto;
//                i++;
//                k = 1;
                salto++;
            } else {
                // Aristas
//                Point posFinal = model.getGrafo().obtenerPosicion(vertice_1);
                Boton btn = (Boton) panel.getComponent(i);
                int cantidad = Integer.parseInt(btn.getLbTexto().getText());

                TextField txt = (TextField) panel.getComponent(k);
                vertice_1 = txt.getTxtField().getText().toCharArray()[0];

                // Si es un lazo
//                if (btn.getIndice() == Boton.BTN_DIAGONAL && cantidad != 0) {
//                    cantidad = 1;
//                }
                boolean temp = model.getGrafo().agregarArista(vertice_2, vertice_1, cantidad);
                k++;
                i++;
            }
        }
        return true;
    }

    private String[][] convertirMatriz(JPanel panel, int numVertices) {
        String[][] matriz = new String[numVertices][numVertices];
        String[][] matriz_2 = new String[numVertices - 1][numVertices - 1];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == 0 || j == 0) {
                    TextField txt = (TextField) panel.getComponent((i * numVertices) + j);
                    matriz[i][j] = txt.getTxtField().getText();
                } else {
                    Boton btn = (Boton) panel.getComponent((i * numVertices) + j);
                    matriz[i][j] = btn.getLbTexto().getText();
                }
            }
        }

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                matriz_2[i - 1][j - 1] = matriz[i][j];
            }
        }

        return matriz_2;
    }

}
