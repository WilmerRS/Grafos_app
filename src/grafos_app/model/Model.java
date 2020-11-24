/**
 * GRAFOS APP
 * Aplicacion de escritorio realizada para crear y hacer groficamente un grafo no
 * dirigido. Permite evaluar las propiedades de un grafo tanto simple como multiple.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * 2020 - 2
 */
package grafos_app.model;

import java.util.ArrayList;

/**
 *
 * @author WILMER
 */
public class Model {

    private Grafo grafo;

    public Model() {
        grafo = new Grafo();
    }

    private Grafo iniciarGrafo() {
        return null;
    }

    

    public ArrayList<Character> crearGrafo(int n) {
        ArrayList<Character> temp = new ArrayList<>();
        char a = 32;
        temp.add(a);

        int limite = (n * n) + (2 * n) + 1;
        char f = 65;
        char c = 65;
        char cero = 48;
        int i = 1;
        while (i < limite) {
            if (i <= n) {
                temp.add(f);
                f++;
            } else {
                if (i % (n + 1) == 0) {
                    temp.add(c);
                    c++;
                } else {
                    temp.add(cero);
                }
            }
            i++;
        }
        return temp;
    }

    
    
    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

}
