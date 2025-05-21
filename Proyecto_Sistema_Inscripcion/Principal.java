import java.util.HashMap;
public class Principal{



        public static void main(String[] args) {
        Directorio.inicializar_asignarutras();
        Directorio.inicializar_profesores();
        Directorio.inicializarGrupos();
        Utilerias menu = new Utilerias();
        menu.menu();
    }
}