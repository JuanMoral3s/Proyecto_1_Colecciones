import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Profesor {

    //ATRIBUTOS
    private String nombre;
    private List<Integer> asignaturas;
    public static HashMap<String, Profesor> profesores = new HashMap<>();

    //CONSTRUCTOR
    public Profesor(String nombre, List<Integer> asignaturas) {
        this.nombre = nombre;
        this.asignaturas = new ArrayList<>(asignaturas);
    }

    //GETTERS Y SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignatura(List<Integer> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getAsignaturas() {
        return asignaturas;
    }

    public static HashMap<String, Profesor> getProfesores() {
        return profesores;
    }

    //MÉTODO AGREAGAR ASIGNATURA A LA LISTA
    public void agregarAsignatura(Integer asignatura) {
        this.asignaturas.add(asignatura);

    }

    //MOSTRAR INFO
    public void printInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Asignaturas que imparte: ");
        for (Integer asignatura : this.asignaturas) {
            System.out.println("- " + asignatura);

        }
    }

    //AGREGAR PROFESOR CON HASHMAP
    private static void registrarNuevoProfesor() {
        Scanner scannerNombre = new Scanner(System.in);
        Scanner scannerAsignaturas = new Scanner(System.in);
        Profesor nuevoProfesor;
        System.out.println("Ingrese su nombre: ");
        String nombre = scannerNombre.nextLine();
        System.out.println("Cuantas materias imparte?: ");
        int numAsign = scannerAsignaturas.nextInt();
        scannerAsignaturas.nextLine();
        List<Integer> asignaturas = new ArrayList<>();
        for (int i = 0; i < numAsign; i++) {
            System.out.println("Ingrese la clave de la asignatura " + (i + 1) + " :");
            asignaturas.add( scannerAsignaturas.nextInt());
        }
        System.out.println("Salio");
        nuevoProfesor = new Profesor(nombre, asignaturas);
        profesores.put(nombre, nuevoProfesor);

    }

    public static void anadir_a_lista(String nombre, List<Integer> materias) {
        Profesor nuevo_Profesor = new Profesor(nombre, materias);
        profesores.put(nombre, nuevo_Profesor);

    }

    public static void menu_inicio(){
        Scanner scanner = new Scanner(System.in);
        byte eleccion_usuario;
        Profesor sesion_actual = null;
        do {
            System.out.println("[1] Registrar Nuevo Profesor\n[2] Lista de profesores actuales\n[3] Terminar sesion");
            eleccion_usuario = scanner.nextByte();
            switch (eleccion_usuario){
                case 1 -> registrarNuevoProfesor();
                case 2 -> imprimirProfes();
                case 3 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opcion invalida.");
            }
        }
        while (eleccion_usuario != 3);
    }

    public static void imprimirProfes() {
        System.out.println("PROFES INSANOS: ");
        for (Profesor profesor : profesores.values()) {
            System.out.println("----------------------");
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("Asignaturas insanas que da: ");
            for (int i = 0; i < profesor.getAsignaturas().size(); i++){
                System.out.print("Clave: " +profesor.getAsignaturas().get(i));
                System.out.println(" Asignatura: "+ Asignatura.asignaturaPorClave(profesor.getAsignaturas().get(i)));
            }
        }
        System.out.println("-----------------------");
    }

    public static Profesor buscarProfesor(String profesor){
        return profesores.get(profesor);
    }

    public void asignaturasProfesorImprimir(){
        for(int i = 0; i < this.getAsignaturas().size(); i++){
            System.out.print("Clave: " + this.getAsignaturas().get(i));
            System.out.println(" Asignatura : "+ Asignatura.asignaturaPorClave(this.getAsignaturas().get(i)));
        }
    }


}