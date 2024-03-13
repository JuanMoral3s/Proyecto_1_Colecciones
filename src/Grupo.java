import java.util.*;

public class Grupo {

    private int asignaturaImpartida;
    private String  profesor;
    private int alumnosInscritos = 0;

    public static int gruposTotales = 0;

    private int numeroDeGrupo;

    public static ArrayList<Grupo> grupos = new ArrayList<Grupo>();

    public Grupo(int asignaturaImpartida,String profesor){
        this.asignaturaImpartida = asignaturaImpartida;
        this.profesor = profesor;
        gruposTotales++;
        this.numeroDeGrupo = gruposTotales;
    }

    public void alumnoInscrito(){
        this.alumnosInscritos += 1;
    }

    public int getNumeroDeGrupo(){
        return this.numeroDeGrupo;
    }

    public int getAlumnosInscritos() {
        return alumnosInscritos;
    }

    public int getAsignaturaImpartida() {
        return asignaturaImpartida;
    }

    public String getProfesor() {
        return profesor;
    }

    public static ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public static void anadir_a_lista(int asignaturaImpartida,String profesor){
        Grupo nuevo_grupo = new Grupo(asignaturaImpartida,profesor);
        grupos.add(nuevo_grupo);
    }

    public static void imprimirGrupos(){
        for (Grupo grupo : grupos) {
            System.out.println("------------------------------------------------------------");
            System.out.println(" Asignatura: " + Asignatura.asignaturaPorClave(grupo.getAsignaturaImpartida()));
            System.out.printf(" Clave: " + grupo.getAsignaturaImpartida());
            System.out.println(" Profesor: " + grupo.getProfesor());
            System.out.printf(" Grupo: " + grupo.getNumeroDeGrupo());
            System.out.println(" Alumnos Inscritos: " + grupo.getAlumnosInscritos());
        }
        System.out.println("------------------------------------------------------------");
    }


    public static Grupo buscadorDeGrupos(int clave){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Grupo> gruposDisponibles = new ArrayList<>();
        boolean hayGrupos = false;
            for (Grupo grupo : grupos) {
            if (grupo.asignaturaImpartida == clave) {
                System.out.println("Grupo: " + grupo.getNumeroDeGrupo() + " Clave Asignatura: " + grupo.getAsignaturaImpartida());
                System.out.println("Asignatura: " + Asignatura.asignaturaPorClave(grupo.getAsignaturaImpartida()));
                System.out.println("Profesor: " + grupo.getProfesor() + " Alumnos Inscritos: " + grupo.getAlumnosInscritos());
                gruposDisponibles.add(grupo);
                hayGrupos = true;
            }
        }
        if (!hayGrupos){
            return null;
        }
        System.out.println("Grupos disponibles de la materia "+Asignatura.asignaturaPorClave(clave));
        System.out.println("Introduce el numero de grupo que deseas inscribir: ");
        int grupoInscrito = scanner.nextInt();
        for (int i = 0; i < gruposDisponibles.size();i++){
            if (grupoInscrito == gruposDisponibles.get(i).getNumeroDeGrupo()){
                System.out.println("Ha escogido el grupo: " + grupoInscrito);

                return gruposDisponibles.get(i);
            }
        }
        System.out.println("Opcion invalida, regresando al menu.");
        return null;
    }

    public static void menu_inicio(){
        Scanner scanner = new Scanner(System.in);
        byte eleccion_usuario;
        do {
            System.out.println("[1] Registrar Nuevo Grupo\n[2] Registrar nueva asignatura [3] Lista de grupos actuales\n[4] Terminar sesion");
            eleccion_usuario = scanner.nextByte();
            switch (eleccion_usuario){
                case 1 -> registrarNuevoGrupo();
                case 2 -> Asignatura.AnadirAsignatura();
                case 3 -> imprimirGrupos();
                case 4 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opcion invalida.");
            }
        }
        while (eleccion_usuario != 4);
    }

    private static void registrarNuevoGrupo() {
        Scanner scannerMateria = new Scanner(System.in);

        System.out.println("Que profesor desea que imparta el grupo? :");
        Profesor profesorGrupo = selectorDeProfesores();
        profesorGrupo.asignaturasProfesorImprimir();

        System.out.println("Clave de la asignatura a impartir: ");
        int claveAsignatura = scannerMateria.nextInt();
        Grupo nuevoGrupo = new Grupo (claveAsignatura,profesorGrupo.getNombre());

        grupos.add(nuevoGrupo);
    }

    private static Profesor selectorDeProfesores(){
        Scanner scanner = new Scanner(System.in);

        HashMap<String,Profesor> profes = Profesor.getProfesores();
        Set<String> clave = profes.keySet();
        ArrayList<String> claves = new ArrayList<>(clave);

        for(int i = 0; i < profes.size(); i++)
            System.out.println("["+i+"]"+ claves.get(i));

        int eleccionUsuario = scanner.nextInt();
        return Profesor.buscarProfesor(claves.get(eleccionUsuario));
    }


}
