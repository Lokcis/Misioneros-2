package interfaz;

import gfutria.SearchStateSpaces;
import java.util.ArrayList;
import mundo.Misionero;

public class interfazApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Misionero misionero;
        ArrayList lst = new ArrayList();
        SearchStateSpaces sss;

        misionero = new Misionero();
        sss = new SearchStateSpaces("0M " + "0C " + "3M " + "3C " + false, misionero, 5);

        lst = sss.solve();
        int i = 0;

        while (i < lst.size()) {
            System.out.println(lst.get(i));
            i++;
        }

    }

    public static void view(Misionero misionero) {
        System.out.println("El bote está en: " + (misionero.getBote() ? "la izquierda" : "la derecha"));
        System.out.println("Isla izquierda \n Misioneros: " + misionero.getMisionerosIzq() + " Canibales:  " + misionero.getCanibalesIzq());
        System.out.println("Isla Derecha \n Misioneros: " + misionero.getMisionerosDer() + " Canibales:  " + misionero.getCanibalesDer());
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }
}
