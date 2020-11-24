/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 * 
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app;

import grafos_app.controller.Controller;
import grafos_app.model.Model;
import grafos_app.view.View;

/**
 * Clase principal
 * @author WILMER
 */
public class GrafosAppMain {
    private static Model model;
    private static View view;
    private static Controller controller;

    /**
     * Permite inicial el modelo MVC
     */
    public GrafosAppMain() {
        model = new Model();
        view = new View();
        controller = new Controller(model, view);
    }
    
    /**
     * Inicia la interfaz de la app
     * @param args argumentos en la linea de comandos
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /*
        * Ejecuta la ventana principal de la aplicacion
        */
        java.awt.EventQueue.invokeLater(() -> {
            new GrafosAppMain();
            view.setVisible(true);
       });
    }
}
